package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.StatusFrete;
import br.com.uniamerica.transportadora.repository.DespesaRepository;
import br.com.uniamerica.transportadora.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.util.Assert;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private HistoricoFreteService historicoFreteService;

    public boolean checkCamposFreteIsNull(Frete frete) {
        if (frete.getCaminhao() == null || frete.getProduto() == null || frete.getMotorista() == null || frete.getCidadeOrigem() == null
                || frete.getCidadeDestino() == null || frete.getPrecoTonelada() == null) {
            return false;
        }else {
            return true;
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public Frete save(Frete frete) {
        Assert.isTrue(checkCamposFreteIsNull(frete), "Erro, algum campo do frete é nulo");
        //this.historicoFreteService.cadastrar(frete, StatusFrete.CARGA);
        frete.setStatusFrete(StatusFrete.CARGA);
        System.out.println(frete);
        return this.freteRepository.save(frete);
    }

    public List<Frete> listAll() {
        return this.freteRepository.findAll();
    }

    public Frete findById(Long id) {
        return this.freteRepository.findById(id).orElse(new Frete());
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(Long id, Frete frete) {
        if(id == frete.getId()) {
            this.freteRepository.save(frete);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusCargaParaEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.CARGA),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em carga.");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusInterrompidoParaEmTransporte(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de interrompido.");

        frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusEmTransporteParaInterrompido(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em transporte.");

        frete.setStatusFrete(StatusFrete.INTERROMPIDO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.INTERROMPIDO);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusEmTransporteParaDescarga(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.EM_TRANSPORTE),
                "Não é possível iniciar o transporte do frete, pois seu status é diferente de em transporte.");

        frete.setStatusFrete(StatusFrete.DESCARGA);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.DESCARGA);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusFaturado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.DESCARGA),
                "Não é possível faturar um frete que não está com o status de descarga.");

        final List<Despesa> despesa = this.despesaRepository.findByFreteAndAprovadorIsNull(frete.getId());

        Assert.isTrue(despesa.size() == 0,
                "Não é possível faturar um frete com despesas abertas.");

        frete.setStatusFrete(StatusFrete.FATURADO);
        this.freteRepository.save(frete);

        this.historicoFreteService.cadastrar(frete, StatusFrete.FATURADO);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void atualizarStatusCancelado(final Long idFrete) {

        final Frete frete = this.freteRepository.findById(idFrete).orElse(null);

        Assert.isTrue(frete != null, "Não foi possível localizar o frete informado.");

        try {
            if (frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO)
                    || frete.getStatusFrete().equals(StatusFrete.CARGA)) {
                frete.setStatusFrete(StatusFrete.CANCELADO);
                this.freteRepository.save(frete);
                this.historicoFreteService.cadastrar(frete, StatusFrete.CANCELADO);
            }
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

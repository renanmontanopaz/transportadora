package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import br.com.uniamerica.transportadora.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Transactional
    public Cidade save(Cidade cidade) {
        return this.cidadeRepository.save(cidade);
    }

    public List<Cidade> listAll() {
        return this.cidadeRepository.findAll();
    }

    public Cidade findById(Long id) {
        return this.cidadeRepository.findById(id).orElse(new Cidade());
    }

    @Transactional
    public void update(Long id, Cidade cidade) {
        if(id == cidade.getId()) {
            this.cidadeRepository.save(cidade);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, Cidade cidade){
        if (id == cidade.getId()) {
            this.cidadeRepository.disable(cidade.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

    @Query("FROM Cidade cidade WHERE cidade.estado.id = :idEstado")
    public List<Cidade> findByEstado(Long id) {
        return this.cidadeRepository.findByEstado(id);
    }

}

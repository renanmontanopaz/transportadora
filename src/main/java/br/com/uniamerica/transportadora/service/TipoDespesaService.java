package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import br.com.uniamerica.transportadora.repository.TipoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDespesaService {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

    public void atualizar(final Long id, final TipoDespesa nome){
        if(id.equals(nome.getId()) && !this.tipoDespesaRepository.findById(id).isEmpty()){
            this.tipoDespesaRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final TipoDespesa nome){
        if (id.equals(nome.getId()) && !this.tipoDespesaRepository.findById(id).isEmpty()){
            this.tipoDespesaRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

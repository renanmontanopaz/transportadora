package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    public void atualizar(final Long id, final Frete produto){
        if(id.equals(produto.getId()) && !this.freteRepository.findById(id).isEmpty()){
            this.freteRepository.save(produto);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Frete produto){
        if (id.equals(produto.getId()) && !this.freteRepository.findById(id).isEmpty()){
            this.freteRepository.delete(produto);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

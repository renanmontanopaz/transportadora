package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public void atualizar(final Long id, final Caminhao caminhao){
        if(id.equals(caminhao.getId()) && !this.caminhaoRepository.findById(id).isEmpty()){
            this.caminhaoRepository.save(caminhao);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Caminhao caminhao){
        if (id.equals(caminhao.getId()) && !this.caminhaoRepository.findById(id).isEmpty()){
            this.caminhaoRepository.delete(caminhao);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

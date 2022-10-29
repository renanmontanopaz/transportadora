package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.repository.DespesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    private DespesaRepository despesaRepository;

    public void atualizar(final Long id, final Despesa despesa){
        if(id.equals(despesa.getId()) && !this.despesaRepository.findById(id).isEmpty()){
            this.despesaRepository.save(despesa);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Despesa despesa){
        if (id.equals(despesa.getId()) && !this.despesaRepository.findById(id).isEmpty()){
            this.despesaRepository.delete(despesa);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

}

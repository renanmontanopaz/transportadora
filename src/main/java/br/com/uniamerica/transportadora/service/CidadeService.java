package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void atualizar(final Long id, final Cidade nome){
        if(id.equals(nome.getId()) && !this.cidadeRepository.findById(id).isEmpty()){
            this.cidadeRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Cidade nome){
        if (id.equals(nome.getId()) && !this.cidadeRepository.findById(id).isEmpty()){
            this.cidadeRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

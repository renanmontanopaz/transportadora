package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public void atualizar(final Long id, final Modelo nome){
        if(id.equals(nome.getId()) && !this.modeloRepository.findById(id).isEmpty()){
            this.modeloRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Modelo nome){
        if (id.equals(nome.getId()) && !this.modeloRepository.findById(id).isEmpty()){
            this.modeloRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

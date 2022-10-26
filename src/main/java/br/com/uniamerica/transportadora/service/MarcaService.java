package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public void atualizar(final Long id, final Marca nome){
        if(id.equals(nome.getId()) && !this.marcaRepository.findById(id).isEmpty()){
            this.marcaRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Marca nome){
        if (id.equals(nome.getId()) && !this.marcaRepository.findById(id).isEmpty()){
            this.marcaRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

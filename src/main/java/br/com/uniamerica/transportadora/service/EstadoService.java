package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public void atualizar(final Long id, final Estado estado){
        if(id.equals(estado.getId()) && !this.estadoRepository.findById(id).isEmpty()){
            this.estadoRepository.save(estado);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Estado estado){
        if (id.equals(estado.getId()) && !this.estadoRepository.findById(id).isEmpty()){
            this.estadoRepository.delete(estado);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

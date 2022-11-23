package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional
    public Modelo save(Modelo modelo) {
        return this.modeloRepository.save(modelo);
    }

    public List<Modelo> listAll() {
        return this.modeloRepository.findAll();
    }

    public Modelo findById(Long id) {
        return this.modeloRepository.findById(id).orElse(new Modelo());
    }

    @Transactional
    public void update(Long id, Modelo modelo) {
        if(id == modelo.getId()) {
            this.modeloRepository.save(modelo);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, Modelo modelo){
        if (id == modelo.getId()) {
            this.modeloRepository.disable(modelo.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<Modelo> findByMarca(Long id) {
        return this.modeloRepository.findByMarca(id);
    }

}

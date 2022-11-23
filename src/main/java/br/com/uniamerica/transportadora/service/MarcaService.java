package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional
    public Marca save(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    public List<Marca> listAll() {
        return this.marcaRepository.findAll();
    }

    public Marca findById(Long id) {
        return this.marcaRepository.findById(id).orElse(new Marca());
    }

    @Transactional
    public void update(Long id, Marca marca) {
        if(id == marca.getId()) {
            this.marcaRepository.save(marca);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void disable(Long id, Marca marca){
        if (id == marca.getId()) {
            this.marcaRepository.disable(marca.getId());
        }
        else {
            throw new RuntimeException();
        }
    }

}

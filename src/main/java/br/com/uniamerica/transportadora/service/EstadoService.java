package br.com.uniamerica.transportadora.service;

import br.com.uniamerica.transportadora.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


}

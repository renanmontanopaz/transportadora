package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HistoricoFreteController {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;
}

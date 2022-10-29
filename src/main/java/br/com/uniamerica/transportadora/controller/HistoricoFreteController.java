package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import br.com.uniamerica.transportadora.repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class HistoricoFreteController {

    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @GetMapping("/filtro")
    public ResponseEntity<List<HistoricoFrete>> findAll(
            @RequestParam("frete") final Frete frete
    ){
        return ResponseEntity.ok().body(this.historicoFreteRepository.findByFrete(frete));
    }
}

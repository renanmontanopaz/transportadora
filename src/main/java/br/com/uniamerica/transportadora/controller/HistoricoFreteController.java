package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import br.com.uniamerica.transportadora.repository.HistoricoFreteRepository;
import br.com.uniamerica.transportadora.service.HistoricoFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/historico-frete")
public class HistoricoFreteController {

    @Autowired
    private HistoricoFreteService historicoFreteService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody HistoricoFrete historicoFrete
    ){
        try{
            this.historicoFreteService.save(historicoFrete);
            return ResponseEntity.ok().body("Histórico do frete cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<HistoricoFrete>> listAll(

    ){
        return ResponseEntity.ok().body(this.historicoFreteService.listAll());
    }

    @GetMapping("/{idHistoricoFrete}")
    public ResponseEntity<HistoricoFrete> findById(
            @PathVariable("idHistoricoFrete") Long idHistoricoFrete
    ){
        return ResponseEntity.ok().body(this.historicoFreteService.findById(idHistoricoFrete));
    }

    @GetMapping("/frete/{idFrete}")
    public ResponseEntity<?> findByFrete(@PathVariable("idFrete") Long idFrete) {
        return ResponseEntity.ok().body(this.historicoFreteService.findByFrete(idFrete));
    }

}

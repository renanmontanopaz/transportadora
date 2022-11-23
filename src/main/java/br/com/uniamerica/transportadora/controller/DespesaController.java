package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.repository.DespesaRepository;
import br.com.uniamerica.transportadora.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.save(despesa);
            return ResponseEntity.ok().body("Despesa cadastrada!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listAll(

    ){
        return ResponseEntity.ok().body(this.despesaService.listAll());
    }

    @GetMapping("/{idDespesa}")
    public ResponseEntity<Despesa> findById(
            @PathVariable("idDespesa") Long idDespesa
    ){
        return ResponseEntity.ok().body(this.despesaService.findById(idDespesa));
    }

    @PutMapping("/{idDespesa}")
    public ResponseEntity<?> update(
            @PathVariable Long idDespesa,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.update(idDespesa, despesa);
            return ResponseEntity.ok().body("Despesa atualizada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idDespesa}")
    public ResponseEntity<?> disable(
            @PathVariable Long idDespesa,
            @RequestBody Despesa despesa
    ){
        try{
            this.despesaService.disable(idDespesa, despesa);
            return ResponseEntity.ok().body("Despesa desativada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/aprovador/{idAprovador}")
    public ResponseEntity<?> findByAprovadorIsNull(@PathVariable("idAprovador") Long idAprovador) {
        return ResponseEntity.ok().body(this.despesaService.findByAprovadorIsNull(idAprovador));
    }

}

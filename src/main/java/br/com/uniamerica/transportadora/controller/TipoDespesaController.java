package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import br.com.uniamerica.transportadora.service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tipo-despesa")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaService tipoDespesaService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody TipoDespesa tipoDespesa
    ){
        try{
            this.tipoDespesaService.save(tipoDespesa);
            return ResponseEntity.ok().body("Tipo da despesa cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoDespesa>> listAll(

    ){
        return ResponseEntity.ok().body(this.tipoDespesaService.listAll());
    }

    @GetMapping("/{idTipoDespesa}")
    public ResponseEntity<TipoDespesa> findById(
            @PathVariable("idTipoDespesa") Long idTipoDespesa
    ){
        return ResponseEntity.ok().body(this.tipoDespesaService.findById(idTipoDespesa));
    }

    @PutMapping("/{idTipoDespesa}")
    public ResponseEntity<?> update(
            @PathVariable Long idTipoDespesa,
            @RequestBody TipoDespesa tipoDespesa
    ){
        try{
            this.tipoDespesaService.update(idTipoDespesa, tipoDespesa);
            return ResponseEntity.ok().body("Tipo da despesa atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idTipoDespesa}")
    public ResponseEntity<?> disable(
            @PathVariable Long idTipoDespesa,
            @RequestBody TipoDespesa tipoDespesa
    ){
        try{
            this.tipoDespesaService.disable(idTipoDespesa, tipoDespesa);
            return ResponseEntity.ok().body("Tipo da despesa desativada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

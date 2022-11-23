package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.repository.CidadeRepository;
import br.com.uniamerica.transportadora.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.save(cidade);
            return ResponseEntity.ok().body("Cidade cadastrada!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listAll(

    ){
        return ResponseEntity.ok().body(this.cidadeService.listAll());
    }

    @GetMapping("/{idCidade}")
    public ResponseEntity<Cidade> findById(
            @PathVariable("idCidade") Long idCidade
    ){
        return ResponseEntity.ok().body(this.cidadeService.findById(idCidade));
    }

    @PutMapping("/{idCidade}")
    public ResponseEntity<?> update(
            @PathVariable Long idCidade,
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.update(idCidade, cidade);
            return ResponseEntity.ok().body("Cidade atualizada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idCidade}")
    public ResponseEntity<?> disable(
            @PathVariable Long idCidade,
            @RequestBody Cidade cidade
    ){
        try{
            this.cidadeService.disable(idCidade, cidade);
            return ResponseEntity.ok().body("Cidade desativada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/estado/{idEstado}")
    public ResponseEntity<?> findByEstado(@PathVariable("idEstado") Long idEstado) {
        return ResponseEntity.ok().body(this.cidadeService.findByEstado(idEstado));
    }

}

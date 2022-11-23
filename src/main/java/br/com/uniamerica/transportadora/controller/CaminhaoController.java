package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.save(caminhao);
            return ResponseEntity.ok().body("Caminhão cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Caminhao>> listAll(

    ){
        return ResponseEntity.ok().body(this.caminhaoService.listAll());
    }

    @GetMapping("/{idCaminhao}")
    public ResponseEntity<Caminhao> findById(
            @PathVariable("idCaminhao") Long idCaminhao
    ){
        return ResponseEntity.ok().body(this.caminhaoService.findById(idCaminhao));
    }

    @PutMapping("/{idCaminhao}")
    public ResponseEntity<?> update(
            @PathVariable Long idCaminhao,
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.update(idCaminhao, caminhao);
            return ResponseEntity.ok().body("Caminhão atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idCaminhao}")
    public ResponseEntity<?> disable(
            @PathVariable Long idCaminhao,
            @RequestBody Caminhao caminhao
    ){
        try{
            this.caminhaoService.disable(idCaminhao, caminhao);
            return ResponseEntity.ok().body("Caminhão desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

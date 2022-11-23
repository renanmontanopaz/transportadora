package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Marca marca
    ){
        try{
            this.marcaService.save(marca);
            return ResponseEntity.ok().body("Marca cadastrada!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Marca>> listAll(

    ){
        return ResponseEntity.ok().body(this.marcaService.listAll());
    }

    @GetMapping("/{idMarca}")
    public ResponseEntity<Marca> findById(
            @PathVariable("idMarca") Long idMarca
    ){
        return ResponseEntity.ok().body(this.marcaService.findById(idMarca));
    }

    @PutMapping("/{idMarca}")
    public ResponseEntity<?> update(
            @PathVariable Long idMarca,
            @RequestBody Marca marca
    ){
        try{
            this.marcaService.update(idMarca, marca);
            return ResponseEntity.ok().body("Marca atualizada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idMarca}")
    public ResponseEntity<?> disable(
            @PathVariable Long idMarca,
            @RequestBody Marca marca
    ){
        try{
            this.marcaService.disable(idMarca, marca);
            return ResponseEntity.ok().body("Marca desativada com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.repository.MarcaRepository;
import br.com.uniamerica.transportadora.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.marcaRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Marca>> findAll(
            @RequestParam("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.marcaRepository.findByLikeNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Marca nome){
        this.marcaRepository.save(nome);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Marca nome
    ){
        try{
            this.marcaService.atualizar(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Marca nome
    ){
        try{
            this.marcaService.excluir(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

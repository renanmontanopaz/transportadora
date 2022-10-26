package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.repository.EstadoRepository;
import br.com.uniamerica.transportadora.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.estadoRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Estado>> findAll(
            @RequestParam("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.estadoRepository.findByLikeNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Estado estado){
        this.estadoRepository.save(estado);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Estado estado
    ){
        try{
            this.estadoService.atualizar(id, estado);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Estado estado
    ){
        try{
            this.estadoService.excluir(id, estado);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }

}

package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.repository.ProdutoRepository;
import br.com.uniamerica.transportadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.produtoRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Produto>> findAll(
            @RequestParam("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.produtoRepository.findByLikeNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Produto nome){
        this.produtoRepository.save(nome);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Produto nome
    ){
        try{
            this.produtoService.atualizar(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Produto nome
    ){
        try{
            this.produtoService.excluir(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

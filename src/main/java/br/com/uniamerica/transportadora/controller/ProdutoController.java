package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.save(produto);
            return ResponseEntity.ok().body("Produto cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listAll(

    ){
        return ResponseEntity.ok().body(this.produtoService.listAll());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> findById(
            @PathVariable("idProduto") Long idProduto
    ){
        return ResponseEntity.ok().body(this.produtoService.findById(idProduto));
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<?> update(
            @PathVariable Long idProduto,
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.update(idProduto, produto);
            return ResponseEntity.ok().body("Produto atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idProduto}")
    public ResponseEntity<?> disable(
            @PathVariable Long idProduto,
            @RequestBody Produto produto
    ){
        try{
            this.produtoService.disable(idProduto, produto);
            return ResponseEntity.ok().body("Produto desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

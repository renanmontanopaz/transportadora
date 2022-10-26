package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import br.com.uniamerica.transportadora.repository.TipoDespesaRepository;
import br.com.uniamerica.transportadora.service.TipoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class TipoDespesaController {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;
    @Autowired
    private TipoDespesaService tipoDespesaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.tipoDespesaRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<TipoDespesa>> findAll(
            @RequestParam("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.tipoDespesaRepository.findByLikeNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final TipoDespesa nome){
        this.tipoDespesaRepository.save(nome);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final TipoDespesa nome
    ){
        try{
            this.tipoDespesaService.atualizar(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final TipoDespesa nome
    ){
        try{
            this.tipoDespesaService.excluir(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

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
@RequestMapping
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.despesaRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Despesa>> findAll(
            @RequestParam("motorista") final String motorista
    ){
        return ResponseEntity.ok().body(this.despesaRepository.findByLikeMotoristaAndAtivoTrue(motorista));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Despesa tipoDespesa,Despesa aprovador,Despesa motorista, Despesa data, Despesa valor, Despesa frete){
        this.despesaRepository.save(tipoDespesa);
        this.despesaRepository.save(aprovador);
        this.despesaRepository.save(motorista);
        this.despesaRepository.save(data);
        this.despesaRepository.save(valor);
        this.despesaRepository.save(frete);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Despesa despesa
    ){
        try{
            this.despesaService.atualizar(id, despesa);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Despesa despesa
    ){
        try{
            this.despesaService.excluir(id, despesa);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

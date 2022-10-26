package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.repository.CaminhaoRepository;
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
    private CaminhaoRepository caminhaoRepository;
    private CaminhaoService caminhaoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.caminhaoRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Caminhao>> findAll(
            @RequestParam("modelo") final Modelo modelo
    ){
        return ResponseEntity.ok().body(this.caminhaoRepository.findByLikeNomeAndAtivoTrue(modelo));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Caminhao placa, final Caminhao modelo, final Caminhao ano, Caminhao cor, Caminhao observacao){
        this.caminhaoRepository.save(placa);
        this.caminhaoRepository.save(modelo);
        this.caminhaoRepository.save(ano);
        this.caminhaoRepository.save(cor);
        this.caminhaoRepository.save(observacao);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Caminhao caminhao
    ){
        try{
            this.caminhaoService.atualizar(id, caminhao);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Caminhao caminhao
    ){
        try{
            this.caminhaoService.excluir(id, caminhao);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

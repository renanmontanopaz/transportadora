package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.repository.CaminhaoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @GetMapping
    public ResponseEntity<List<Caminhao>> findAll(){
        return ResponseEntity.ok().body(this.caminhaoRepository.findByAtivoTrue());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Caminhao placa, final Caminhao modelo, final Caminhao ano){
        this.caminhaoRepository.save(placa);
        this.caminhaoRepository.save(modelo);
        this.caminhaoRepository.save(ano);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }
}

package br.com.uniamerica.transportadora.controller;

import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.save(usuario);
            return ResponseEntity.ok().body("Usuário cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAll(

    ){
        return ResponseEntity.ok().body(this.usuarioService.listAll());
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> findById(
            @PathVariable("idUsuario") Long idUsuario
    ){
        return ResponseEntity.ok().body(this.usuarioService.findById(idUsuario));
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> update(
            @PathVariable Long idUsuario,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.update(idUsuario, usuario);
            return ResponseEntity.ok().body("Usuário atualizado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/ativo/{idUsuario}")
    public ResponseEntity<?> disable(
            @PathVariable Long idUsuario,
            @RequestBody Usuario usuario
    ){
        try{
            this.usuarioService.disable(idUsuario, usuario);
            return ResponseEntity.ok().body("Usuário desativado com sucesso!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

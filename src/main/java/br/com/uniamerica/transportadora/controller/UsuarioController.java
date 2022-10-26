package br.com.uniamerica.transportadora.controller;
import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.repository.UsuarioRepository;
import br.com.uniamerica.transportadora.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(this.usuarioRepository.findByAtivoTrue());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Usuario>> findAll(
            @RequestParam("nome") final String nome
    ){
        return ResponseEntity.ok().body(this.usuarioRepository.findByLikeNomeAndAtivoTrue(nome));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Usuario nome, Usuario percGanho, Usuario login, Usuario senha, Usuario grupo, Usuario cpf, Usuario telefone, Usuario dataNascimento, Usuario endereco, Usuario observacao){
        this.usuarioRepository.save(nome);
        this.usuarioRepository.save(percGanho);
        this.usuarioRepository.save(login);
        this.usuarioRepository.save(senha);
        this.usuarioRepository.save(grupo);
        this.usuarioRepository.save(cpf);
        this.usuarioRepository.save(telefone);
        this.usuarioRepository.save(dataNascimento);
        this.usuarioRepository.save(endereco);
        this.usuarioRepository.save(observacao);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody final Usuario nome
    ){
        try{
            this.usuarioService.atualizar(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso...");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Usuario nome
    ){
        try{
            this.usuarioService.excluir(id, nome);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro excluído com sucesso...");
    }
}

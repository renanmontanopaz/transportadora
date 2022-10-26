package br.com.uniamerica.transportadora.service;
import br.com.uniamerica.transportadora.Entity.Usuario;
import br.com.uniamerica.transportadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void atualizar(final Long id, final Usuario nome){
        if(id.equals(nome.getId()) && !this.usuarioRepository.findById(id).isEmpty()){
            this.usuarioRepository.save(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }

    public void excluir(final Long id, final Usuario nome){
        if (id.equals(nome.getId()) && !this.usuarioRepository.findById(id).isEmpty()){
            this.usuarioRepository.delete(nome);
        } else{
            throw new RuntimeException("Id não encontrado");
        }
    }
}

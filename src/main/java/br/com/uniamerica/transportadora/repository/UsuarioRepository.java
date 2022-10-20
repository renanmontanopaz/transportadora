package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("from Usuario where ativo = :ativo")
    public List<Usuario> findByAtivo(@Param("ativo") final boolean ativo);
}

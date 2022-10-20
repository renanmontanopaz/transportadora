package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("from Cidade where ativo = :ativo")
    public List<Cidade> findByAtivo(@Param("ativo") final boolean ativo);


    public List<Cidade> findByEstado(@Param("estado") final Estado estado);
}

package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query("from Modelo where ativo = :ativo")
    public List<Modelo> findByAtivo(@Param("ativo") final boolean ativo);
}

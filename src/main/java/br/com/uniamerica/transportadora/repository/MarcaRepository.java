package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Query("from Estado where ativo = :ativo")
    public List<Marca> findByAtivo(@Param("ativo") final boolean ativo);

}

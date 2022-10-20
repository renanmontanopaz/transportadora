package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreteRepository extends JpaRepository<Frete, Long> {

    @Query("from Frete where ativo = :ativo")
    public List<Frete> findByAtivo(@Param("ativo") final boolean ativo);
}

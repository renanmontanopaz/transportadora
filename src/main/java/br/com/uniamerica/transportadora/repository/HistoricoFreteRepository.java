package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Estado;
import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoricoFreteRepository extends JpaRepository<HistoricoFrete, Long> {
    @Query("from Estado where ativo = :ativo")
    public List<HistoricoFrete> findByAtivo(@Param("ativo") final boolean ativo);

    public List<HistoricoFrete> findByFrete(@Param("frete") final Frete Frete);
}

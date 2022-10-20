package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

    @Query("from TipoDespesa where ativo = :ativo")
    public List<TipoDespesa> findByAtivo(@Param("ativo") final boolean ativo);
}

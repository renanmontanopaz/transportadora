package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.HistoricoFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFrete, Long> {

    @Query("SELECT hf FROM HistoricoFrete hf WHERE hf.ativo = true")
    List<Optional<HistoricoFrete>> findByAtivo();

    @Query("SELECT hf FROM HistoricoFrete hf WHERE hf.frete = :frete")
    List<Optional<Frete>> findByFrete(Frete frete);

    @Query("FROM HistoricoFrete historicoFrete WHERE historicoFrete.frete.id = :idFrete")
    public List<HistoricoFrete> findByFrete(@Param("idFrete") Long idFrete);

}

package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

    @Query("SELECT tpd FROM TipoDespesa tpd WHERE tpd.ativo = true")
    List<Optional<TipoDespesa>> findByAtivo();

    @Modifying
    @Query("UPDATE TipoDespesa tipoDespesa SET tipoDespesa.ativo = false WHERE tipoDespesa.id = :idTipoDespesa")
    public void disable(@Param("idTipoDespesa") Long id);

}

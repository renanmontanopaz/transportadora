package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT des FROM Despesa des WHERE des.ativo = true")
    List<Optional<Despesa>> findByAtivo();

    @Query("SELECT d FROM Despesa d WHERE d.motorista = :motorista")
    List<Optional<Despesa>>findByMotorista(Usuario motorista);

    @Query("SELECT des FROM Despesa des WHERE des.frete.caminhao = :caminhao")
    List<Optional<Despesa>>findByCaminhao(Caminhao caminhao);

    @Query("SELECT d FROM Despesa d WHERE d.frete = :frete")
    List<Optional<Despesa>>findByFrete(Frete frete);

    @Query("SELECT d FROM Despesa d WHERE d.tipoDespesa = :tipoDespesa AND d.motorista = :motorista" +
            " AND d.frete.caminhao = :caminhao")
    List<Optional<Despesa>>findBySoma(TipoDespesa tipoDespesa, Usuario motorista, Caminhao caminhao);

    @Query("SELECT d FROM Despesa d WHERE d.aprovador = :aprovador")
    List<Optional<Despesa>>findByAprovador(Usuario aprovador);

    @Query("SELECT d FROM Despesa d WHERE d.aprovada = false")
    List<Optional<Despesa>>findByNaoAprovadas();

    @Query("SELECT d FROM Despesa d WHERE d.aprovador IS NULL AND d.id = :idAprovador")
    public List<Despesa> findByAprovadorIsNull(@Param("idAprovador") Long idAprovador);

    @Modifying
    @Query("UPDATE Despesa despesa SET despesa.ativo = false WHERE despesa.id = :idDespesa")
    public void disable(@Param("idDespesa") Long id);

    @Query("FROM Despesa despesa WHERE despesa.frete.id = :idFrete AND despesa.ativo = true " +
            "AND despesa.aprovada = false")
    public List<Despesa> findByFreteAndAprovadorIsNull(@Param("idFrete") Long idFrete);

}

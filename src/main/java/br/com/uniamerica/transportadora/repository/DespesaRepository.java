package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT d FROM Despesa d WHERE d.aprovador IS NULL AND d.id = :idAprovador")
    public List<Despesa> findByAprovadorIsNull(@Param("idAprovador") Long idAprovador);

    @Modifying
    @Query("UPDATE Despesa despesa SET despesa.ativo = false WHERE despesa.id = :idDespesa")
    public void disable(@Param("idDespesa") Long id);

    @Query("FROM Despesa despesa WHERE despesa.frete.id = :idFrete AND despesa.ativo = true " +
            "AND despesa.aprovada = false")
    public List<Despesa> findByFreteAndAprovadorIsNull(@Param("idFrete") Long idFrete);

    @Query(value = "select * from transportadora.tb_despesas" +
            "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Despesa> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);

}

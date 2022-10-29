package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Frete;
import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import br.com.uniamerica.transportadora.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {


    public List<Despesa> findByAtivoTrue();
    public List<Despesa> findByMotorista(@Param("Usuario") final Usuario motorista);

    @Query(value = "select * from transportadora.tb_despesa" + "where motorista ilike '%' || :motorista || '%' ", nativeQuery = true)
    public List<Despesa> findByLikeMotoristaAndAtivoTrue(@Param("motorista") final String motorista);

    public List<Despesa> findByTipoDespesa(final TipoDespesa tipoDespesa);
    public List<Despesa> findByValor(final BigDecimal valor);
    public List<Despesa> findByData(final LocalDateTime data);
    public List<Despesa> findByAprovadorIsNull(final Usuario aprovador);
    public List<Despesa> findByFrete(final Frete frete);

}

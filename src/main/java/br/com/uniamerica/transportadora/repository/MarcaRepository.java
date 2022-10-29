package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    public List<Marca> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_marca" + "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Marca> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);

    public List<Marca> findByNome(final String nome);
}

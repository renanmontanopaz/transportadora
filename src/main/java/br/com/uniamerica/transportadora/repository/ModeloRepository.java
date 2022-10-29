package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    public List<Modelo> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_modelo " + "where nome ilike '%' || :nome || '%'", nativeQuery = true)
    public List<Modelo> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
    public List<Modelo> findByNome(final String nome);
    public List<Modelo> findByMarca(final Marca marca);

}

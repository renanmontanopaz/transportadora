package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_cidade" + "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Cidade> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
    public List<Cidade> findByEstado(final Estado estado);
    public List<Cidade> findByNome(final String nome);
}

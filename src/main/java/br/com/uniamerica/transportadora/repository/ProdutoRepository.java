package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Modelo;
import br.com.uniamerica.transportadora.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_produto " + "where nome ilike '%' || :nome || '%'", nativeQuery = true)
    public List<Produto> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
    public List<Produto> findByNome(final String nome);

}

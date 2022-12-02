package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Modifying
    @Query("UPDATE Produto produto SET produto.ativo = false WHERE produto.id = :idProduto")
    public void disable(@Param("idProduto") Long id);

    public List<Produto> findByAtivoTrue();

}

package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("from Produto where ativo = :ativo")
    public List<Produto> findByAtivo(@Param("ativo") final boolean ativo);
}

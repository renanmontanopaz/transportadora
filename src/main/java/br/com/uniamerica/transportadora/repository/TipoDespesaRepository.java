package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Produto;
import br.com.uniamerica.transportadora.Entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

    public List<TipoDespesa> findByAtivoTrue();
    @Query(value = "select * from transportadora.tb_tipoDespesa " + "where nome ilike '%' || :nome || '%'", nativeQuery = true)
    public List<TipoDespesa> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);
    public List<TipoDespesa> findByNome(final String nome);
}

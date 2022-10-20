package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    @Query("from Estado where ativo = :ativo")
    public List<Caminhao> findByAtivo(@Param("ativo") final boolean ativo);

}

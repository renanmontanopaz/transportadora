package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.Cidade;
import br.com.uniamerica.transportadora.Entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT cid FROM Cidade cid WHERE cid.ativo = true")
    List<Optional<Cidade>> findByAtivo();

    @Query("SELECT est FROM Estado est WHERE est.estado = :estado")
    List<Optional<Estado>> findByEstado(Estado estado);

    @Query("FROM Cidade cidade WHERE cidade.estado.id = :idEstado")
    public List<Cidade> findByEstado(@Param("idEstado") Long idEstado);

    @Modifying
    @Query("UPDATE Cidade cidade SET cidade.ativo = false WHERE cidade.id = :idCidade")
    public void disable(@Param("idCidade") Long id);

}

package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query("FROM Modelo modelo WHERE modelo.marca.id = :idMarca")
    public List<Modelo> findByMarca(@Param("idMarca") Long idMarca);

    @Modifying
    @Query("UPDATE Modelo modelo SET modelo.ativo = false WHERE modelo.id = :idModelo")
    public void disable(@Param("idModelo") Long id);

}

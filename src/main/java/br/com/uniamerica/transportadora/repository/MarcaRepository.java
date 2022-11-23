package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Marca;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Query("SELECT ma FROM Marca ma WHERE ma.ativo = true")
    List<Optional<Marca>> findByAtivo();

    @Query("SELECT mo FROM Modelo mo WHERE mo.marca = :marca")
    List<Optional<Modelo>> findByModelo(Marca marca);

    @Modifying
    @Query("UPDATE Marca marca SET marca.ativo = false WHERE marca.id = :idMarca")
    public void disable(@Param("idMarca") Long id);
}

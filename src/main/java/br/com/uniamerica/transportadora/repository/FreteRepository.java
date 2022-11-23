package br.com.uniamerica.transportadora.repository;
import br.com.uniamerica.transportadora.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

    @Query("SELECT fret FROM Frete fret WHERE fret.ativo = true")
    List<Optional<Frete>> findByAtivo();

    @Query("SELECT fret FROM Frete fret WHERE fret.produto = :produto")
    List<Optional<Frete>>findByProduto(Produto produto);

    @Query("SELECT fret FROM Frete fret WHERE fret.statusFrete = :statusFrete")
    List<Optional<Frete>>findByStatus(String statusFrete);

    @Query("SELECT fret FROM Frete fret WHERE fret.motorista = :motorista")
    List<Optional<Frete>>findByMotorista(Usuario motorista);

    @Query("SELECT fret FROM Frete fret WHERE fret.cidadeOrigem = :cidadeOrigem")
    List<Optional<Frete>>findByOrigem(Cidade cidadeOrigem);

    @Query("SELECT fret FROM Frete fret WHERE fret.cidadeDestino = :cidadeDestino")
    List<Optional<Frete>>findByDestino(Cidade cidadeDestino);

    @Query("SELECT fret FROM Frete fret WHERE fret.caminhao = :caminhao")
    List<Optional<Frete>>findByCaminhao(Caminhao caminhao);

    @Query("SELECT fret FROM Frete fret WHERE fret.dataInicio = :dataInicio")
    List<Optional<Frete>>findByDataDe(LocalDateTime dataInicio);

    @Query("SELECT fret FROM Frete fret WHERE fret.dataFim = :dataFim")
    List<Optional<Frete>>findByDataAte(LocalDateTime dataFim);

}

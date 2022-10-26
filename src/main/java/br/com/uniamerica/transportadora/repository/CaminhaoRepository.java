package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Cor;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    public List<Caminhao> findByAtivoTrue();

    @Query(value = "select * from transportadora.tb_caminhoes " + "where modelo ilike '%' || :modelo || '%'", nativeQuery = true)
    public List<Caminhao> findByLikeNomeAndAtivoTrue(@Param("modelo") final Modelo modelo);
    public List<Caminhao> findByPlaca(final String placa);

    public List<Caminhao> findByModelo(final Modelo modelo);

    public List<Caminhao> findByAno(final Integer Ano);

    public List<Caminhao> findByCor(final Cor cor);

    public List<Caminhao> findByObservacao(final String observacao);
}

package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Caminhao;
import br.com.uniamerica.transportadora.Entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
    public List<Caminhao> findByAtivoTrue();
    public List<Caminhao> findByPlaca(final String placa);

    public List<Caminhao> findByModelo(final Modelo modelo);

    public List<Caminhao> findByAno(final Integer Ano);

}

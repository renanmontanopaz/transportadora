package br.com.uniamerica.transportadora.repository;

import br.com.uniamerica.transportadora.Entity.Despesa;
import br.com.uniamerica.transportadora.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {


    public List<Despesa> findByAtivoTrue();
    public List<Despesa> findByMotorista(@Param("Usuario") final Usuario motorista);

}

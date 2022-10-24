package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_modelo", schema = "transportadora")
public class Modelo extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "Nome", length = 30, nullable = false, unique = false)
    private String nome;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "marca", nullable=false)
    private Marca marca;
}

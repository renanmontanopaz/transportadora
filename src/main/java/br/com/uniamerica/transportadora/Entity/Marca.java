package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name= "tb_marca", schema = "transportadora")
public class Marca extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "Nome", length = 30, nullable = false, unique = true)
    private String nome;
}

package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado", schema = "transportadora")
public class Estado extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "Estado", length = 20, nullable = false, unique = true)
    private String estado;
}

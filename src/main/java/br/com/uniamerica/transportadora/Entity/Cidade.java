package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_cidade", schema="public", uniqueConstraints={
        @UniqueConstraint(
                columnNames={"nome", "id_estado"}
        )
})
public class Cidade extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "Nome", length = 30, nullable = false, unique = false)
    private String nome;
    @JoinColumn(name = "estado", nullable=false)
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    private Estado estado;
}

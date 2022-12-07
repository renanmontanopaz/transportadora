package br.com.uniamerica.transportadora.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cidade", schema = "transportadora",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"nome", "estado"}
                )
        }
)
public class Cidade extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "nome", length = 30, nullable = true, unique = false)
    private String nome;
    @JoinColumn(name = "estado", nullable=true)
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    private Estado estado;
}

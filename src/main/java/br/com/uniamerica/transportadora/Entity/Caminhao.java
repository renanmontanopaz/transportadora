package br.com.uniamerica.transportadora.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_caminhoes", schema = "transportadora")
public class Caminhao extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "PLaca", length = 15, nullable = false, unique = true)
    private String placa;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "modelo", nullable=false)
    private Modelo modelo;
    @Getter @Setter
    @Column(name = "Ano", length = 10, nullable = true, unique = false)
    private int ano;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name= "cor", length = 25, nullable = false)
    private Cor cor;
    @Getter @Setter
    @Column(name = "Observacao", length = 255, nullable = true, unique = false)
    private String observacao;
}

package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_HistoricoFrete", schema = "public")
public class HistoricoFrete extends AbstractEntity {

    @Getter
    @Setter
    private LocalDateTime data;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "frete", nullable=false)
    private Frete frete;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name= "status_Frete", length = 25, nullable = false)
    @JoinColumn(name = "statusFrete", nullable=false)
    private StatusFrete statusFrete;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "usuario", nullable=false)
    private Usuario executor;
}

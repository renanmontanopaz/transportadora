package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_fretes", schema = "transportadora")
public class Frete extends AbstractEntity {

    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter
    @Setter
    @JoinColumn(name = "produto", nullable=false)
    private Produto produto;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "cidadeOrigem", nullable=false)
    private Cidade cidadeOrigem;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "cidadeDestino", nullable=false)
    private Cidade cidadeDestino;
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @Getter @Setter
    @JoinColumn(name = "motorista", nullable=false)
    private Usuario motorista;
    @Getter @Setter
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name = "caminhao", nullable=false)
    private Caminhao caminhao;
    @Getter @Setter
    private StatusFrete statusFrete;
    @Getter @Setter
    @Column(name = "QuilometragemIni", nullable = false)
    private int quilometragemIni;
    @Getter @Setter
    @Column(name = "QuilometragemFim", nullable = false)
    private int quilometragemFim;
    @Getter @Setter
    @Column(name= "total_Bruto_Recebido_Nota", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalBrutoRecebidoNota;
    @Getter @Setter
    @Column(name= "total_Liquido_Recebido", nullable = false, precision = 5, scale = 3)
    private BigDecimal totalLiquidoRecebido;
    @Getter @Setter
    @Column(name= "peso_Inicial", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoInicial;
    @Getter @Setter
    @Column(name= "peso_Final", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinal;
    @Getter @Setter
    @Column(name= "peso_Final_Transportado", nullable = false, precision = 5, scale = 3)
    private BigDecimal pesoFinalTransportado;
    @Getter @Setter
    @Column(name= "preco_Tonelada", nullable = false, precision = 5, scale = 3)
    private BigDecimal precoTonelada;
    @Getter @Setter
    @Column(name= "Observacao", length = 50, nullable = false)
    private String observacao;
}

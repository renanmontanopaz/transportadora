package br.com.uniamerica.transportadora.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_usuario", schema = "public")
public class Usuario extends AbstractEntity{

    @Getter
    @Setter
    @Column(name= "perc_ganho", nullable = false, precision = 5, scale = 3)
    private BigDecimal percGanho;
    @Getter @Setter
    @Column(name= "login", length = 25, nullable = false, unique = true)
    private String login;
    @Getter @Setter
    @Column(name= "senha", length = 20, nullable = false)
    private String senha;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name= "grupo", length = 25, nullable = false)
    private Grupo grupo;
    @Column(name= "nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;
    @Getter @Setter
    @Column(name = "cpf", length = 16, nullable = false, unique = true)
    private String cpf;
    @Getter @Setter
    @Column(name = "telefone", length = 19, nullable = false, unique = true)
    private String telefone;
    @Getter @Setter
    @Column(name = "Data_nascimento", length = 15, nullable = false)
    private Date dataNascimento;
    @Getter @Setter
    @Column(name = "Endereco", length = 255, nullable = false, unique = true)
    private String endereco;
    @Getter @Setter
    @Column(name = "Observacao", length = 255, nullable = true, unique = false)
    private String observacao;
}

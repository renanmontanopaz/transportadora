package br.com.uniamerica.transportadora.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Column;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "Cadastrar", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime cadastrar;
    @Getter @Setter
    @Column(name = "Alterar", nullable = false)
    private LocalDateTime alterar;
    @Getter @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @PrePersist
    public void dataCadastrar(){
        this.setCadastrar(LocalDateTime.now());
        this.setAtivo(true);
    }

    @PreUpdate
    public void dataAlterar(){
        this.setAlterar(LocalDateTime.now());
    }
}

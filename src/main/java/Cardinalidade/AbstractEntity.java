package Cardinalidade;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @Getter @Setter
    private Long id;
    @Getter @Setter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;
    @Getter @Setter
    @Column(name = "atualizado", nullable = false)
    private LocalDateTime atualizado;
    @Getter @Setter
    @Column(name="ativo", nullable = false)
    private Boolean ativo;
}

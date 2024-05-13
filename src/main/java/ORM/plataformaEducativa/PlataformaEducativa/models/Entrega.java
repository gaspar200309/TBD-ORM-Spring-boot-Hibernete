package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "Entrega")
@Data
public class Entrega {

    @EmbeddedId
    private EntregaId id;

    @Column(name  = "comentario")
    private String comentario;

    @Column(name = "nota")
    private Integer nota;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @ManyToOne()
    @MapsId("ci")
    @JoinColumn(name = "ci")
    private Estudiante estudiante;

    @ManyToMany(mappedBy = "entregas")
    private Set<Tarea> tareas;
}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class EntregaId implements Serializable {

    @Column(name = "id_entrega")
    private Integer idEntrega;

    @Column(name = "ci")
    private Integer ci;

}

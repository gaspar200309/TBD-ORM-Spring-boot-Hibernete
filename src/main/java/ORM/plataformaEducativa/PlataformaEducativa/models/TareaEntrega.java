package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "tarea_entrega")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaEntrega {
    @EmbeddedId
    private TareaEntregaId id;

    @ManyToOne
    @MapsId("tareaId")
    @JoinColumns({
            @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea"),
            @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
    })
    private Tarea tarea;

    @ManyToOne
    @MapsId("entregaId")
    @JoinColumns({
            @JoinColumn(name = "id_entrega", referencedColumnName = "id_entrega"),
            @JoinColumn(name = "ci", referencedColumnName = "ci")
    })
    private Entrega entrega;
}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class TareaEntregaId implements Serializable {
    private TareaId tareaId;
    private EntregaId entregaId;
}
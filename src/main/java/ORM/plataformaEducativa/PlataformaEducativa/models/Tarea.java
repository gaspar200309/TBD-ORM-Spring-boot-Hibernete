package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

import java.util.Collection;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "tarea")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Tarea {

    @EmbeddedId
    private TareaId id;

    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @Column(name = "descripcion_tarea")
    private String descripcionTarea;

    @Column(name = "titulo_tarea")
    private String tituloTarea;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToMany
    @JoinTable(
            name = "tarea_entrega",
            joinColumns = {
                    @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea"),
                    @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_entrega", referencedColumnName = "id_entrega"),
                    @JoinColumn(name = "ci", referencedColumnName = "ci")
            }
    )
    private Set<Entrega> entregas;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private Set<Archivo> archivos;

    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private Set<Publicacion> publicacion;

}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class TareaId implements Serializable {

    @Column(name = "id_tarea")
    private Integer idTarea;

    @Column(name = "curso_id")
    private Integer cursoId;

}

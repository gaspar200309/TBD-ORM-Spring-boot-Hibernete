package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "publicacion")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private long idPublicacion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea"),
            @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
    })
    private Tarea tarea;
}

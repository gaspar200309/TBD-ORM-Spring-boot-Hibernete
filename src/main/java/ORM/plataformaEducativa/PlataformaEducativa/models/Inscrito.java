package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Inscrito")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Inscrito {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

}

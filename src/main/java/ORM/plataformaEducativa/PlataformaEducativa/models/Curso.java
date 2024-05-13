package ORM.plataformaEducativa.PlataformaEducativa.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Curso")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private int idCurso;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    @ManyToOne
    @JoinColumn(name = "docente_ci", referencedColumnName = "CI")
    private Docente docenteCi;

    @OneToMany(mappedBy = "curso")
    private List<Tarea> tarea;
}

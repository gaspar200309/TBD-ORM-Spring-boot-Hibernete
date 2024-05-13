package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrera_id")
    private int id;

    @Column(name = "nombre_carrera")
    private String nombreCarrera;
}

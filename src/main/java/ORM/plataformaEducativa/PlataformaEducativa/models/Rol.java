package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table (name = "rol")
@Data @AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int RolId;

    @Column(name = "nombre_rol")
    private String nombre;

    @Column(name = "Activo_rol")
    private boolean activoRol;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "rol_function",
            joinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id "),
            inverseJoinColumns = @JoinColumn(name = "funcion_id", referencedColumnName = "funcion_id")
    )
    private Collection<Funcion> rol_function;
}



package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "funcion" )
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcion_id")
    private int id;

    @Column(name = "nombre_funcion")
    private String nombre;

    @Column(name = "Activo_funcion")
    private boolean activacionFuncion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "function_ui",
            joinColumns = @JoinColumn(name = "function_id", referencedColumnName = "funcion_id"),
            inverseJoinColumns = @JoinColumn(name = "ui_id", referencedColumnName = "ui_id")
    )
    private Collection<Ui> ui_function;

}

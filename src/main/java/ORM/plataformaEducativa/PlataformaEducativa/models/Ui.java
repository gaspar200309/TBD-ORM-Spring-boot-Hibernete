package ORM.plataformaEducativa.PlataformaEducativa.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "Ui")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Ui {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ui_id")
    private int UiId;

    @Column(name = "nombre_ui")
    private String nombreUi;

    @Column(name = "activo_ui")
    private boolean activoUi;

}

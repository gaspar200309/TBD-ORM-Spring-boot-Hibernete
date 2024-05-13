package ORM.plataformaEducativa.PlataformaEducativa.models;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Archivo")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Archivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "archivo_id")
    private long archivoId;

    @ManyToOne
    @JoinColumn(name = "id_tipo_archivo")
    private TipoArchivo tipoArchivo;

    @Column(name = "nombre_archivo")
    private String nombreAlbum;

    @Lob
    private byte[] album;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea"),
            @JoinColumn(name = "curso_id", referencedColumnName = "curso_id")
    })
    private Tarea tarea;

}


@Entity
@Table(name = "tipo_archivo")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
class TipoArchivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_archivo")
    private Long idTipoArchivo;

    @Column(name = "nombre")
    private String nombre;
}


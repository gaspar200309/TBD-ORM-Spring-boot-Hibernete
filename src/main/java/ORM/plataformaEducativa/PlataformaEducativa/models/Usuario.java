package ORM.plataformaEducativa.PlataformaEducativa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CI")
    private long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Email")
    private String email;

    @Column(name = "Contraseña")
    private String password;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Docente docente;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usern_rol",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "CI"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    )
    private Collection<Rol> roles;
}

@Entity
@Table(name = "ESTUDIANTE")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CI")
    private Integer ci;

    @Column(name = "Semestre")
    private String semestre;

    @Column(name = "CODIGOSIS")
    private String codigoSIS;

    @OneToMany(mappedBy = "estudiante")
    private List<Entrega> entregas;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "CI")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Inscrito> inscritos;
}


@Entity
@Table(name = "DOCENTE")
@Data @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
class Docente {

    @Id
    @Column(name = "CI")
    private Integer ci;

    @Column(name = "ASIGNATURA")
    private String asignatura;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "CI")
    private Usuario usuario;

    @OneToMany(mappedBy = "docenteCi")
    private List<Curso> cursos;
}

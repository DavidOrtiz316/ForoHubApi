package foro.hub.apiForoHub.topico;

import foro.hub.apiForoHub.curso.Curso;
import foro.hub.apiForoHub.respuesta.Respuesta;
import foro.hub.apiForoHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topico")
@NoArgsConstructor(force = true) //constructor sin atributos
@AllArgsConstructor // cosntructor con todos los atributos
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private String status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor; //Referencia al usuario que creo el tópico
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso; // nombre del Curso
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Topico() {
    }

    public Topico(DatosRegistrarTopico datosRegistrarTopico, Usuario autor, Curso curso) {
        this.titulo = datosRegistrarTopico.titulo();
        this.mensaje = datosRegistrarTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now(); //inicia fecha al momento de creación
        this.status = "activo"; //establece valor inicial para estatus
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}

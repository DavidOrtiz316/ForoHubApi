package foro.hub.apiForoHub.topico;

import foro.hub.apiForoHub.curso.Curso;
import foro.hub.apiForoHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@NoArgsConstructor //constructor sin atributos
@AllArgsConstructor // cosntructor con todos los atributos
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor; //Referencia al usuario que creo el tópico
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso; // nombre del Curso
    @OneToMany
    @JoinColumn(name = "respuesta_id")
    private String respuesta;

    public Topico(DatosRegistrarTopico datosRegistrarTopico) {
        this.titulo = datosRegistrarTopico.titulo();
        this.mensaje = datosRegistrarTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now(); //inicia fecha al momento de creación
        this.status = "activo"; //establece valor inicial para estatus
    }
}

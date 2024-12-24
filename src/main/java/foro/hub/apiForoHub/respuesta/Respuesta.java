package foro.hub.apiForoHub.respuesta;

import foro.hub.apiForoHub.topico.Topico;
import foro.hub.apiForoHub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    private String solucion;
}

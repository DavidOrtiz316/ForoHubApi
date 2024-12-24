package foro.hub.apiForoHub.usuario;

import foro.hub.apiForoHub.perfil.Perfil;
import foro.hub.apiForoHub.respuesta.Respuesta;
import foro.hub.apiForoHub.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String password;
    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;
    @OneToMany(mappedBy = "autor")
    private List<Respuesta> respuestas;

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }
}

package foro.hub.apiForoHub.topico;

import foro.hub.apiForoHub.perfil.Perfil;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        String nombre,
        String curso
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}

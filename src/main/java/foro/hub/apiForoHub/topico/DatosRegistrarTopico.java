package foro.hub.apiForoHub.topico;

import foro.hub.apiForoHub.curso.Curso;

public record DatosRegistrarTopico(
        String idUsuario,
        String mensaje,
        String nombreCurso,
        String titulo
) {
}

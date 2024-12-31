package foro.hub.ForoHubApi.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String status,
        LocalDateTime fechaCreacion

) {
}

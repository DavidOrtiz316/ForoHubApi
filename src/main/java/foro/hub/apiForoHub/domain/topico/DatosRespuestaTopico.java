package foro.hub.apiForoHub.domain.topico;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String status,
        LocalDateTime fechaCreacion

) {
}

package alura.forum.api.domain.foro;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestaForo(
        Long id,

        String titulo,

        String mensaje,

        String fecha,

        String estado,

        Long usuario,

        Long curso
) {
}

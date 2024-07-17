package alura.forum.api.domain.foro;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarForo(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Long curso
) {
}

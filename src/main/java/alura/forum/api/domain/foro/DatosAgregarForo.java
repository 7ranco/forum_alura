package alura.forum.api.domain.foro;

import alura.forum.api.domain.curso.Curso;
import alura.forum.api.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosAgregarForo(
        @NotNull
        String titulo,

        @NotNull
        String mensaje,
        @NotNull
        Long usuario,
        @NotNull
        Long curso
) {
}

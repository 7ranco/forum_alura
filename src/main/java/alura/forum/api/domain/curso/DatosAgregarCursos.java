package alura.forum.api.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosAgregarCursos(
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
) {
}

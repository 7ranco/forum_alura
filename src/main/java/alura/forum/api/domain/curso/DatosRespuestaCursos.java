package alura.forum.api.domain.curso;

import alura.forum.api.domain.foro.Estado;

public record DatosRespuestaCursos(
        Long id,
        String nombre,
        Categoria categoria
        ) {
}

package alura.forum.api.domain.foro;

public record DatosListadoForo(
        Long id,

        String titulo,

        String mensaje,

        String fecha
) {
}

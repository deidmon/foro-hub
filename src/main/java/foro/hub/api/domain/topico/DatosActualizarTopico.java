package foro.hub.api.domain.topico;
import foro.hub.api.domain.curso.Curso;
import foro.hub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotNull;
public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Long autor,
        Long curso
) {
}

package foro.hub.api.domain.topico;

import foro.hub.api.domain.curso.Curso;
import foro.hub.api.domain.usuario.Usuario;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Usuario autor,
        Curso curso
) {
}

package foro.hub.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    Page<Topico> findByStatusTrue(Pageable paginacion);

    Topico findByTituloAndMensaje(String titulo, String mensaje);
}

package foro.hub.api.controller;

import foro.hub.api.domain.curso.Curso;
import foro.hub.api.domain.curso.CursoRepository;
import foro.hub.api.domain.topico.*;
import foro.hub.api.domain.usuario.Usuario;
import foro.hub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        // Valida si existe el topico
        Topico topicoExistente = topicoRepository.findByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje());
        if (topicoExistente != null) {
            return ResponseEntity.badRequest().body(null); // O lanzar una excepción personalizada
        }
        // Buscar el usuario
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(datosRegistroTopico.autor());
        if (usuarioBuscado.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // O lanzar una excepción personalizada
        }
        Usuario usuario = usuarioBuscado.get();

        // Buscar el curso
        Optional<Curso> cursoBuscado = cursoRepository.findById(datosRegistroTopico.curso());
        if (cursoBuscado.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // O lanzar una excepción personalizada
        }
        Curso curso = cursoBuscado.get();
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico, usuario, curso));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),topico.getAutor(),topico.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size =4, sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico :: new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if (topicoBuscado.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // O lanzar una excepción personalizada
        }
        Topico topico = topicoBuscado.get();
        /*Topico topico = topicoRepository.getReferenceById(id);*/
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosRespuestaTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Optional<Topico> topicoBuscado = topicoRepository.findById(datosActualizarTopico.id());
        if (topicoBuscado.isEmpty()) {
            return ResponseEntity.badRequest().body(null); // O lanzar una excepción personalizada
        }
        Topico topico = topicoBuscado.get();

        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),topico.getAutor(),topico.getCurso()));
    }

}

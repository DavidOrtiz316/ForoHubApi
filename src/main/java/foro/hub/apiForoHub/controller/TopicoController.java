package foro.hub.apiForoHub.controller;

import foro.hub.apiForoHub.curso.Curso;
import foro.hub.apiForoHub.curso.CursoRepository;
import foro.hub.apiForoHub.topico.*;
import foro.hub.apiForoHub.usuario.Usuario;
import foro.hub.apiForoHub.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico) {
        // Buscar usuario por ID
        Usuario autor = usuarioRepository.findById(Long.parseLong(datosRegistrarTopico.idUsuario()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        // Buscar curso por nombre
        Curso curso = cursoRepository.findByNombre(datosRegistrarTopico.nombreCurso())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));

        // Crear el tópico y guardar
        Topico topico = new Topico(datosRegistrarTopico, autor, curso);
        topicoRepository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico creado correctamente");
    }

    @GetMapping
    public Page<DatosListadoTopicos> ListadoTopicos(@PageableDefault(size = 10, sort = "fechaCreacion" ) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }

    /*@GetMapping("/{id}")
    public List<DatosListadoTopicos> listadoTopicos(@PathVariable Long id){
        return topicoRepository.findById(id).stream().map(DatosListadoTopicos::new).toList();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopicos> obtenerTopicoPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(new DatosListadoTopicos(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional //al no usar el repositorio.save nos permite guardar la actualizacion en la bd
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }
}

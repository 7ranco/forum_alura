package alura.forum.api.controller;

import alura.forum.api.domain.curso.DatosRespuestaCursos;
import alura.forum.api.domain.foro.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foros")
public class ForoController {


    @Autowired
    private ForoService foroService;

    @Autowired
    private ForoRepository foroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agregarForo(@RequestBody @Valid DatosAgregarForo datosAgregarForo, UriComponentsBuilder uriComponentsBuilder){
        var response = foroService.agregar(datosAgregarForo);

        URI uri = uriComponentsBuilder.path("/foros/{id}").buildAndExpand(response.id()).toUri();


        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<DatosListadoForo>> listadoForo(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(foroRepository.findByActivoTrue(paginacion).map(e -> new DatosListadoForo(e.getId(), e.getTitulo(), e.getMensaje(), e.getFecha().toString())));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity eliminarForo(@PathVariable Long id){
        Foro foro = foroRepository.getReferenceById(id);
        foro.desactivarForo();
        return ResponseEntity.noContent().build();
    }


    @PutMapping
    @Transactional
    public ResponseEntity actualizarForo(@RequestBody @Valid DatosActualizarForo datosActualizarForo, UriComponentsBuilder uriComponentsBuilder){
        Foro foro = foroRepository.getReferenceById(datosActualizarForo.id());

        var foroActualizado = foroService.actualizar(datosActualizarForo, foro);

        return ResponseEntity.ok(new DatosRespuestaForo(foro.getId(),
                foro.getTitulo(), foro.getMensaje(), foro.getFecha().toString(), foro.getEstado().toString(),
                foro.getAutor().getId(), foro.getCurso().getId()));
    }
}

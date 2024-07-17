package alura.forum.api.controller;

import alura.forum.api.domain.curso.Curso;
import alura.forum.api.domain.curso.CursoRepository;
import alura.forum.api.domain.curso.DatosAgregarCursos;
import alura.forum.api.domain.curso.DatosRespuestaCursos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("cursos")
@ResponseBody
public class CursoController {

    @Autowired
    private CursoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity agregar(@RequestBody @Valid DatosAgregarCursos datosAgregarCursos, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = repository.save(new Curso(datosAgregarCursos));

        DatosRespuestaCursos datosRespuestaCursos = new DatosRespuestaCursos(curso.getId(), curso.getNombre(), curso.getCategoria());

        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(datosRespuestaCursos);
    }
}

package alura.forum.api.controller;

import alura.forum.api.domain.curso.Curso;
import alura.forum.api.domain.curso.CursoRepository;
import alura.forum.api.domain.curso.DatosAgregarCursos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@ResponseBody
@EnableMethodSecurity(securedEnabled = true)
public class CursoController {

    @Autowired
    private CursoRepository repository;
    @PostMapping
    public ResponseEntity agregar(@RequestBody @Valid DatosAgregarCursos datosAgregarCursos){
        Curso curso = repository.save(new Curso(datosAgregarCursos));

//        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.ok().build();
    }
}

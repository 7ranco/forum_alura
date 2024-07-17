package alura.forum.api.controller;

import alura.forum.api.domain.curso.DatosAgregarCursos;
import alura.forum.api.domain.foro.AgregarForoService;
import alura.forum.api.domain.foro.DatosAgregarForo;
import alura.forum.api.domain.foro.Foro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foros")
public class ForoController {


    @Autowired
    private AgregarForoService agregarForoService;

    @PostMapping
    @Transactional
    public ResponseEntity agregarForo(@RequestBody @Valid DatosAgregarForo datosAgregarForo, UriComponentsBuilder uriComponentsBuilder){
        var response = agregarForoService.agregar(datosAgregarForo);

        URI uri = uriComponentsBuilder.path("/foros/{id}").buildAndExpand(response.id()).toUri();


        return ResponseEntity.created(uri).body(response);
    }
}

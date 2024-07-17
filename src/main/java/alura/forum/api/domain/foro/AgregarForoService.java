package alura.forum.api.domain.foro;

import alura.forum.api.domain.curso.Curso;
import alura.forum.api.domain.curso.CursoRepository;
import alura.forum.api.domain.curso.DatosRespuestaCursos;
import alura.forum.api.domain.usuarios.Usuario;
import alura.forum.api.domain.usuarios.UsuarioRepository;
import alura.forum.api.infra.error.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgregarForoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ForoRepository foroRepository;

    public DatosRespuestaForo agregar(DatosAgregarForo datosAgregarForo){
        if (!cursoRepository.findById(datosAgregarForo.curso()).isPresent()){
           throw new ValidacionDeIntegridad("este id del curso no fue encontrado");
        }

        if (!usuarioRepository.findById(datosAgregarForo.usuario()).isPresent()){
            throw new ValidacionDeIntegridad("este id del usuario no fue encontrado");
        }

        Curso curso = cursoRepository.findById(datosAgregarForo.curso()).get();
        Usuario usuario = usuarioRepository.findById(datosAgregarForo.usuario()).get();

        Foro foro = new Foro(datosAgregarForo, usuario, curso);

        foroRepository.save(foro);

        DatosRespuestaForo datosRespuestaCursos = new DatosRespuestaForo(foro.getId(),
        foro.getTitulo(), foro.getMensaje(), foro.getFecha().toString(), foro.getEstado().toString(),
                foro.getAutor().getId(), foro.getCurso().getId());

        return datosRespuestaCursos;
    }
}

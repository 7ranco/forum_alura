package alura.forum.api.domain.usuarios;

import alura.forum.api.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByCorreo(String nombreUsuario);
}

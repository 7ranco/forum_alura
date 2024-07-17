package alura.forum.api.domain.foro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForoRepository extends JpaRepository<Foro, Long> {
    Page<Foro> findByActivoTrue(Pageable paginacion);
}

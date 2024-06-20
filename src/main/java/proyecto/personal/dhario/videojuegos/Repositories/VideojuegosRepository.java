package proyecto.personal.dhario.videojuegos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.personal.dhario.videojuegos.Entities.Videojuegos;

public interface VideojuegosRepository extends JpaRepository<Videojuegos, Integer> {
}

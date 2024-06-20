package proyecto.personal.dhario.videojuegos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.personal.dhario.videojuegos.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}

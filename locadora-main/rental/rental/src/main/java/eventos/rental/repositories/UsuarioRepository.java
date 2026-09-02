package eventos.rental.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.rental.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailAndAtivoTrue(String email);

}

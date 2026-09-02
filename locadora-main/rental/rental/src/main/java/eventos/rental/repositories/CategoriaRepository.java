package eventos.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.rental.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

package eventos.rental.repositories;

import eventos.rental.repositoriesEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipamentoRepository
        extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByAtivoTrueOrderByNomeAsc();

    List<Equipamento> findByAtivoTrueAndNomeContainingIgnoreCaseOrderByNomeAsc(
            String nome
    );
}

package eventos.rental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.rental.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    List<Equipamento> findByAtivoTrueOrderByNomeAsc();

    List<Equipamento> findByAtivoTrueAndNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}

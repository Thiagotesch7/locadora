package eventos.rental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eventos.rental.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findAllByOrderByDataMovimentacaoDesc();

}

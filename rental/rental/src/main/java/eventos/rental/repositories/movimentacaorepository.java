package eventos.rental.repositories;

import eventos.rental.repositoriesMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository
        extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findAllByOrderByDataMovimentacaoDesc();

}
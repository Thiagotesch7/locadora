package eventos.rental.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eventos.rental.models.Equipamento;
import eventos.rental.models.Movimentacao;
import eventos.rental.models.TipoMovimentacao;
import eventos.rental.models.Usuario;
import eventos.rental.repositories.EquipamentoRepository;
import eventos.rental.repositories.MovimentacaoRepository;
import eventos.rental.repositories.UsuarioRepository;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository,
            EquipamentoRepository equipamentoRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Movimentacao realizarMovimentacao(
            Long equipamentoId,
            Long usuarioId,
            TipoMovimentacao tipo,
            Integer quantidade,
            LocalDate data
    ) {

        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        Equipamento equipamento =
                equipamentoRepository.findById(equipamentoId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Equipamento não encontrado."
                                ));

        Usuario usuario =
                usuarioRepository.findById(usuarioId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuário não encontrado."
                                ));

        if (tipo == TipoMovimentacao.SAIDA) {

            if (equipamento.getQuantidade() < quantidade) {

                throw new IllegalArgumentException(
                        "Estoque insuficiente. Estoque disponível: "
                                + equipamento.getQuantidade()
                );
            }

            equipamento.setQuantidade(
                    equipamento.getQuantidade() - quantidade
            );

        } else {

            equipamento.setQuantidade(
                    equipamento.getQuantidade() + quantidade
            );
        }

        equipamentoRepository.save(equipamento);

        Movimentacao movimentacao = new Movimentacao();

        movimentacao.setEquipamento(equipamento);
        movimentacao.setUsuario(usuario);
        movimentacao.setTipo(tipo);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setDataMovimentacao(data);

        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listarHistorico() {

        return movimentacaoRepository
                .findAllByOrderByDataMovimentacaoDesc();
    }

    public boolean estoqueCritico(Equipamento equipamento) {

        return equipamento.getQuantidade()
                <= equipamento.getEstoqueMinimo();
    }
}

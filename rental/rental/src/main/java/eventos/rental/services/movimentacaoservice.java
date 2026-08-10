package eventos.rental.services;

import eventos.rental.model.equipamento;
import eventos.rental.model.movimentacao;
import eventos.rental.model.TipoMovimentacao;
import eventos.rental.model.Usuario;
import eventos.rental.repository.equipamentorepository;
import eventos.rental.repository.movimentacaorepository;
import eventos.rental.repository.usuariorepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            java.time.LocalDate data
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
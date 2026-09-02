package eventos.rental.models.dtos;

import java.time.LocalDate;

import eventos.rental.models.TipoMovimentacao;

public record MovimentacaoRequest(
        Long equipamentoId,
        Long usuarioId,
        TipoMovimentacao tipo,
        Integer quantidade,
        LocalDate dataMovimentacao
) {
}

package eventos.rental.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eventos.rental.models.Movimentacao;
import eventos.rental.models.dtos.MovimentacaoRequest;
import eventos.rental.services.MovimentacaoService;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService service;

    public MovimentacaoController(MovimentacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movimentacao> listar() {
        return service.listarHistorico();
    }

    @PostMapping
    public ResponseEntity<Movimentacao> registrar(
            @RequestBody MovimentacaoRequest request
    ) {

        LocalDate data = request.dataMovimentacao() != null
                ? request.dataMovimentacao()
                : LocalDate.now();

        Movimentacao movimentacao = service.realizarMovimentacao(
                request.equipamentoId(),
                request.usuarioId(),
                request.tipo(),
                request.quantidade(),
                data
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }
}

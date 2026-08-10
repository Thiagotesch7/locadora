package eventos.rental.models;

public class TipoMovimentacao {
    ENTRADA,
    SAIDA
}

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;
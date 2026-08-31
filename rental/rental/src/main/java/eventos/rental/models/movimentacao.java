package eventos.rental.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimentacoes")
public class movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private equipamento equipamento;

    @ManyToOne
    @JoinColumn
    private Usuario usuario;

    @Column
    private Integer quantidade;

    @Column
    private LocalDate dataMovimentacao;

    private String observacao;

    public movimentacao() {
    }

    public movimentacao(Long id, equipamento equipamento, Usuario usuario, Integer quantidade,
            LocalDate dataMovimentacao, String observacao) {
        this.id = id;
        this.equipamento = equipamento;
        this.usuario = usuario;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    
}

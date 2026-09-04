package com.locadora.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "marca")
    private Integer marca;

    @Column(name = "modelo")
    private Integer modelo;

    @Column(name = "categoria")
    private Integer categoria;

    @Column(name = "cor")
    private Integer cor;

    @Column(name = "quantidade")
    private Integer quantidade;

    public Equipamento() {
    }

    public Equipamento(Integer id, Integer marca, Integer modelo, Integer categoria, Integer cor, Integer quantidade) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.cor = cor;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}

package com.locadora.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.eventos.models.Equipamento;


public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

}

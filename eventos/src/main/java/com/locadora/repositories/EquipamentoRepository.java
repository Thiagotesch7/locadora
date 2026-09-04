package com.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

}

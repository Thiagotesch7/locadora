package com.locadora.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.eventos.models.Equipamento;
import com.locadora.eventos.repositories.EquipamentoRepository;

@Service 
public class EquipamentoService {
    
    @Autowired
    private EquipamentoRepository equipamentoRepository;
    
    public Long contarEquipamentos() {
        return equipamentoRepository.count();
    }

    public Equipamento buscarEquipamento(Integer id) {
        return equipamentoRepository.findById(id).get();
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public Boolean deletarEquipamento(Integer id) {
        if (equipamentoRepository.existsById(id)) {
            equipamentoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Equipamento cadastrarEquipamento(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizarEquipamento(Integer id, Equipamento equipamento) {
        Equipamento equipamentoRecuperado = buscarEquipamento(id);
        if (equipamentoRecuperado !=null) {
            equipamentoRecuperado.setId(id);
            if (equipamento.getCategoria() !=null) {
                equipamentoRecuperado.setCategoria(equipamento.getCategoria());
            }

            else if (equipamento.getMarca() !=null) {
                equipamentoRecuperado.setMarca(equipamento.getMarca());
            }

            else if (equipamento.getCor() !=null) {
                equipamentoRecuperado.setCor(equipamento.getCor());
            }

                else if (equipamento.getModelo() !=null) {
                equipamentoRecuperado.setModelo(equipamento.getModelo());
                }

                if (equipamento.getQuantidade() !=null) {
                equipamentoRecuperado.setQuantidade(equipamento.getQuantidade());
                }

            return equipamentoRepository.save(equipamentoRecuperado);
        }
        return null;
    }
}
    
    

     
            


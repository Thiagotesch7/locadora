package com.locadora.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.locadora.eventos.services.EquipamentoService;
import com.locadora.eventos.models.Equipamento;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping ("/equipamento") 
public class EquipamentoController {

    @Autowired 
    private EquipamentoService equipamentoService;

    @GetMapping ("/contar-equipamentos")
    public Long contarEquipamentos() {
        return equipamentoService.contarEquipamentos();
    }

   @GetMapping("/buscar-equipamentos/{id}")
   public Equipamento buscarEquipamento(@PathVariable Integer id) {
       return equipamentoService.buscarEquipamento(id);
   }
   

    

    
}

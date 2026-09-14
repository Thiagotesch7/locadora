package com.locadora.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.eventos.models.Usuario;
import com.locadora.eventos.models.Dto.login;
import com.locadora.eventos.services.UsuarioService;



@RestController 
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired 
    private UsuarioService usuarioService;


    @PostMapping("/login")
    public Usuario login(@RequestBody login login){
        Usuario usuario = usuarioService.login(login);

        return usuario;
    }
    
}

package com.locadora.eventos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.eventos.models.Usuario;
import com.locadora.eventos.repositories.UsuarioRepository;


@Service 
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository; 

    public Usuario login (com.locadora.eventos.models.Dto.login login) {

        Usuario usuario = usuarioRepository.login(login.email, login.senha);

        return usuario;
    }
}

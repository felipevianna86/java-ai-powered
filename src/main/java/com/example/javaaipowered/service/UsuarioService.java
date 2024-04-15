package com.example.javaaipowered.service;

import com.example.javaaipowered.model.Usuario;

public interface UsuarioService {

    Usuario findById(Long id);

    Usuario criar(Usuario usuario);
}

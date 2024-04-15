package com.example.javaaipowered.service.impl;

import com.example.javaaipowered.model.Usuario;
import com.example.javaaipowered.repository.UsuarioRepository;
import com.example.javaaipowered.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UserServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario criar(Usuario usuario) {
        this.validaCadastroUsuario(usuario);
        return this.usuarioRepository.save(usuario);
    }

    private void validaCadastroUsuario(Usuario usuario){

        if(usuario.getId() != null && this.usuarioRepository.existsById(usuario.getId())){
            throw new IllegalArgumentException("Este usuário já existe.");
        }

        if(usuario.getId() != null && this.usuarioRepository.existsByContaNumero(usuario.getConta().getNumero())){
            throw new IllegalArgumentException("Esse número de conta já existe.");
        }
    }
}

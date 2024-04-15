package com.example.javaaipowered.repository;

import com.example.javaaipowered.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByContaNumero(String numero);
}

package com.dhbrasil.aula36Mesa.aula36mesa.repository;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

package com.dhbrasil.springboot.aula21.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TesteOptional {


    @Test
    public void test() {

        Usuario u = getUsuario();
        if (u != null) {
            u.getNome();
        }

        Optional<Usuario> optionalUsuario = getU();
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
        }

        Usuario usuario = optionalUsuario.orElse(null);
        Usuario usuario2 = optionalUsuario.orElseThrow(() ->new RuntimeException("nao encontrado"));

        System.out.println("auhsuahuahs");
    }

    private Usuario getUsuario() {
        Usuario u = null;
        return u;
    }

    private Optional<Usuario> getU(){
        Usuario u = null;    // consulta do banco

        return u == null ? Optional.empty() : Optional.of(u);
    }
}
package com.dhbrasil.mvc.aula22.model;

public class Paciente {

    private String nome;

    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

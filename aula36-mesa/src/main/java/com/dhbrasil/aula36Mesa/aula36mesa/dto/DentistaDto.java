package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DentistaDto {

    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotNull
    private Integer numMatricula;
    @NotNull
    private Integer atendeConvenio;

    public DentistaDto(){}

    public DentistaDto(Integer id, String nome, String email, Integer numMatricula, Integer atendeConvenio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numMatricula = numMatricula;
        this.atendeConvenio = atendeConvenio;
    }

    public DentistaDto(Dentista dentista){
        id = dentista.getId();
        nome = dentista.getNome();
        email = dentista.getEmail();
        numMatricula = dentista.getNumMatricula();
        atendeConvenio = dentista.getAtendeConvenio();
    }

    public Dentista toEntity(){
        return new Dentista(
                this.id,
                this.nome,
                this.email,
                this.numMatricula,
                this.atendeConvenio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(Integer numMatricula) {
        this.numMatricula = numMatricula;
    }

    public Integer getAtendeConvenio() {
        return atendeConvenio;
    }

    public void setAtendeConvenio(Integer atendeConvenio) {
        this.atendeConvenio = atendeConvenio;
    }
}

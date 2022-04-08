package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Consulta;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;

import javax.persistence.*;

public class UsuarioDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer acesso;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Consulta consulta;

    public UsuarioDto (Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        senha = usuario.getSenha();
        acesso = usuario.getAcesso();
    }

    public UsuarioDto(Integer id, String nome, String email, String senha, Integer acesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getAcesso() {
        return acesso;
    }

    public void setAcesso(Integer acesso) {
        this.acesso = acesso;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}

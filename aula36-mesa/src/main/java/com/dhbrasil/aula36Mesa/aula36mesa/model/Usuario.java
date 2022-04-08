package com.dhbrasil.aula36Mesa.aula36mesa.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer acesso;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Consulta> consulta = new HashSet<>();

    public Usuario(){}

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String email, String senha, Integer acesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
    }

    public Usuario(String nome, String email, String senha, Integer acesso) {
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

    public Set<Consulta> getConsulta(){
        return consulta;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", acesso=" + acesso +
                '}';
    }
}

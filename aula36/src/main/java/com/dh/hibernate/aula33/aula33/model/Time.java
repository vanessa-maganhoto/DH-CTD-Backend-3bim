package com.dh.hibernate.aula33.aula33.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tabelaTime")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome, cidade, estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "time")
    private Set<Jogador> jogadores = new HashSet<>();

    public Time(){}

    public Time(Integer id, String nome, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Time(String nome, String cidade, String estado) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", jogadores=" + jogadores +
                '}';
    }
}

package com.dhbrasil.aula36Mesa.aula36mesa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataCad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    private Set<Consulta> consulta = new HashSet<>();

    public Paciente (){}

    public Paciente(Integer id) {
        this.id = id;
    }

    public Paciente(Integer id, String nome, String sobrenome, String cpf, Date dataCad, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataCad = dataCad;
        this.endereco = endereco;
    }

    public Paciente(String nome, String sobrenome, String cpf, Date dataCad, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataCad = dataCad;
        this.endereco = endereco;
    }

    public Paciente(Integer id, String nome, String sobrenome, String cpf, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<Consulta> getConsulta(){
        return consulta;
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataCad=" + dataCad +
                ", endereco=" + endereco +
                '}';
    }

}

package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Consulta;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;

public class PacienteDto {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataCad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente")
    private Consulta consulta;


    public PacienteDto (Paciente paciente){
        id = paciente.getId();
        nome = paciente.getNome();
        sobrenome = paciente.getSobrenome();
        cpf = paciente.getCpf();
        dataCad = paciente.getDataCad();
    }

    public PacienteDto(Integer id, String nome, String sobrenome, String cpf, Date dataCad) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataCad = dataCad;
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
}

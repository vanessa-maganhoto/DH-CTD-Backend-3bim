package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PacienteDto {

    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;
    @NotNull
    private Date dataCad;


    @NotNull
    @Valid
    private EnderecoDto endereco;



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

    public Paciente toEntity(){
        return new Paciente(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.dataCad,
                this.endereco == null ? null : this.endereco.toEntity());
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

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }
}

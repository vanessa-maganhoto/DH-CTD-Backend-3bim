package com.dhbrasil.aula36Mesa.aula36mesa.dto;

import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;

import javax.validation.constraints.NotBlank;

public class EnderecoDto {

    private Integer id;
    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;

    public EnderecoDto(){}

    public EnderecoDto(Integer id, String rua, String numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoDto(Endereco endereco){
        id = endereco.getId();
        rua = endereco.getRua();
        numero = endereco.getNumero();
        bairro = endereco.getBairro();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
    }

    public Endereco toEntity(){
        return new Endereco(
                this.id,
                this.rua,
                this.numero,
                this.bairro,
                this.cidade,
                this.estado);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
}

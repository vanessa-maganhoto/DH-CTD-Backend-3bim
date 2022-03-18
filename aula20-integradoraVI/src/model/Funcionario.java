package model;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private String nome;
    private String sobrenome;
    private String documentoIdentificacao;
    private Double salario;

    public Funcionario(){}

    public Funcionario(String nome, String sobrenome, String documentoIdentificacao, Double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.salario = salario;
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

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documentoIdentificacao='" + documentoIdentificacao + '\'' +
                ", salario=" + salario +
                '}';
    }
}

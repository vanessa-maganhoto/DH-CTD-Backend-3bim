package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    private String cnpj;
    private String razaoSocial;
    List<Funcionario> funcionarios = new ArrayList<>();

    public Empresa (){}

    public Empresa(String cnpj, String razaoSocial, List<Funcionario> funcionario) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.funcionarios = funcionario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", funcionario=" + funcionarios +
                '}';
    }
}

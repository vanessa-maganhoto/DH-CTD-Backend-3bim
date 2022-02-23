package com.dh.aula02;

public class Contratado extends  Funcionario{

    private double valorHora;
    private int horas;

    public Contratado(String nome, String sobrenome, String numConta, double valorHora, int horas) {
        super(nome, sobrenome, numConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularSaldo() {
        return valorHora * horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Recibo foi gerado - FUNCIONÁRIO CONTRATO");
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Foi depositado uma quantia de " + quantia);
    }
}

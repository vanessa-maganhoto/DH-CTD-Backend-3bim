package model;

public class Arvore {

    private String altura;
    private String largura;
    private String cor;
    private static int contador;

    public Arvore(String altura, String largura, String cor) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
        contador++;
        System.out.println("Contagem: " + contador + " cor: " + cor);
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Arvore{" +
                "altura='" + altura + '\'' +
                ", largura='" + largura + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}

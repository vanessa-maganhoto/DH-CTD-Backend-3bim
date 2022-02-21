public class Quadrado extends Figura{

    private Double lado;

    public Quadrado(Double lado) {
        this.lado = lado;
    }

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * this.lado;
    }
}

public class Circulo extends Figura{

    private Double raio;

    public Circulo(Double raio) {
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * this.raio * Math.PI;
    }
}

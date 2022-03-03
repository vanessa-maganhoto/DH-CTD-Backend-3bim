package model;

public class Computer {

    private int ram;
    private int hd;
    private static int contador;

    public Computer(int ram, int hd) {
        this.ram = ram;
        this.hd = hd;
        contador++;
        System.out.println("Contagem: " + contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", hd=" + hd +
                '}';
    }
}

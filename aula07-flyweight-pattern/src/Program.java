import factory.ComputerFactory;
import model.Computer;

public class Program {

    public static void main(String[] args) {

    // Execeução do App
        ComputerFactory fabrica = new ComputerFactory();
        Computer mac1 = fabrica.getComputer(16, 500);
        Computer windows = fabrica.getComputer(2,256);
        Computer mac2 = fabrica.getComputer(16, 500);

        System.out.println(mac1.toString());
        System.out.println(mac2.toString());
        System.out.println(windows.toString());
    }

}

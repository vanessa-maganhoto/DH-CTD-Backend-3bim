import model.ListaInteiros;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Main {

    static final Logger logger = Logger.getLogger(ListaInteiros.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();

        ArrayList<Integer> lista1 = new ArrayList();
        lista1.add(1);
        lista1.add(5);
        lista1.add(9);
        lista1.add(10);
        lista1.add(111);
        lista1.add(50);

        ArrayList<Integer> lista2 = new ArrayList();
        lista2.add(5);
        lista2.add(6);
        lista2.add(-1);
        lista2.add(40);
        lista2.add(13);
        lista2.add(9);
        lista2.add(40);
        lista2.add(4);
        lista2.add(7);
        lista2.add(20);
        lista2.add(30);

        ArrayList<Integer> lista3 = new ArrayList();

        ListaInteiros listaInteiros1 = new ListaInteiros(lista1);
        ListaInteiros listaInteiros2 = new ListaInteiros(lista2);
        ListaInteiros listaInteiros3 = new ListaInteiros(lista3);
        try{
            System.out.println("Lista 1");
            listaInteiros1.getInfo();
            System.out.println("Lista 2");
            listaInteiros2.getInfo();
            System.out.println("Lista 3");
            listaInteiros3.getInfo();
        } catch (Exception e) {
            logger.error(e);
        }



    }
}

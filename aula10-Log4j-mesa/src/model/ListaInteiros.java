package model;


import org.apache.log4j.Logger;
import java.util.ArrayList;


public class ListaInteiros {

    static final Logger logger = Logger.getLogger(ListaInteiros.class);
    private ArrayList<Integer> listaInteiros = new ArrayList();

    public ListaInteiros(ArrayList<Integer> listaInteiros) {
        this.listaInteiros = listaInteiros;
    }

    public double getMedia() {
        double media = 0;

        for (int numero: listaInteiros) {
            media += numero;
        }

        return media / listaInteiros.size();
    }

    public int getMax() {
        int max = listaInteiros.get(0);

        for (int numero: listaInteiros) {
            if (numero >= max) {
                max = numero;
            }
        }
        return max;
    }

    public int getMin() {
        int min = listaInteiros.get(0);

        for (int numero: listaInteiros) {
            if (numero <= min) {
                min = numero;
            }
        }
        return min;
    }

    public void getInfo() throws Exception {
        if (listaInteiros.size() == 0) {

            throw new Exception("A lista está vazia.");
        }

        if (listaInteiros.size() > 5 ) {
            logger.info("O comprimento da lista é maior que 5.");
        }

        if (listaInteiros.size() > 10) {
            logger.info("O comprimento da lista é maior que 10");
        }

        logger.info("A média da lista é: " + getMedia());
        logger.info("O maior valor da lista é: " + getMax());
        logger.info("O menor valor da lista é: " + getMin());

    }



}

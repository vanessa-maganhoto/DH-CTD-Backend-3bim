import factory.ArvoreFactory;
import model.Arvore;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        ArvoreFactory arvoreFactory = ArvoreFactory.getInstance();
        List<Arvore> floresta = new ArrayList<>();

        for (int i = 0; i < 500_000; i++) {
            floresta.add(arvoreFactory.criarArvore("vermelha"));
            floresta.add(arvoreFactory.criarArvore("verde"));
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        System.out.println("Número de árvores: " + floresta.size());

    }

}

// MESA 7:  Anderson Bueno, Ector Cunha, Luana Borges, Wesley Bueno, Vanessa Matos, Letícia Ferreira
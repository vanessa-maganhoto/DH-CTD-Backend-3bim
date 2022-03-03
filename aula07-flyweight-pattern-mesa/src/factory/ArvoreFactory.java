package factory;

import model.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static final ArvoreFactory instance = new ArvoreFactory();

    private Map<String, Arvore> arvoreCache = new HashMap<>();

    private ArvoreFactory() {
    }

    ;

    public static ArvoreFactory getInstance() {
        return instance;
    }

    public Arvore criarArvore(String cor) {
        if (arvoreCache.containsKey(cor)) {
            return arvoreCache.get(cor);
        }

        Arvore arvore = null;

        switch (cor) {
            case "azul":
                arvore = new Arvore("100", "300", "azul");
                break;
            case "vermelha":
                arvore = new Arvore("500", "300", "vermelha");
                break;
            case "verde":
                arvore = new Arvore("200", "400", "verde");
                break;

        }

        arvoreCache.put(cor, arvore);
        return arvore;

    }

}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardapioTest {

    @Test
    void Calculos(){
        Cardapio cInfantil = new CardapioInfantil(14.99,"Mc Lanche Feliz", "Pokemon", 20.00);
        System.out.println("TESTE CARDÁPIO INFANTIL");
        cInfantil.preparacao();

        Cardapio cAdulto = new CardapioAdulto(37.90, "Parmegiana");
        System.out.println("TESTE CARDÁPIO ADULTO");
        cAdulto.preparacao();

        Cardapio cVegetariano = new CardapioVegetariano(41.80, "Lasanha de Berinjela", 3);
        System.out.println("TESTE CARDÁPIO VEGETARIANO");
        cVegetariano.preparacao();

    }
}
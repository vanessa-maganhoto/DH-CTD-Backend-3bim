import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieProxyTest {

    @Test
    public void testeExcecao(){
        ISerie serie = new SerieProxy();
        serie.getSerie("La casa de papel");
        serie.getSerie("La casa de papel");
        serie.getSerie("La casa de papel");
        serie.getSerie("La casa de papel");
        serie.getSerie("La casa de papel");
        try {
            serie.getSerie("La casa de papel");

        } catch (SerieNaoHabilitadaException e){
            assertEquals("Excede o número de reproduções permitidas", e.getMessage());
            return;
        }

        fail("Deveria ter lançado um exceção");
    }

    @Test
    public void testeFormatoLink(){
        ISerie serie = new SerieProxy();
        assertEquals("www.vis-a-vis", serie.getSerie("vis-a-vis"));
    }
}
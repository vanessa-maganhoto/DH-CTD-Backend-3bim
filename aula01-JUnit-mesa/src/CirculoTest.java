import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    Circulo c1;

    @BeforeEach
    void doBefore(){
        c1 = new Circulo(5.0);
    }

    @Test
    void  calcularPerimetro(){
        Assertions.assertEquals(2*Math.PI*5, c1.calcularPerimetro());

    }
}
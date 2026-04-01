package heritage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculTest {

    @Test
    void testAddition() {
        Calcul c = new Calcul();
        assertEquals(5, c.addition(2, 3));
    }
}
package heritage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoursTest {

    @Test
    void testCreation() {
        Cours c = new Cours("Mathematiques", "M. Dupont");
        assertEquals("Mathematiques", c.getNom());
        assertEquals("M. Dupont", c.getProfesseur());
    }

    @Test
    void testAfficherDetails() {
        Cours c = new Cours("Informatique", "Mme Martin");
        c.afficherDetails();
    }
}

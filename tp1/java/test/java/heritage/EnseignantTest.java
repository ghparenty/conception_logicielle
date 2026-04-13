package heritage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnseignantTest {

    @Test
    void testCreation() {
        Enseignant e = new Enseignant("M. Dupont", 45, 3500);
        assertEquals("M. Dupont", e.getNom());
        assertEquals(45, e.getAge());
        assertEquals(3500, e.getSalaire());
    }

    @Test
    void testEstUnePersonne() {
        Enseignant e = new Enseignant("M. Dupont", 45, 3500);
        assertTrue(e instanceof Personne);
    }

    @Test
    void testAfficherDetails() {
        Enseignant e = new Enseignant("M. Dupont", 45, 3500);
        e.afficherDetails();
    }
}

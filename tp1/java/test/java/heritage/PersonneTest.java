package heritage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void testCreation() {
        Personne p = new Personne("Alice", 20);
        assertEquals("Alice", p.getNom());
        assertEquals(20, p.getAge());
    }

    @Test
    void testAfficherDetails() {
        Personne p = new Personne("Bob", 30);
        p.afficherDetails();
    }

    // TP2 : Validation

    @Test
    void testNomVideLeveErreur() {
        assertThrows(IllegalArgumentException.class, () -> new Personne("", 20));
    }

    @Test
    void testNomNullLeveErreur() {
        assertThrows(IllegalArgumentException.class, () -> new Personne(null, 20));
    }

    @Test
    void testAgeNegatifLeveErreur() {
        assertThrows(IllegalArgumentException.class, () -> new Personne("Alice", -1));
    }

    @Test
    void testAgeSuperieur100LeveErreur() {
        assertThrows(IllegalArgumentException.class, () -> new Personne("Alice", 101));
    }

    @Test
    void testAgeLimitesValides() {
        Personne p1 = new Personne("Alice", 0);
        assertEquals(0, p1.getAge());
        Personne p2 = new Personne("Bob", 100);
        assertEquals(100, p2.getAge());
    }

    @Test
    void testModifierAgeValide() {
        Personne p = new Personne("Alice", 20);
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    void testModifierAgeInvalide() {
        Personne p = new Personne("Alice", 20);
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-5));
    }
}

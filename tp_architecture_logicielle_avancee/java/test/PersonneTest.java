import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void testCreationViaEtudiant() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        assertEquals("Alice", e.getNom());
        assertEquals(20, e.getAge());
    }

    @Test
    void testNomVideLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Etudiant("", 20, "E001"));
    }

    @Test
    void testNomNullLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Etudiant(null, 20, "E001"));
    }

    @Test
    void testAgeNegatifLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Etudiant("Alice", -1, "E001"));
    }

    @Test
    void testAgeSuperieur120LeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Etudiant("Alice", 121, "E001"));
    }

    @Test
    void testAgeLimitesValides() {
        Etudiant e1 = new Etudiant("Alice", 0, "E001");
        assertEquals(0, e1.getAge());
        Etudiant e2 = new Etudiant("Bob", 120, "E002");
        assertEquals(120, e2.getAge());
    }

    @Test
    void testSetAgeValide() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.setAge(25);
        assertEquals(25, e.getAge());
    }

    @Test
    void testSetAgeInvalide() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        assertThrows(IllegalArgumentException.class, () -> e.setAge(-5));
    }

    @Test
    void testSetNomValide() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.setNom("Bob");
        assertEquals("Bob", e.getNom());
    }
}

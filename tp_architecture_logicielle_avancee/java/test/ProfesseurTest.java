import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfesseurTest {

    @Test
    void testCreationProfesseur() {
        Professeur p = new Professeur("Dupont", 45, "Mathematiques", 3500.0);
        assertEquals("Dupont", p.getNom());
        assertEquals(45, p.getAge());
        assertEquals("Mathematiques", p.getMatiere());
        assertEquals(3500.0, p.getSalaire());
    }

    @Test
    void testProfesseurNomVideLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Professeur("", 45, "Math", 3000.0));
    }

    @Test
    void testProfesseurAgeInvalideLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> new Professeur("Dupont", -5, "Math", 3000.0));
    }
}

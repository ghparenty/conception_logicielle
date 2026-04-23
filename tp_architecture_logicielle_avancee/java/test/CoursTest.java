import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoursTest {

    @Test
    void testCreationCours() {
        Cours c = new Cours("Mathematiques", "Dupont");
        assertEquals("Mathematiques", c.getNom());
        assertEquals("Dupont", c.getProfesseur());
    }

    @Test
    void testGetNom() {
        Cours c = new Cours("Physique", "Martin");
        assertEquals("Physique", c.getNom());
    }

    @Test
    void testGetProfesseur() {
        Cours c = new Cours("Physique", "Martin");
        assertEquals("Martin", c.getProfesseur());
    }
}

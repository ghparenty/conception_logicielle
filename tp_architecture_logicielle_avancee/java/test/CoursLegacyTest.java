import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CoursLegacyTest {

    @Test
    void testRecupererCoursFormatAncien() {
        CoursLegacy legacy = new CoursLegacy();
        List<String> cours = legacy.recupererCoursFormatAncien();

        assertNotNull(cours);
        assertFalse(cours.isEmpty());
        assertTrue(cours.get(0).contains("|"));
    }

    @Test
    void testRecupererCoursParIndex() {
        CoursLegacy legacy = new CoursLegacy();
        String premier = legacy.recupererCours(0);
        assertEquals("Mathematiques|Dupont", premier);
    }

    @Test
    void testQuatreCoursDisponibles() {
        CoursLegacy legacy = new CoursLegacy();
        assertEquals(4, legacy.recupererCoursFormatAncien().size());
    }
}

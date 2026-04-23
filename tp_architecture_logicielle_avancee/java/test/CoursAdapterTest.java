import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoursAdapterTest {

    @Test
    void testConvertirCoursValide() {
        CoursAdapter adapter = new CoursAdapter(new CoursLegacy());
        Cours cours = adapter.convertir("Mathematiques|Dupont");

        assertEquals("Mathematiques", cours.getNom());
        assertEquals("Dupont", cours.getProfesseur());
    }

    @Test
    void testConvertirCoursSansSeparateurLeveErreur() {
        CoursAdapter adapter = new CoursAdapter(new CoursLegacy());
        assertThrows(IllegalArgumentException.class,
                () -> adapter.convertir("Physique"));
    }

    @Test
    void testConvertirCoursAvecSeparateurMaisSansProf() {
        CoursAdapter adapter = new CoursAdapter(new CoursLegacy());
        Cours cours = adapter.convertir("Physique|");

        assertEquals("Physique", cours.getNom());
    }

    @Test
    void testConvertirCoursFormatInvalide() {
        CoursAdapter adapter = new CoursAdapter(new CoursLegacy());
        assertThrows(IllegalArgumentException.class, () -> adapter.convertir(null));
    }

    @Test
    void testConvertirTousLesCours() {
        CoursAdapter adapter = new CoursAdapter(new CoursLegacy());
        java.util.List<Cours> cours = adapter.convertirTous();

        assertNotNull(cours);
        assertFalse(cours.isEmpty());
    }
}

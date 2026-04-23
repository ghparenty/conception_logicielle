import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonneFactoryTest {

    @Test
    void testCreerEtudiantViaFactory() {
        Personne p = PersonneFactory.creerPersonne(
                PersonneFactory.TypePersonne.ETUDIANT, "Alice", 20, "E001");
        assertInstanceOf(Etudiant.class, p);
        assertEquals("Alice", p.getNom());
    }

    @Test
    void testCreerProfesseurViaFactory() {
        Personne p = PersonneFactory.creerPersonne(
                PersonneFactory.TypePersonne.PROFESSEUR, "Dupont", 45, "Math", 3500.0);
        assertInstanceOf(Professeur.class, p);
        assertEquals("Dupont", p.getNom());
    }

    @Test
    void testCreerEtudiantRaccourci() {
        Etudiant e = PersonneFactory.creerEtudiant("Bob", 22, "E002");
        assertEquals("Bob", e.getNom());
        assertEquals("E002", e.getNumero());
    }

    @Test
    void testCreerProfesseurRaccourci() {
        Professeur p = PersonneFactory.creerProfesseur("Martin", 40, "Physique", 3200.0);
        assertEquals("Martin", p.getNom());
        assertEquals("Physique", p.getMatiere());
        assertEquals(3200.0, p.getSalaire());
    }

    @Test
    void testCreerEtudiantSansNumeroLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> PersonneFactory.creerPersonne(
                        PersonneFactory.TypePersonne.ETUDIANT, "Alice", 20));
    }

    @Test
    void testCreerProfesseurSansSalaireLeveErreur() {
        assertThrows(IllegalArgumentException.class,
                () -> PersonneFactory.creerPersonne(
                        PersonneFactory.TypePersonne.PROFESSEUR, "Dupont", 45, "Math"));
    }
}

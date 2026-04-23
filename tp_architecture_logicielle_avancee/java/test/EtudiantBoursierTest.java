import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantBoursierTest {

    @Test
    void testBoursierConserveInfosEtudiant() {
        Etudiant alice = new Etudiant("Alice", 20, "E001");
        EtudiantBoursier boursiere = new EtudiantBoursier(alice, 4500.0);

        assertEquals("Alice", boursiere.getNom());
        assertEquals(20, boursiere.getAge());
        assertEquals("E001", boursiere.getNumero());
    }

    @Test
    void testBoursierMontant() {
        Etudiant alice = new Etudiant("Alice", 20, "E001");
        EtudiantBoursier boursiere = new EtudiantBoursier(alice, 4500.0);
        assertEquals(4500.0, boursiere.getMontantBourse());
    }

    @Test
    void testBoursierConserveMoyenne() {
        Etudiant alice = new Etudiant("Alice", 20, "E001");
        alice.ajouterNote(15.0);
        EtudiantBoursier boursiere = new EtudiantBoursier(alice, 4500.0);
        assertEquals(15.0, boursiere.getMoyenne());
    }

    @Test
    void testBoursierConserveCours() {
        Etudiant alice = new Etudiant("Alice", 20, "E001");
        alice.ajouterCours(new Cours("Math", "Dupont"));
        EtudiantBoursier boursiere = new EtudiantBoursier(alice, 4500.0);
        assertEquals(1, boursiere.getCours().size());
    }
}

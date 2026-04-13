package heritage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    // Heritage

    @Test
    void testEstUnePersonne() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        assertTrue(e instanceof Personne);
    }

    @Test
    void testHeritageNomAge() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        assertEquals("Alice", e.getNom());
        assertEquals(20, e.getAge());
    }

    // Attributs propres

    @Test
    void testNumero() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        assertEquals("E001", e.getNumero());
    }

    @Test
    void testMoyenne() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        assertEquals(15.5, e.getMoyenne());
    }

    // Composition : liste de cours

    @Test
    void testListeCoursVideAuDepart() {
        Etudiant e = new Etudiant("Bob", 22, "E002", 12.0);
        assertTrue(e.getCours().isEmpty());
    }

    @Test
    void testAjouterUnCours() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        Cours c = new Cours("Mathematiques", "M. Dupont");
        e.ajouterCours(c);
        assertEquals(1, e.getCours().size());
    }

    @Test
    void testAjouterPlusieursCours() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.5);
        e.ajouterCours(new Cours("Mathematiques", "M. Dupont"));
        e.ajouterCours(new Cours("Informatique", "Mme Martin"));
        assertEquals(2, e.getCours().size());
    }

    // TP2 : Validation de la moyenne

    @Test
    void testMoyenneNegativeLeveErreur() {
        assertThrows(IllegalArgumentException.class,
            () -> new Etudiant("Alice", 20, "E001", -1));
    }

    @Test
    void testMoyenneSuperieure20LeveErreur() {
        assertThrows(IllegalArgumentException.class,
            () -> new Etudiant("Alice", 20, "E001", 25));
    }

    @Test
    void testMoyenneLimitesValides() {
        Etudiant e1 = new Etudiant("Alice", 20, "E001", 0);
        assertEquals(0, e1.getMoyenne());
        Etudiant e2 = new Etudiant("Bob", 22, "E002", 20);
        assertEquals(20, e2.getMoyenne());
    }

    @Test
    void testModifierMoyenneValide() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.0);
        e.setMoyenne(18.0);
        assertEquals(18.0, e.getMoyenne());
    }

    @Test
    void testModifierMoyenneInvalide() {
        Etudiant e = new Etudiant("Alice", 20, "E001", 15.0);
        assertThrows(IllegalArgumentException.class, () -> e.setMoyenne(25));
    }
}

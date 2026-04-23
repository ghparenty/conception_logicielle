import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    @Test
    void testCreationEtudiant() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        assertEquals("Alice", e.getNom());
        assertEquals(20, e.getAge());
        assertEquals("E001", e.getNumero());
        assertEquals(0.0, e.getMoyenne());
        assertTrue(e.getCours().isEmpty());
    }

    @Test
    void testAjouterNoteValide() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.ajouterNote(15.0);
        assertEquals(15.0, e.getMoyenne());
    }

    @Test
    void testAjouterPlusieurNotes() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.ajouterNote(10.0);
        e.ajouterNote(20.0);
        assertEquals(15.0, e.getMoyenne());
    }

    @Test
    void testAjouterNoteNegativeLeveErreur() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        assertThrows(IllegalArgumentException.class, () -> e.ajouterNote(-1.0));
    }

    @Test
    void testAjouterNoteSuperieur20LeveErreur() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        assertThrows(IllegalArgumentException.class, () -> e.ajouterNote(21.0));
    }

    @Test
    void testAjouterCours() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        Cours c = new Cours("Math", "Dupont");
        e.ajouterCours(c);
        assertEquals(1, e.getCours().size());
        assertEquals("Math", e.getCours().get(0).getNom());
    }

    @Test
    void testMentionParDefautStandard() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.ajouterNote(15.0);
        assertEquals("Bien", e.getMention());
    }

    @Test
    void testChangerStrategieMention() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        e.ajouterNote(15.0);
        e.setStrategieMention(new MentionStricte());
        assertEquals("Assez Bien", e.getMention());
    }

    @Test
    void testObservateurNotifie() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        final boolean[] notifie = {false};
        Observateur obs = etu -> notifie[0] = true;
        e.enregistrer(obs);
        e.ajouterNote(12.0);
        assertTrue(notifie[0]);
    }

    @Test
    void testRetirerObservateur() {
        Etudiant e = new Etudiant("Alice", 20, "E001");
        final int[] compteur = {0};
        Observateur obs = etu -> compteur[0]++;
        e.enregistrer(obs);
        e.ajouterNote(12.0);
        e.retirer(obs);
        e.ajouterNote(14.0);
        assertEquals(1, compteur[0]);
    }
}

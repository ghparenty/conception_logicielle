import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TriParMoyenneTest {

    @Test
    void testTriDecroissantParMoyenne() {
        Etudiant a = new Etudiant("Alice", 20, "E001");
        Etudiant b = new Etudiant("Bob", 20, "E002");
        Etudiant c = new Etudiant("Charlie", 20, "E003");

        a.ajouterNote(10.0);
        b.ajouterNote(18.0);
        c.ajouterNote(14.0);

        List<Etudiant> liste = new ArrayList<>();
        liste.add(a);
        liste.add(b);
        liste.add(c);

        new TriParMoyenne().trier(liste);

        assertEquals("Bob", liste.get(0).getNom());
        assertEquals("Charlie", liste.get(1).getNom());
        assertEquals("Alice", liste.get(2).getNom());
    }

    @Test
    void testTriListeVide() {
        List<Etudiant> liste = new ArrayList<>();
        assertDoesNotThrow(() -> new TriParMoyenne().trier(liste));
        assertTrue(liste.isEmpty());
    }

    @Test
    void testTriUnSeulEtudiant() {
        List<Etudiant> liste = new ArrayList<>();
        liste.add(new Etudiant("Solo", 20, "E001"));
        new TriParMoyenne().trier(liste);
        assertEquals(1, liste.size());
    }
}

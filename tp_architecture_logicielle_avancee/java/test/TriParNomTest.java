import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TriParNomTest {

    @Test
    void testTriAlphabetique() {
        Etudiant z = new Etudiant("Zoe", 20, "E001");
        Etudiant a = new Etudiant("Anna", 20, "E002");
        Etudiant m = new Etudiant("Marc", 20, "E003");

        List<Etudiant> liste = new ArrayList<>();
        liste.add(z);
        liste.add(a);
        liste.add(m);

        new TriParNom().trier(liste);

        assertEquals("Anna", liste.get(0).getNom());
        assertEquals("Marc", liste.get(1).getNom());
        assertEquals("Zoe", liste.get(2).getNom());
    }

    @Test
    void testTriListeVide() {
        List<Etudiant> liste = new ArrayList<>();
        assertDoesNotThrow(() -> new TriParNom().trier(liste));
    }
}

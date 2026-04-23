import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScolariteManagerTest {

    @Test
    void testSingletonMemeInstance() {
        ScolariteManager m1 = ScolariteManager.getInstance();
        ScolariteManager m2 = ScolariteManager.getInstance();
        assertSame(m1, m2);
    }

    @Test
    void testAjouterEtudiant() {
        ScolariteManager manager = ScolariteManager.getInstance();
        int avant = manager.getNombreEtudiants();
        Etudiant e = new Etudiant("TestUnique1", 20, "TU001");
        manager.ajouterEtudiant(e);
        assertEquals(avant + 1, manager.getNombreEtudiants());
        manager.retirerEtudiant(e);
    }

    @Test
    void testRetirerEtudiant() {
        ScolariteManager manager = ScolariteManager.getInstance();
        Etudiant e = new Etudiant("TestUnique2", 20, "TU002");
        manager.ajouterEtudiant(e);
        int avant = manager.getNombreEtudiants();
        manager.retirerEtudiant(e);
        assertEquals(avant - 1, manager.getNombreEtudiants());
    }

    @Test
    void testMoyenneGeneraleAvecEtudiants() {
        ScolariteManager manager = ScolariteManager.getInstance();
        Etudiant e1 = new Etudiant("TestMoy1", 20, "TM001");
        Etudiant e2 = new Etudiant("TestMoy2", 20, "TM002");
        e1.ajouterNote(10.0);
        e2.ajouterNote(20.0);
        manager.ajouterEtudiant(e1);
        manager.ajouterEtudiant(e2);

        assertTrue(manager.getMoyenneGenerale() > 0);

        manager.retirerEtudiant(e1);
        manager.retirerEtudiant(e2);
    }

    @Test
    void testTrierEtudiantsParNom() {
        ScolariteManager manager = ScolariteManager.getInstance();
        Etudiant z = new Etudiant("Zoe", 20, "TZ001");
        Etudiant a = new Etudiant("Anna", 20, "TZ002");
        manager.ajouterEtudiant(z);
        manager.ajouterEtudiant(a);

        manager.trierEtudiants(new TriParNom());
        int idxAnna = manager.getEtudiants().indexOf(a);
        int idxZoe = manager.getEtudiants().indexOf(z);
        assertTrue(idxAnna < idxZoe);

        manager.retirerEtudiant(z);
        manager.retirerEtudiant(a);
    }
}

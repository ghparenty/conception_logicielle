import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtudiantDelegueTest {

    @Test
    void testDelegueConserveInfosEtudiant() {
        Etudiant bob = new Etudiant("Bob", 22, "E002");
        EtudiantDelegue delegue = new EtudiantDelegue(bob, "L3 Info");

        assertEquals("Bob", delegue.getNom());
        assertEquals(22, delegue.getAge());
        assertEquals("E002", delegue.getNumero());
    }

    @Test
    void testDelegueClasseRepresentee() {
        Etudiant bob = new Etudiant("Bob", 22, "E002");
        EtudiantDelegue delegue = new EtudiantDelegue(bob, "L3 Info");
        assertEquals("L3 Info", delegue.getClasseRepresentee());
    }

    @Test
    void testDecorationCumulee() {
        Etudiant charlie = new Etudiant("Charlie", 21, "E003");
        EtudiantBoursier boursier = new EtudiantBoursier(charlie, 3000.0);
        EtudiantDelegue delegue = new EtudiantDelegue(boursier, "L3 Info");

        assertEquals("Charlie", delegue.getNom());
        assertEquals("L3 Info", delegue.getClasseRepresentee());
    }

    @Test
    void testOrganiserReunion() {
        Etudiant bob = new Etudiant("Bob", 22, "E002");
        EtudiantDelegue delegue = new EtudiantDelegue(bob, "L3 Info");
        assertDoesNotThrow(() -> delegue.organiserReunion());
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MentionStricteTest {

    private final MentionStricte strategie = new MentionStricte();

    @Test
    void testTresBien() {
        assertEquals("Tres Bien", strategie.calculerMention(18.0));
        assertEquals("Tres Bien", strategie.calculerMention(20.0));
    }

    @Test
    void testBien() {
        assertEquals("Bien", strategie.calculerMention(16.0));
        assertEquals("Bien", strategie.calculerMention(17.9));
    }

    @Test
    void testAssezBien() {
        assertEquals("Assez Bien", strategie.calculerMention(14.0));
        assertEquals("Assez Bien", strategie.calculerMention(15.9));
    }

    @Test
    void testPassable() {
        assertEquals("Passable", strategie.calculerMention(12.0));
        assertEquals("Passable", strategie.calculerMention(13.9));
    }

    @Test
    void testInsuffisant() {
        assertEquals("Insuffisant", strategie.calculerMention(0.0));
        assertEquals("Insuffisant", strategie.calculerMention(11.9));
    }

    @Test
    void testMentionStricteEstPlusSevereQueStandard() {
        MentionStandard standard = new MentionStandard();
        // A 15/20, standard = "Bien" mais stricte = "Assez Bien"
        assertEquals("Bien", standard.calculerMention(15.0));
        assertEquals("Assez Bien", strategie.calculerMention(15.0));
    }
}

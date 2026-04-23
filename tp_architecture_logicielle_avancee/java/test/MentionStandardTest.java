import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MentionStandardTest {

    private final MentionStandard strategie = new MentionStandard();

    @Test
    void testTresBien() {
        assertEquals("Tres Bien", strategie.calculerMention(16.0));
        assertEquals("Tres Bien", strategie.calculerMention(20.0));
    }

    @Test
    void testBien() {
        assertEquals("Bien", strategie.calculerMention(14.0));
        assertEquals("Bien", strategie.calculerMention(15.9));
    }

    @Test
    void testAssezBien() {
        assertEquals("Assez Bien", strategie.calculerMention(12.0));
        assertEquals("Assez Bien", strategie.calculerMention(13.9));
    }

    @Test
    void testPassable() {
        assertEquals("Passable", strategie.calculerMention(10.0));
        assertEquals("Passable", strategie.calculerMention(11.9));
    }

    @Test
    void testInsuffisant() {
        assertEquals("Insuffisant", strategie.calculerMention(0.0));
        assertEquals("Insuffisant", strategie.calculerMention(9.9));
    }
}

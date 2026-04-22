import java.util.Arrays;
import java.util.List;

public class CoursLegacy {

    public List<String> recupererCoursFormatAncien() {
        return Arrays.asList(
                "Mathematiques|Dupont",
                "Physique|Martin",
                "Informatique|Durand",
                "Anglais|Smith"
        );
    }

    public String recupererCours(int index) {
        return recupererCoursFormatAncien().get(index);
    }
}

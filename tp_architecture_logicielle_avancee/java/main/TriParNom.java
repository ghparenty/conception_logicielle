import java.util.Comparator;
import java.util.List;

public class TriParNom implements StrategieTri {
    @Override
    public void trier(List<Etudiant> etudiants) {
        etudiants.sort(Comparator.comparing(Etudiant::getNom));
    }
}

import java.util.Comparator;
import java.util.List;

public class TriParMoyenne implements StrategieTri {
    @Override
    public void trier(List<Etudiant> etudiants) {
        etudiants.sort(Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
    }
}

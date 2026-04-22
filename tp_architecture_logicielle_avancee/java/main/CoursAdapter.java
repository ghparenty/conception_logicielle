import java.util.ArrayList;
import java.util.List;

public class CoursAdapter {
    private CoursLegacy systemeAncien;

    public CoursAdapter(CoursLegacy systemeAncien) {
        this.systemeAncien = systemeAncien;
    }

    public Cours convertir(String donneesLegacy) {
        if (donneesLegacy == null || !donneesLegacy.contains("|")) {
            throw new IllegalArgumentException("Format legacy invalide : " + donneesLegacy);
        }
        String[] parts = donneesLegacy.split("\\|");
        String nomCours = parts[0].trim();
        String professeur = parts.length > 1 ? parts[1].trim() : "Inconnu";
        return new Cours(nomCours, professeur);
    }

    public List<Cours> convertirTous() {
        List<Cours> resultat = new ArrayList<>();
        for (String chaine : systemeAncien.recupererCoursFormatAncien()) {
            resultat.add(convertir(chaine));
        }
        return resultat;
    }
}

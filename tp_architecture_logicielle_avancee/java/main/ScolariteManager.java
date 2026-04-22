import java.util.ArrayList;
import java.util.List;

public class ScolariteManager implements Observateur {
    private static ScolariteManager instance;

    private List<Etudiant> etudiants;
    private double moyenneGenerale;

    private ScolariteManager() {
        this.etudiants = new ArrayList<>();
        this.moyenneGenerale = 0.0;
    }

    public static ScolariteManager getInstance() {
        if (instance == null) {
            instance = new ScolariteManager();
        }
        return instance;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.enregistrer(this);
        recalculerStatistiques();
    }

    public void retirerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
        etudiant.retirer(this);
        recalculerStatistiques();
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public double getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public int getNombreEtudiants() {
        return etudiants.size();
    }

    @Override
    public void actualiser(Etudiant etudiant) {
        System.out.println("[ScolariteManager] Note ajoutee a " + etudiant.getNom()
                + " -> nouvelle moyenne : " + String.format("%.2f", etudiant.getMoyenne()));
        recalculerStatistiques();
    }

    private void recalculerStatistiques() {
        if (etudiants.isEmpty()) {
            moyenneGenerale = 0.0;
            return;
        }
        double somme = 0;
        for (Etudiant e : etudiants) {
            somme += e.getMoyenne();
        }
        moyenneGenerale = somme / etudiants.size();
    }

    public void trierEtudiants(StrategieTri strategie) {
        strategie.trier(etudiants);
    }

    public void afficherTous() {
        System.out.println("=== Liste des etudiants (" + etudiants.size() + ") ===");
        for (Etudiant e : etudiants) {
            e.afficherDetails();
        }
        System.out.println("Moyenne generale : " + String.format("%.2f", moyenneGenerale) + "/20");
    }
}

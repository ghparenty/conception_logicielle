public class Cours {
    private String nom;
    private String professeur;

    public Cours(String nom, String professeur) {
        this.nom = nom;
        this.professeur = professeur;
    }

    public String getNom() {
        return nom;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void afficherDetails() {
        System.out.println("  Cours : " + nom + ", Professeur : " + professeur);
    }
}

public class Professeur extends Personne {
    private String matiere;
    private double salaire;

    public Professeur(String nom, int age, String matiere, double salaire) {
        super(nom, age);
        this.matiere = matiere;
        this.salaire = salaire;
    }

    public String getMatiere() {
        return matiere;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Professeur : " + nom + ", " + age + " ans, Matiere : "
                + matiere + ", Salaire : " + salaire + " EUR");
    }
}

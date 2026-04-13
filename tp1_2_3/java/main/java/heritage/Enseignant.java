package heritage;

public class Enseignant extends Personne {
    private double salaire;

    public Enseignant(String nom, int age, double salaire) {
        super(nom, age);
        this.salaire = salaire;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Salaire : " + salaire + " EUR");
    }
}

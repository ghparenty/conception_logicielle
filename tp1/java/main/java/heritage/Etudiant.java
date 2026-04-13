package heritage;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Personne {
    private String numero;
    private double moyenne;
    private List<Cours> cours;

    public Etudiant(String nom, int age, String numero, double moyenne) {
        super(nom, age);
        this.numero = numero;
        setMoyenne(moyenne);
        this.cours = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        if (moyenne < 0 || moyenne > 20) {
            throw new IllegalArgumentException("La moyenne doit être comprise entre 0 et 20");
        }
        this.moyenne = moyenne;
    }

    public void ajouterCours(Cours cours) {
        this.cours.add(cours);
    }

    public List<Cours> getCours() {
        return cours;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Numero etudiant : " + numero + ", Moyenne : " + moyenne + "/20");
        if (!cours.isEmpty()) {
            System.out.println("Cours inscrits :");
            for (Cours c : cours) {
                c.afficherDetails();
            }
        }
    }
}

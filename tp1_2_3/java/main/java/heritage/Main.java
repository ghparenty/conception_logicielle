package heritage;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creation des cours
        Cours cours1 = new Cours("Mathematiques", "M. Dupont");
        Cours cours2 = new Cours("Informatique", "Mme Martin");
        Cours cours3 = new Cours("Physique", "M. Bernard");

        // Creation des etudiants
        Etudiant etudiant1 = new Etudiant("Alice", 20, "E001", 15.5);
        Etudiant etudiant2 = new Etudiant("Bob", 22, "E002", 12.0);

        etudiant1.ajouterCours(cours1);
        etudiant1.ajouterCours(cours2);

        etudiant2.ajouterCours(cours2);
        etudiant2.ajouterCours(cours3);

        // Creation des enseignants
        Enseignant enseignant1 = new Enseignant("M. Dupont", 45, 3500);
        Enseignant enseignant2 = new Enseignant("Mme Martin", 38, 3200);

        // TP2 : Test de modification avec une valeur invalide
        System.out.println("TP2 : Test validation");
        try {
            etudiant1.setMoyenne(25);
        } catch (IllegalArgumentException e) {
            System.out.println("Modification refusee : " + e.getMessage());
        }

        try {
            etudiant1.setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Modification refusee : " + e.getMessage());
        }

        // TP3 : Polymorphisme - liste de Personne mixte
        System.out.println("\nTP3 : Polymorphisme");
        List<Personne> personnes = new ArrayList<>();
        personnes.add(etudiant1);
        personnes.add(etudiant2);
        personnes.add(enseignant1);
        personnes.add(enseignant2);

        for (Personne p : personnes) {
            p.afficherDetails();
            System.out.println();
        }
    }
}

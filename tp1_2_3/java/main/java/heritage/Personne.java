package heritage;

public class Personne {
    private String nom;
    private int age;

    public Personne(String nom, int age) {
        setNom(nom);
        setAge(age);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("L'âge doit être compris entre 0 et 100");
        }
        this.age = age;
    }

    public void afficherDetails() {
        System.out.println("Nom : " + nom + ", Age : " + age);
    }
}

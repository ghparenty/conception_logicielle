public class PersonneFactory {

    public enum TypePersonne {
        ETUDIANT,
        PROFESSEUR
    }

    public static Personne creerPersonne(TypePersonne type, String nom, int age, Object... params) {
        switch (type) {
            case ETUDIANT:
                if (params.length < 1) {
                    throw new IllegalArgumentException("Numero etudiant requis");
                }
                return new Etudiant(nom, age, (String) params[0]);

            case PROFESSEUR:
                if (params.length < 2) {
                    throw new IllegalArgumentException("Matiere et salaire requis");
                }
                return new Professeur(nom, age, (String) params[0], ((Number) params[1]).doubleValue());

            default:
                throw new IllegalArgumentException("Type de personne inconnu : " + type);
        }
    }

    public static Etudiant creerEtudiant(String nom, int age, String numero) {
        return new Etudiant(nom, age, numero);
    }

    public static Professeur creerProfesseur(String nom, int age, String matiere, double salaire) {
        return new Professeur(nom, age, matiere, salaire);
    }
}

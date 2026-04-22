public class EtudiantDelegue extends EtudiantDecorator {
    private String classeRepresentee;

    public EtudiantDelegue(IEtudiant etudiant, String classeRepresentee) {
        super(etudiant);
        this.classeRepresentee = classeRepresentee;
    }

    public String getClasseRepresentee() {
        return classeRepresentee;
    }

    public void organiserReunion() {
        System.out.println("  [Delegue] " + getNom() + " organise une reunion pour la classe "
                + classeRepresentee);
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("  [Delegue] Represente la classe : " + classeRepresentee);
    }
}

public class EtudiantBoursier extends EtudiantDecorator {
    private double montantBourse;

    public EtudiantBoursier(IEtudiant etudiant, double montantBourse) {
        super(etudiant);
        this.montantBourse = montantBourse;
    }

    public double getMontantBourse() {
        return montantBourse;
    }

    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("  [Boursier] Montant de la bourse : " + montantBourse + " EUR / an");
    }
}

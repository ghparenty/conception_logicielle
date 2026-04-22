import java.util.List;

public abstract class EtudiantDecorator implements IEtudiant {
    protected IEtudiant etudiant;

    public EtudiantDecorator(IEtudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String getNom() {
        return etudiant.getNom();
    }

    @Override
    public int getAge() {
        return etudiant.getAge();
    }

    @Override
    public String getNumero() {
        return etudiant.getNumero();
    }

    @Override
    public double getMoyenne() {
        return etudiant.getMoyenne();
    }

    @Override
    public List<Cours> getCours() {
        return etudiant.getCours();
    }

    @Override
    public void afficherDetails() {
        etudiant.afficherDetails();
    }
}

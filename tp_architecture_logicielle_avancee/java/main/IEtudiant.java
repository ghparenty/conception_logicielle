import java.util.List;

public interface IEtudiant {
    String getNom();

    int getAge();

    String getNumero();

    double getMoyenne();

    List<Cours> getCours();

    void afficherDetails();
}

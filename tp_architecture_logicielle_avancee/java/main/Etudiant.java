import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Personne implements IEtudiant, Sujet {
    private String numero;
    private double moyenne;
    private List<Cours> cours;
    private List<Double> notes;
    private List<Observateur> observateurs;
    private StrategieMention strategieMention;

    public Etudiant(String nom, int age, String numero) {
        super(nom, age);
        this.numero = numero;
        this.cours = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.observateurs = new ArrayList<>();
        this.moyenne = 0.0;
        this.strategieMention = new MentionStandard();
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public double getMoyenne() {
        return moyenne;
    }

    @Override
    public List<Cours> getCours() {
        return cours;
    }

    public void ajouterCours(Cours c) {
        this.cours.add(c);
    }

    public void ajouterNote(double note) {
        if (note < 0 || note > 20) {
            throw new IllegalArgumentException("La note doit etre comprise entre 0 et 20");
        }
        this.notes.add(note);
        recalculerMoyenne();
        notifier();
    }

    private void recalculerMoyenne() {
        if (notes.isEmpty()) {
            this.moyenne = 0.0;
            return;
        }
        double somme = 0;
        for (double n : notes) {
            somme += n;
        }
        this.moyenne = somme / notes.size();
    }

    public void setStrategieMention(StrategieMention strategie) {
        this.strategieMention = strategie;
    }

    public String getMention() {
        return strategieMention.calculerMention(moyenne);
    }

    @Override
    public void enregistrer(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void retirer(Observateur observateur) {
        observateurs.remove(observateur);
    }

    @Override
    public void notifier() {
        for (Observateur o : observateurs) {
            o.actualiser(this);
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Etudiant : " + nom + ", " + age + " ans, Numero : "
                + numero + ", Moyenne : " + String.format("%.2f", moyenne)
                + "/20, Mention : " + getMention());
        if (!cours.isEmpty()) {
            System.out.println("  Cours inscrits :");
            for (Cours c : cours) {
                c.afficherDetails();
            }
        }
    }
}

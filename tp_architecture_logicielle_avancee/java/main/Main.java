import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("  TP Architecture Logicielle Avancee");
        System.out.println("  Systeme de Gestion Academique");
        System.out.println("=========================================\n");

        // --- 1. SINGLETON : ScolariteManager ---
        System.out.println("--- [1] SINGLETON : ScolariteManager ---");
        ScolariteManager manager = ScolariteManager.getInstance();
        ScolariteManager manager2 = ScolariteManager.getInstance();
        System.out.println("Meme instance ? " + (manager == manager2));
        System.out.println();

        // --- 2. FACTORY METHOD : PersonneFactory ---
        System.out.println("--- [2] FACTORY METHOD : PersonneFactory ---");
        Etudiant alice = (Etudiant) PersonneFactory.creerPersonne(
                PersonneFactory.TypePersonne.ETUDIANT, "Alice", 20, "E001");
        Etudiant bob = PersonneFactory.creerEtudiant("Bob", 22, "E002");
        Etudiant charlie = PersonneFactory.creerEtudiant("Charlie", 21, "E003");
        Professeur prof = (Professeur) PersonneFactory.creerPersonne(
                PersonneFactory.TypePersonne.PROFESSEUR, "Dupont", 45, "Mathematiques", 3500.0);
        alice.afficherDetails();
        prof.afficherDetails();
        System.out.println();

        // --- 4. ADAPTER : CoursAdapter ---
        System.out.println("--- [4] ADAPTER : CoursLegacy -> Cours ---");
        CoursLegacy legacy = new CoursLegacy();
        CoursAdapter adapter = new CoursAdapter(legacy);
        List<Cours> coursConvertis = adapter.convertirTous();
        System.out.println("Cours convertis depuis l'ancien systeme :");
        for (Cours c : coursConvertis) {
            c.afficherDetails();
        }
        alice.ajouterCours(coursConvertis.get(0));
        alice.ajouterCours(coursConvertis.get(1));
        bob.ajouterCours(coursConvertis.get(2));
        System.out.println();

        // --- 6. OBSERVER : notification ajout de note ---
        System.out.println("--- [6] OBSERVER : notification sur ajout de note ---");
        manager.ajouterEtudiant(alice);
        manager.ajouterEtudiant(bob);
        manager.ajouterEtudiant(charlie);
        alice.ajouterNote(15.0);
        alice.ajouterNote(17.0);
        bob.ajouterNote(12.0);
        bob.ajouterNote(9.0);
        charlie.ajouterNote(18.0);
        charlie.ajouterNote(16.0);
        System.out.println();

        // --- 5. STRATEGY : mention ---
        System.out.println("--- [5a] STRATEGY : calcul de mention ---");
        System.out.println("Alice (standard) : " + alice.getMoyenne() + " -> " + alice.getMention());
        alice.setStrategieMention(new MentionStricte());
        System.out.println("Alice (stricte)  : " + alice.getMoyenne() + " -> " + alice.getMention());
        alice.setStrategieMention(new MentionStandard());
        System.out.println();

        // --- 5. STRATEGY : tri ---
        System.out.println("--- [5b] STRATEGY : tri des etudiants ---");
        System.out.println("Tri par moyenne (decroissant) :");
        manager.trierEtudiants(new TriParMoyenne());
        for (Etudiant e : manager.getEtudiants()) {
            System.out.println("  " + e.getNom() + " : " + String.format("%.2f", e.getMoyenne()));
        }
        System.out.println("Tri par nom :");
        manager.trierEtudiants(new TriParNom());
        for (Etudiant e : manager.getEtudiants()) {
            System.out.println("  " + e.getNom() + " : " + String.format("%.2f", e.getMoyenne()));
        }
        System.out.println();

        // --- 3. DECORATOR : EtudiantBoursier / EtudiantDelegue ---
        System.out.println("--- [3] DECORATOR : EtudiantBoursier / EtudiantDelegue ---");
        IEtudiant aliceBoursiere = new EtudiantBoursier(alice, 4500.0);
        IEtudiant bobDelegue = new EtudiantDelegue(bob, "L3 Info");
        IEtudiant charlieBoursierDelegue = new EtudiantDelegue(
                new EtudiantBoursier(charlie, 3000.0), "L3 Info");

        aliceBoursiere.afficherDetails();
        System.out.println();
        bobDelegue.afficherDetails();
        ((EtudiantDelegue) bobDelegue).organiserReunion();
        System.out.println();
        System.out.println("Decoration cumulee (boursier + delegue) :");
        charlieBoursierDelegue.afficherDetails();
        System.out.println();

        // --- RECAP GLOBAL ---
        System.out.println("--- RECAPITULATIF GLOBAL ---");
        manager.afficherTous();
    }
}

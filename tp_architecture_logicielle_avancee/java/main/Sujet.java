public interface Sujet {
    void enregistrer(Observateur observateur);

    void retirer(Observateur observateur);

    void notifier();
}

public class Comparaison {
    protected String phrase1;
    protected String phrase2;

    /**
     * Constructeur de l'objet comparaison avec deux strings.
     *
     * @param phrase1 = phrase générée
     * @param phrase2 = phrase cible
     */
    public Comparaison(Phrase phrase1, Phrase phrase2) {
        this.phrase1 = phrase1.getPhrase();
        this.phrase2 = phrase2.getPhrase();
    }
}

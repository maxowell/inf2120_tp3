import java.util.ArrayList;

public class Phrase {

    private String phrase;

    /**
     * Constructeur de la classe Phrase. Permet de créer un objet de type phrase.
     * @param phrase La phrase.
     */
    public Phrase(String phrase ){
        this.phrase = phrase;
    }

    private String getPhrase(){
        return this.phrase;
    }

    private String[] decomposerPhrase(){
        return this.phrase.split("/,'-");
    }

    public ArrayList<String[]> obtenirGramme(int n){
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> gramme = new ArrayList<>();

        for(int i = 0; i < phrase.length; i++ ){
            String[] temp = new String[n];
            temp[i] = phrase[i];
            gramme.add(temp);
        }

        return gramme;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Phrase {

    private String phrase;
    private ArrayList<String[]> ngramme1;
    private ArrayList<String[]> ngramme2;
    private ArrayList<String[]> ngramme3;
    private ArrayList<String[]> ngramme4;

    /**
     * Constructeur de la classe Phrase. Permet de créer un objet de type phrase.
     * @param phrase La phrase.
     */
    public Phrase( String phrase ){

        this.phrase = phrase;
        this.ngramme1 = obtenir1Gramme();
        this.ngramme2 = obtenir2Gramme();
        this.ngramme3 = obtenir3Gramme();
        this.ngramme4 = obtenir4Gramme();
    }

    public String getPhrase(){
        return this.phrase;
    }

    private String[] decomposerPhrase(){
        return this.phrase.split("\\P{Alpha}+");
    }

    public ArrayList<String[]> obtenir1Gramme(){
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> gramme = new ArrayList<>();

        for(int i = 0; i < phrase.length; i++ ){
            String[] temp = new String[1];
            temp[0] = phrase[i];
            gramme.add(temp);
        }

        return gramme;
    }

    public ArrayList<String[]> obtenir2Gramme(){
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> gramme = new ArrayList<>();

        for(int i = 0; i < phrase.length - 1; i++){
            String[] temp = new String[2];
            temp[0] = phrase[i];
            temp[1] = phrase[i+1];
            gramme.add(temp);
        }

        return gramme;
    }

    public ArrayList<String[]> obtenir3Gramme(){
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> gramme = new ArrayList<>();

        for(int i = 0; i < phrase.length - 2; i++){
            String[] temp = new String[3];
            temp[0] = phrase[i];
            temp[1] = phrase[i+1];
            temp[2] = phrase[i+2];
            gramme.add(temp);
        }

        return gramme;
    }

    public ArrayList<String[]> obtenir4Gramme(){
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> gramme = new ArrayList<>();

        for(int i = 0; i < phrase.length - 3; i++){
            String[] temp = new String[4];
            temp[0] = phrase[i];
            temp[1] = phrase[i+1];
            temp[2] = phrase[i+2];
            temp[3] = phrase[i+3];
            gramme.add(temp);
        }

        return gramme;
    }


    public ArrayList<String[]> getNgramme1() {
        return ngramme1;
    }
    public ArrayList<String[]> getNgramme2() {
        return ngramme2;
    }
    public ArrayList<String[]> getNgramme3() {
        return ngramme3;
    }
    public ArrayList<String[]> getNgramme4() {
        return ngramme4;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "phrase='" + phrase + '\'' +
                '}';
    }
}

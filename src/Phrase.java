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
        this.ngramme1 = getNGramme(1);
        this.ngramme2 = getNGramme(2);
        this.ngramme3 = getNGramme(3);
        this.ngramme4 = getNGramme(4);
    }

    public String getPhrase(){
        return this.phrase;
    }

    private String[] decomposerPhrase(){
        return this.phrase.split("\\P{Alpha}+");
    }

    public ArrayList<String[]> getNGramme(int n) {
        String[] phrase = decomposerPhrase();
        ArrayList<String[]> nGramme = new ArrayList<>();

        for (int i = 0; i < (phrase.length - n + 1); i++) {
            String[] temp = new String[n];
            int j = 0;
            while (j < n) {
                temp[j] = phrase[i+j];
                j++;
            }
            nGramme.add(temp);
        }
        return nGramme;
    }

    /**
     * Imprime les 4 n-grammes d'une phrase au terminal.
     *
     * @param phrase = objet Phrase dont on veut imprimer les n-grammes.
     * @param p = numéro de la phrase (1 == générée, 2 == cible).
     */
    public static void print(Phrase phrase, int p) {
        for (int i = 1; i < 5; i++) {
            System.out.print("\n" + i + Constantes.MIDDLE + p + Constantes.FINAL);
            printNGramme(phrase.getNgramme(i));
        }
    }

    /**
     * Retourne le n-gramme demandé de la phrase sur laquelle la méthode est appelée.
     *
     * @param n = numéro du n-gramme
     * @return gramme 1, 2, 3 ou 4 en fonction de ce qui est demandé.
     */
    public ArrayList<String[]> getNgramme(int n) {
        ArrayList<String []> gramme;
        if (n == 1) {
            gramme = ngramme1;
        }else if (n == 2) {
            gramme = ngramme2;
        }else if (n == 3) {
            gramme = ngramme3;
        }else {
            gramme = ngramme4;
        }
        return gramme;
    }

    /**
     * Imprime un ngrammeX au terminal.
     *
     * @param nGramme = champs ngrammeX d'un objet Phrase qu'on veut imprimer.
     */
    public static void printNGramme(ArrayList<String[]> nGramme) {
        System.out.print("[");
        for(int i = 0; i < nGramme.size(); i++){
            String[] el = nGramme.get(i);
            for(int j = 0; j < el.length; j++){
                separateTabStart(el, j);

                System.out.print(el[j]);

                separateTabEnd(el,j);
            }
            separateNGramme(nGramme,i);
        }
        System.out.print("]\n");
    }

    /**
     * Sépare les différents éléments d'un tableau en imprimant un guillemet ou une parenthèse.
     * Si on est au premier élément du tableau et que la longueur du tableau est supérieur à 1,
     * imprime également une parenthèse ouvrante.
     * Sinon, imprime seulement une virgule.
     *
     * @param el = tableau de Strings qu'on veut séparer.
     * @param j = numéro de l'élément ou on doit séparer.
     */
    public static void separateTabStart(String[] el, int j) {
        if (j == 0 && el.length != 1) {
            System.out.print("(\"");
        }else if (el.length == 1){
            System.out.print("\"");
        }
    }

    /**
     * Sépare les différents éléments d'un tableau en imprimant un guillemet, une virgule ou une parenthèse.
     * Si on est pas au dernier élément du tableau, imprime un guillement, suivi d'une virgule,
     * suivi d'un autre guillemet.
     * Si on est au dernier élément, imprime un guillet suivi d'une parenthèse fermante.
     *
     * @param el = tableau de Strings qu'on veut séparer.
     * @param j = numéro de l'élément ou on doit séparer.
     */
    public static void separateTabEnd(String[] el, int j) {
        if (j != el.length - 1) {
            System.out.print("\", \"");
        }else if (el.length != 1) {
            System.out.print("\")");
        }
    }

    /**
     * Sépare les différents tableaux de Strings du nGramme en imprimant une virgule.
     * Ajoute une virgule seulement si on est pas au dernier élément du ArrayList<String[]>
     * Si la longueur du tableau est 1, alors ajoute un guillemet avant la virgule.
     *
     * @param nGramme = ArrayList<String[]> dont on veut séparer les éléments.
     * @param i = numéro de l'élément ou on est rendu.
     */
    public static void separateNGramme(ArrayList<String[]> nGramme, int i) {
        if (nGramme.get(i).length == 1) {
            System.out.print("\"");
        }
        if (i != nGramme.size() - 1) {
            System.out.print(", ");
        }
    }
}

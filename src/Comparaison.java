import java.util.Arrays;

public class Comparaison {
    protected Phrase generee;
    protected Phrase cible;
    protected int c1;
    protected int c2;
    protected int c3;
    protected int c4;

    /**
     * Constructeur de l'objet comparaison avec deux strings.
     *
     * @param generee = phrase générée
     * @param cible = phrase cible
     */
    public Comparaison(Phrase generee, Phrase cible) {
        this.generee = generee;
        this.cible = cible;
        calcSetC();
    }

    public void calcSetC() {
        for (int n = 1; n < 5; n++) {
            int c = 0;
            for (int i = 0; i < generee.getNGramme(n).size(); i++) {
                for (int j = 0; j < cible.getNgramme(n).size(); j++) {
                    if (caseInsensitiveComparison(generee.getNgramme(n).get(i), cible.getNgramme(n).get(j))) {
                        c++;
                        i++;
                    }
                }
            }
            setC(c,n);
        }
    }

    public void setC(int c, int n) {
        if (n == 1) {
            this.c1 = c;
        }else if (n == 2) {
            this.c2 = c;
        }else if (n == 3) {
            this.c3 = c;
        }else {
            this.c4 = c;
        }
    }

    public static boolean caseInsensitiveComparison(String[] g, String[] c) {
        boolean v = true;
        if (g.length == c.length) {
            for (int i = 0; i < g.length; i++) {
                if (!g[i].equalsIgnoreCase(c[i])) {
                    v = false;
                }
            }
        }else {
            v = false;
        }
        return v;
    }
}

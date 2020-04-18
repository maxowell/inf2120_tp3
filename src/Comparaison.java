/**
 * Logiciel qui compare la similarité de deux phrases.
 *
 * @author Maxime Ouellet
 * @author Mathieu Des Lauriers
 * @version 1.0.0
 */
import java.util.ArrayList;

public class Comparaison {

    protected Phrase generee;
    protected Phrase cible;

    protected int c1;
    protected int c2;
    protected int c3;
    protected int c4;

    protected static ArrayList<String[]> toAvoid = new ArrayList<>();

    protected double r1;
    protected double r2;
    protected double r3;
    protected double r4;

    protected double q1;
    protected double q2;
    protected double q3;
    protected double q4;

    protected double f1;
    protected double f2;
    protected double f3;
    protected double f4;


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
        calcR();
        calcQ();
        calcF();
    }

    /**
     * Calcule les différentes cardinalités.
     * La cardinalité de n est augmentée si les deux grammes sont identiques et s'ils n'ont pas déjà été utilisés.
     */
    public void calcSetC() {
        for (int n = 1; n < 5; n++) {
            int c = 0;
            for (int i = 0; i < generee.setNGramme(n).size(); i++) {
                for (int j = 0; j < cible.getNGramme(n).size(); j++) {
                    if (!toAvoid.contains(generee.getNGramme(n).get(i)) &&
                            caseInsensitiveComparison(generee.getNGramme(n).get(i), cible.getNGramme(n).get(j))) {
                        c++;
                    }
                }
            }
            setC(c,n);
        }
    }

    /**
     * Initialise les valeurs des cardinalités en fonction du numéro de cardinalité et du nombre à y assigner.
     *
     * @param c = nombre à assigner
     * @param n = numéro de cardinalité
     */
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

    /**
     * Compare deux tableaux de Strings, retourne vrai si ils sont égaux, faux sinon.
     * Si ils sont égaux, les ajoute au ArrayList toAvoid afin qu'ils ne soient pas recomparés.
     *
     * @param g = tableau de String 1
     * @param c = tableau de String 2
     * @return v = boolean true si g == c, faux sinon.
     */
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
        if (v) toAvoid.add(g);
        return v;
    }

    /**
     * Calcul et initalise la valeur des différents rappels.
     */
    public void calcR() {
        this.r1 = Double.valueOf(this.c1) / cible.getNGramme(1).size();
        this.r2 = Double.valueOf(this.c2) / cible.getNGramme(2).size();
        this.r3 = Double.valueOf(this.c3) / cible.getNGramme(3).size();
        this.r4 = Double.valueOf(this.c4) / cible.getNGramme(4).size();
    }

    /**
     * Calcul et initialise la valeur des différentes précisions.
     */
    public void calcQ() {
        this.q1 = Double.valueOf(this.c1) / generee.getNGramme(1).size();
        this.q2 = Double.valueOf(this.c2) / generee.getNGramme(2).size();
        this.q3 = Double.valueOf(this.c3) / generee.getNGramme(3).size();
        this.q4 = Double.valueOf(this.c4) / generee.getNGramme(4).size();
    }

    /**
     * Calcul et initialise la valeur des différentes f-mesures.
     */
    public void calcF() {
        this.f1 = (2 * r1 * q1) / (r1 + q1);
        this.f2 = (2 * r2 * q2) / (r2 + q2);
        this.f3 = (2 * r3 * q3) / (r3 + q3);
        this.f4 = (2 * r4 * q4) / (r4 + q4);
    }
}

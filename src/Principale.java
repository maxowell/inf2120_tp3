/**
 * Logiciel qui compare la similarité de deux phrases.
 *
 * @author Maxime Ouellet
 * @author Mathieu Des Lauriers
 * @version 1.0.0
 */
import java.util.Scanner;

public class Principale {

    /**
     * Cette méthode lance le programme.
     * Demande à l'utilisateur d'entrer la phrase générée puis la phrase cible.
     * Ensuite, appelle la fonction qui effectue les différents calculs du programme.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print(Constantes.DEMANDE_GENEREE);
        String textePhrase1 = "lors";
        System.out.println();
        System.out.print(Constantes.DEMANDE_CIBLE);
        String textePhrase2 = "lorsque";
        System.out.println();

        in.close();

        // Créer les objets Phrase
        Phrase phrase1 = new Phrase(textePhrase1);
        Phrase phrase2 = new Phrase(textePhrase2);

        // Imprimer les n-grammes de chaque phrase
        Phrase.print(phrase1,1);
        Phrase.print(phrase2,2);

        Comparaison comparaison = new Comparaison(phrase1, phrase2);

        System.out.println(Constantes.C1 + comparaison.c1 +
                Constantes.C2 + comparaison.c2 +
                Constantes.C3 + comparaison.c3 +
                Constantes.C4 + comparaison.c4 + ".");

        System.out.println(Constantes.R1 + comparaison.r1 +
                Constantes.R2 + comparaison.r2 +
                Constantes.R3 + comparaison.r3 +
                Constantes.R4 + comparaison.r4 + ".");

        System.out.println(Constantes.Q1 + comparaison.q1 +
                Constantes.Q2 + comparaison.q2 +
                Constantes.Q3 + comparaison.q3 +
                Constantes.Q4 + comparaison.q4 + ".");

        System.out.println(Constantes.F1 + comparaison.f1 +
                Constantes.F2 + comparaison.f2 +
                Constantes.F3 + comparaison.f3 +
                Constantes.F4 + comparaison.f4 + ".");
    }
}

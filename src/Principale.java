import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.ArrayList;
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
        String textePhrase1 = "Lors de la construction d'un tableau.";
        System.out.println();
        System.out.print(Constantes.DEMANDE_CIBLE);
        String textePhrase2 = "Lors de la construction d'un logiciel contenant un tableau.";
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
                         Constantes.C4 + comparaison.c4);
    }
}

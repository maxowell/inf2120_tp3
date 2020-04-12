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
        String phrase1 = in.nextLine();
        System.out.print(Constantes.DEMANDE_CIBLE);
        String phrase2 = in.nextLine();

        in.close();
        new Comparaison(phrase1,phrase2);
    }
}

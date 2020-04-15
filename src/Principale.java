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
        String textePhrase1 = in.nextLine();
        System.out.print(Constantes.DEMANDE_CIBLE);
        String textePhrase2 = in.nextLine();

        in.close();

        // Créer les objets Phrase
        Phrase phrase1 = new Phrase(textePhrase1);
        Phrase phrase2 = new Phrase(textePhrase2);

        ArrayList<String[]> phrase = phrase1.getNgramme1();
        ArrayList<String[]> ngramme2 = phrase1.getNgramme2();
        ArrayList<String[]> ngramme3 = phrase1.getNgramme3();
        ArrayList<String[]> ngramme4 = phrase1.getNgramme4();

        for(int i = 0; i < phrase.size(); i++){
            String[] el = phrase.get( i );
            for(int j = 0; j < el.length; j++){
                System.out.print(el[0] + ", ");
            }
        }

        System.out.println(" ");

        for(int i = 0; i < ngramme2.size(); i++){
            String[] el = ngramme2.get( i );

            for(int j = 0; j < el.length; j++){
                System.out.print(el[j] + " ");
            }
            System.out.println(",");
        }


        System.out.println(" ");

        for(int i = 0; i < ngramme3.size(); i++){
            String[] el = ngramme3.get( i );

            for(int j = 0; j < el.length; j++){
                System.out.print(el[j] + " ");
            }
            System.out.println(",");
        }

        System.out.println(" ");

        for(int i = 0; i < ngramme4.size(); i++){
            String[] el = ngramme4.get( i );

            for(int j = 0; j < el.length; j++){
                System.out.print(el[j] + " ");
            }
            System.out.println(",");
        }



        //new Comparaison(phrase1,phrase2);
    }
}

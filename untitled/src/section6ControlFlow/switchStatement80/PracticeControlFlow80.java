package section6ControlFlow.switchStatement80;

import java.util.Random;

/**
 * Section 6 Control Flow - 80 The Switch Statement
 *
 * switch fait exactement la meme chose que if() else if() else()
 *
 * Avantages :
 * - switch est plus facile à lire on prefére l'utiliser
 * - switch s'execute plus rapidement que if() esle if(), car fait une optimisation fait par le compileur
 *
 * pb :
 * - on doit rajouter les mot break à la fin de chaque case => facile à oublier
 * - pas de façon simple de se protéger contre les variable null => Erreur si on fait un switch sur un variable null => Vous devrez donc effectuer une vérification explicite au préalable avec if() else() pour vous assurer que la variable n'est pas nulle.
 */
class PracticeControlFlow80 {

    public static void main(String[] args) {



        int randomNumber = new Random().nextInt(3) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber);

        //____________________Sur variable de type nbre_______________________________
        //___________________Methode 1 avec if()________________________
        if (randomNumber == 4) { // if() => prend tjrs 1 boolean entre parentheses, si c'est true execute le code à l'interieur des {} si false passe au else if suivant | EX si le randomNumber est différent de 4
            System.out.printf("Le nbre random %d est différent de 4", randomNumber);
        } else if (randomNumber == 3) {  // else if() => si non idem à if | RQ peut en arg une fct qui return un boolean (true ou false)
            System.out.println("3");
        } else if (randomNumber == 2 ) {
            System.out.println("2");
        } else if (randomNumber == 1) {
            System.out.println("1");
        } else {  // else => s'éxecute si aucun if() ou if else() n'a été executé
            System.out.println("0");
        }

        //___________________Methode 2 switch()________________________
        switch (randomNumber) {
            case 0 :
                System.out.println("0");
                break;                         // break => Si on ne le met pas execute les case en dessous tant qu'il ne rencontre pas ce mot clé
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default :                          // default => s'execute si aucun case n'a été trouvé
                System.out.println("3");
                break;
        }


        //____________________Sur variable de type String_______________________________
        //___________________Methode 1 avec if()________________________
        String command = "stop";

        if (command.equals("stop")) {
            System.out.println("Stopping now...");
        } else if (command.equals("go")) {
            System.out.println("Going now...");
        } else {
            System.out.println("commande not understood...");
        }

        //___________________Methode 2 switch()________________________
        switch (command) {
            case "stop":
                System.out.println("Stopping now...");
                break;
            case "go":
                System.out.println("Going now...");
                break;
            default:
                System.out.println("commande not understood...");
                break;
        }


        //_____________________Eviter une ERREUR avec variable possiblement null___________________________
        //___________________Methode 1 avec if()________________________
        String command2 = null;
        if ("stop".equals(command2)) {  // inverser simplement l'ordre de l'égalité | l'erreur venait qu'on demandait une action sur un objet qui n'existe pas null
            System.out.println("Arretez vous maintenant");
        }

        //___________________Methode 2 switch()________________________
        if (command2 == null) {         // if() => un moyen de se protéger un switch() avec les variables de valeur null
            System.out.println("commande incomprise");
        } else {                       // si la variable n'est pas null on entre dans ce block et on execute le switch
            switch (command) {
                case "stop":
                    System.out.println("Arrez vous");
                    break;
                case "go":
                    System.out.println("Allez y");
                    break;
                default:
                    System.out.println("commande incomprise");
            }
        }



    }
}

package section6ControlFlow.whileLoopsPartOne83;

import java.util.Random;

/**
 * Section 6 Control Flow - 83 While Loops: Part One
 *
 * Pour faire fonctionner la console on doit utiliser le Terminal et lancer le file déja build (bit) ex :
 *
 * java -cp out\production\section1-6\section6ControlFlow\whileLoopsPartOne83 PracticeControlFlow83
 *
 * Rq n'a pas marché
 *
 * RQ Ctrl C => sortir du Terminal
 */
class PracticeControlFlow83 {

    public static void main(String[] args) {

        int randomNum = new Random().nextInt(10) +1; // Générer un nbre random entre [1, 10] inclus grace au +1 | le sort de la boucle while pour ne le générer qu'1 foi
        while (true) { // Tant que ce qui est entre parentheses est true il répéte le bloc de code en dessous (loop)
            String inputUserText = System.console().readLine("Merci de deviner un chiffre : "); // System.console() => ouvre ou console | readLine() => lire les input de clavier user | lance ça depuis terminale
            int inputUser = Integer.parseInt(inputUserText);  // Convertir un string (input user dans console) en int
            if (inputUser == randomNum) {  // Si user à trouver le nbre généré en random => true entre dans le bloc if
                System.out.printf("Bravo vous avez trouver le bon nombre %d %n", randomNum);
                return; // Permet de sortir d'une méthode ex main()  et d'arreter ainsi le programme
            } else {
                System.out.println("Perdu");
            }
        }

    }
}

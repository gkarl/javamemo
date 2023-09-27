package section6ControlFlow.doWhileLoopsPartOne85;

import java.util.Random;

/**
 * Section 6 Control Flow - 85 Do/While Loops: Part One
 *
 *  SUITE => Programme ou user cherche un nbre random
 *
 *  il veut que le programme affiche le nbre d'essay que ça à pris pour trouver le bon nbre
 *  il veut qu'il affiche "try" 1er essaye et "tries" qd il y a plusieurs essais
 */
class PracticeControlFlow85 {

    public static void main(String[] args) {

        int randomNum = new Random().nextInt(10) +1;
        String inputUserText = null;
        int nbTentative = 1;  // bien mettre initialisation du compteur hors de la boucle si non cette variable serait réinitialisé à chaque tour de boucle
        do {  // ça garantit que le loop soit executé au moin 1 fois
            inputUserText = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText.matches("-?\\d{1,2}")) {
                int inputUser = Integer.parseInt(inputUserText);
                if (inputUser == randomNum) {
                    String tryText = nbTentative == 1 ? "try" : "tries";   // Opérateur Ternaire permet de faire une condition en 1 ligne | Si le nbre de tentative est égale à 1 stock "try" si non stock "Tries"
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum, nbTentative, tryText); // affiche "try" ou "Tries" suivant le nbre de tentative
                    return;
                } else {
                    nbTentative++;  // Incrément du compteur à chaque echec de user
                    System.out.println("Perdu");
                }
            }
        } while (!"q".equals(inputUserText)); // la boucle while garde sa condition avec elle

    }
}

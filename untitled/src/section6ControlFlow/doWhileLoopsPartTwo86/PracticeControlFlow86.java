package section6ControlFlow.doWhileLoopsPartTwo86;

import java.util.Random;

/**
 * Section 6 Control Flow - 86 Do/While Loops: Part Two
 *
 *  SUITE => Programme ou user cherche un nbre random
 *
 *  Il veut limiter le nbre d'essaye
 *
 */
class PracticeControlFlow86 {

    public static void main(String[] args) {

        int randomNum = new Random().nextInt(10) +1;
        String inputUserText = null;
        int nbTentative = 1;
        int NB_MAX_ESSAIES = 4;  // cette constante détermine le nbre d'essaie max | constante ecrit en majuscule
        do {
            inputUserText = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText.matches("-?\\d{1,2}")) {
                int inputUser = Integer.parseInt(inputUserText);
                if (inputUser == randomNum) {
                    String tryText = nbTentative == 1 ? "try" : "tries";
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum, nbTentative, tryText);
                    return;
                } else {
                    nbTentative++;
                    if (nbTentative > NB_MAX_ESSAIES) { // juste pour afficher message on a plus d'essaie | On aurais pu le mettre hors du loop moin d'imbrication (Nesting) de else if
                        System.out.printf("Vous avez depassé le nbre d'essaies max qui de %d la réponse était %d. %n", nbTentative, randomNum);
                        //return; Dans le while && condition de sortie plus besoin de mettre fin au programme ici
                    }
                    System.out.println("Perdu");
                }
            }
        } while (!"q".equals(inputUserText) && nbTentative <= NB_MAX_ESSAIES); // && => AND il faut que les 2 conditions soit a true pour que le resultat soit true => le programme continue

    }
}

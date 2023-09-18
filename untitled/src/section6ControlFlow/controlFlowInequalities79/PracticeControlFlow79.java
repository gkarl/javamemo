package section6ControlFlow.controlFlowInequalities79;

import java.util.Random;

/**
 * Section 6 Control Flow - 79 Control Flow Inequalities
 */
class PracticeControlFlow79 {


    public static void main(String[] args) {

        int randomNumber = new Random().nextInt(5) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber);
        if (randomNumber > 4) {
            System.out.println("Le nbre est supérieur à 4");
        } else if (randomNumber != 3 && randomNumber % 2 == 0) { // && => AND on peut ces éléments dans la condition d'un if() ou else if()| x % 2 == 0 => si x est nbre paire return true si non false
            System.out.println("Le nbre est différent de 3 et est un nbre paire");
        } else if (randomNumber == 2 || randomNumber % 2 != 0) {  // => OR
            System.out.println("Le nbre est égale à 2 ou est un nbre paire");
        } else if (randomNumber == 1) {
            System.out.println("Le nbre est égale à 1");
        } else {
            System.out.println("Le nbre est tous les autres cas non défini dans les if else if");
        }

    }
}

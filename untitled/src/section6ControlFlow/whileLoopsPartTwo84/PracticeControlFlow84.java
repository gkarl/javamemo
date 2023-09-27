package section6ControlFlow.whileLoopsPartTwo84;

import java.util.Random;

/**
 * Section 6 Control Flow - 84 While Loops: Part Two
 *
 *  SUITE => Programme ou user cherche un nbre random
 *
 *  Veux mettre une condition à while => quitte le programme si user tape la lettre "q"
 */
class PracticeControlFlow84 {

    public static void main(String[] args) {

        int randomNum = new Random().nextInt(10) +1;
        String inputUserText = null; // Déclare cette variable avant la boucle while pour pouvoir l'utiliser dans sa condition
        while(!"q".equals(inputUserText)) {  //** tant que user n'entre pas la lettre "q" boucle le block de code en dessous | une methode ne peut pas etre appliqué à un objet null pour éviter ça il a switché "q" et inputUserText
            inputUserText = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText.matches("-?\\d{1,2}")) { //** Si user entre un nbre entre dans ce bloc pour le mettre en place utilise Regex  - => négatif | ? => 0 ou 1 =>  positif ou négatif | d{1,2} => nbre avec 1 ou 2 chiffres
                int inputUser = Integer.parseInt(inputUserText);
                if (inputUser == randomNum) {
                    System.out.printf("Bravo vous avez trouver le bon nombre %d %n", randomNum);
                    return;
                } else {
                    System.out.println("Perdu");
                }
            }
        }

    }
}

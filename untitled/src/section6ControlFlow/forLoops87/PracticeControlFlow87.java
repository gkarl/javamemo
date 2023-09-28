package section6ControlFlow.forLoops87;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;

/**
 * Section 6 Control Flow - 87 For Loops
 *
 * SUITE => Programme ou user cherche un nbre random
 */
class PracticeControlFlow87 {

    public static void main(String[] args) {

        int randomNum = new Random().nextInt(10) +1;
        String inputUserText = null;
        int NB_MAX_ESSAIES = 4;
        int nbTentative; // Pour dés raison de Scope On initialise cette variable à l'extérieur de la boucle for() car elle est utilisé à l'extérieur par le if()
//        do {
        for (nbTentative = 1; nbTentative <= NB_MAX_ESSAIES; nbTentative++) {  // for() => boucle on définit le nbre d'itérations 1/ Initialise le nbre une variable qui servira à d'itération | 2/ jusqu'a combien cette variable pourra aller pour itérer | incrémente cette variable à chaque itération
            inputUserText = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText.matches("-?\\d{1,2}")) {
                int inputUser = Integer.parseInt(inputUserText);
                if (inputUser == randomNum) {
                    String tryText = nbTentative == 1 ? "try" : "tries";
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum, nbTentative, tryText);
//                  return;
                    break;  // break => Dit au Thread c'est fini sort de la boucle
                } else {  // Si on a pas trouvé
//                    nbTentative5++;
                    if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY)) {  // et qu'on est un lundi | Ce if n'est pas utile au programme juste pour montrer intéret du mot clé continue
                        System.out.printf("Tu ne la pas trouve");
                        continue; // continue => Dit au Thread ne fait pas la suite du code dans la boucle et passe à l'itération suivante | généralement utilisé quand on a des else if imbriqué
                    }
                    System.out.println("Perdu");
                }
            }
        }
//        } while (!"q".equals(inputUserText5) && nbTentative5 <= NB_MAX_ESSAIES);

        if (nbTentative > NB_MAX_ESSAIES) {
            System.out.printf("Vous avez depassé le nbre d'essaies max qui de %d la réponse était %d. %n", nbTentative, randomNum);
            //return;
        }
    }
}

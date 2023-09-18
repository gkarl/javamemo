package section6ControlFlow.conditionalsWithIfElse78;

import java.util.Random;

/**
 * Section 6 Control Flow - 78  Conditionals with If/Else
 */
class PracticeControlFlow78 {

    private static boolean shouldIGo() {
        return true;
    }
    public static void main(String[] args) {


        int randomNumber = new Random().nextInt(4) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber);
        if (randomNumber != 4) { // if() => prend tjrs 1 boolean entre parentheses, si c'est true execute le code à l'interieur des {} si false passe au else if suivant | EX si le randomNumber est différent de 4
            System.out.printf("Le nbre random %d est différent de 4", randomNumber);
        } else if (shouldIGo()) {  // else if() => si non idem à if | RQ peut en arg une fct qui return un boolean (true ou false)
            System.out.println("3");
        } else if (randomNumber == 2 ) {
            System.out.println("2");
        } else if (randomNumber == 1) {
            System.out.println("1");
        } else {  // else => s'éxecute si aucun if() ou if else() n'a été executé
            System.out.println("0");
        }
    }
}

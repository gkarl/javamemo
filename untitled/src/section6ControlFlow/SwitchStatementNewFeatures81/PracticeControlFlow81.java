package section6ControlFlow.SwitchStatementNewFeatures81;

/**
 * Section 6 Control Flow - 81 Switch Statement: New Features
 *
 * Nouvelle façon d'utiliser l'instruction switch qui a été ajoutée à Java 14 :
 *
 * - maintenant il peut retourner une valeur (-> ou yield)
 * - et aussi combiner des conditions qui retourneront la meme valeur
 *
 * Pour activer cette nell fonctionalité du switch :
 * Clic D project directory / Open Module Settings / Project / 17 - Pattern matching for switch
 */

class PracticeControlFlow81 {


    public static void main(String[] args) {


        String cardReceive = "3";

        int maintTotal = 11;

        int cardValue = switch (cardReceive) {  // La valeur retournée par le switch est stocké dans une variable
            case "roi", "reine", "valet" -> 10; // 3 cartes ont la meme valeur | -> 10 => return la valeur de 10
            case "ace" -> {
                if (maintTotal <= 10) {
                    yield 11;  // si la valeur de ma main est inf à 10 alors on donne (return) à l'as la valeur de 11 | yield => c'est équivalent à un return (Java 14)
                } else {
                    yield 1;  // Si non on donne à l'as la valeur de 1
                }
            }
            default -> Integer.parseInt(cardReceive);  // Cas ou la valeur de la carte est un nbre ex "3" "4" ... | cardReceive sur lequel on fait le switch est de type String la variable qui va stocker le return du switch est de type int => On a besoin de convertir un String en int
        };

        System.out.printf("La valeur de la carte recu est %d \n", cardValue);

        System.out.printf("La valeur total de la main devient %d \n ", maintTotal + cardValue);
    }
}

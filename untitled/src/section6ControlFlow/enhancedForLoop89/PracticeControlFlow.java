package section6ControlFlow.enhancedForLoop89;

/**
 * Section 6 Control Flow - 89 The Enhanced For Loop (La boucle For améliorée)
 *
 * un moyen simple quand on veut boucler pour afficher les element d'un Array
 */
class PracticeControlFlow {

    public static void main(String[] args) {

        //_________________Methode 1_____________________________
        String[] fruits = {"banane", "papille", "litchi", "mague"};
        for (int counter = 0; counter < fruits.length; counter++) {
            System.out.printf("les fruits tropico sont : %s %n", fruits[counter]);
        }

        //_________________Methode 2_____________________________
        String[] fruits2 = {"banane", "papille", "litchi", "mague"};
        for (String fruit : fruits2) {          // Si on a pas besoin d'index (un compteur) si on veut juste loop (boucler) sur des element dans array (tableau)
            System.out.printf("les fruits tropico sont : %s %n", fruit);
        }
    }
}

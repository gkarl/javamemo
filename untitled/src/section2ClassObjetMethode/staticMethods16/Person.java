package section2ClassObjetMethode.staticMethods16;

/**
 * Section 2 - 16. Static Methode
 *
 * Si on crée une methode static on peut utiliser cette methode sans avoir à construire une instance de cette class
 * utilise pour un point d'entré programme main() ou des methode qui sont des utilitaire et qui ne font pas partit du concepte représenté par la class
 */
class Person {

    public static void substract(int num1, int num2) {
        System.out.println(num1 - num2);
    }

    public static void main(String[] args) {
        substract(4, 2); // en utilisant static à la créeation de la methode on a pas besoin de crée une instance de la class qui la contiend pour la lancer
    }
}

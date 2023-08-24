package section2ClassObjetMethode.VariableDataType12;

import section2ClassObjetMethode.ClassBasic11.business11.Compagny;

/**
 * Section 2 - 12 Variables & Data Type
 */
class Person {

    private String firstName = "Karl";  // Variable de type String
    private int age = 20;
    private long id; // contiend un nbre plus grand que int pour etre sur qu'on va pas dépasser la capacité
    private char middleInitial = 'K';
    private byte myByte;  // le type est en orange ce sont des types primitif
    private Compagny compagny; // le type est en blanc car c'est une class (Référence, le plan) qd une instance ça crée, donne naissance à un Object => c'est variable contienne une référence à un Object

    static private Compagny compagnyB = new Compagny(); // Ici je crée une instance de ma Compagny = Prend le plan et fabrique moi => Java retourne l'address de cet objet crée => et c'est la référence à l'address de l'objet crée qui est stocké dans cette variable

    private final double PI = 3.14; // On met en majuscule les constante par convention
    private final String MY_BIG_CONSTANTE = "Hi, this is my constante message";

    // psvm = Racourci pour créer une methode main()
    public static void main(String[] args) {
        // sout = Racourci pour println()
        System.out.println(compagnyB);  // ça print l'adresse de l'objet instance de Compagny
    }
}

package section2ClassObjetMethode;

import section2ClassObjetMethode.classBasic11.business11.Compagny;

import java.time.LocalDate;



/**
 * Section 2 - 10. Object Orientation
 */
public class Main {

    static private Compagny compagny = new Compagny();

    public static void methodeWhithVariableParameter(String... text) {};

    public static final Double NBEULER = 12.03;



    //** Ctrl N => Racourci Navigation = Tape le nom de la class ou on veut aller
    //** Ctrl Shift F10  => Racourci lance Run
    public static void main(String[] args) {

        //** sout => racourcie pour println()
        System.out.println("Hello world!");



        //10.  Make, générer une instance du concept class Person pour pouvoir l'utiliser
        Person karl = new Person("Karl", "Gavillot", LocalDate.of(1973, 02, 16));
        Person anne = new Person("Anne", "Inconnu", LocalDate.of(1984, 8, 15));

        karl.setSpouse(anne); //10. dit moi qu'elle est l'épouse de karl

        //10. il génére un chien => instancie la class Dog
        Dog bababar = new Dog("Babar", LocalDate.of(2000, 3, 12));

        karl.setPet(bababar); //10. Dit moi qui est l'animal de compagnie de karl
        bababar.bark(); //10. il fait aboyer bababar (comportement de Dog disponible)

        System.out.println(karl); //10. il faut mettre les toString() sur les class impliqué pour affichage si non juste adresse de objet jarl
        System.out.println(compagny);


        System.out.println(args.length);
//        System.out.println(args[3]);

        int[] nums = {2, 4, 6, 8};
        System.out.println(nums.length);
        System.out.println(nums[3]);

        System.out.format("le prenom est %s \n", karl.getFirstName());
        System.out.format("le prenom est %s \n", karl.getLastName());

//       Exercices Section 1 ***************************************
        String[][] tableauTowDimension = new String[2][3];
        tableauTowDimension[0][0] = "One";
        tableauTowDimension[0][1] = "two";
        tableauTowDimension[0][2] = "tree";
        tableauTowDimension[1][0] = "a";
        tableauTowDimension[1][1] = "b";
        tableauTowDimension[1][2] = "c";

        System.out.println(tableauTowDimension[0][2]);

        String[] joursDeLaSemaines = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
        System.out.println(joursDeLaSemaines[4]);
        System.out.println(joursDeLaSemaines.length);

        int[] nbUnADix = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        String[][] ticTacTo = new String[3][3];

        ticTacTo[0][0] = "O";
        ticTacTo[0][1] = "X";
        ticTacTo[0][2] = "X";
        ticTacTo[1][0] = "X";
        ticTacTo[1][1] = "O";
        ticTacTo[1][2] = "O";
        ticTacTo[2][0] = "X";
        ticTacTo[2][1] = "O";
        ticTacTo[2][2] = "O";

        System.out.println(ticTacTo[2][2]);

        Car peugeot205 = new Car("205", LocalDate.of(2005, 02, 10), "Peugeot");
        System.out.println(peugeot205);


    }
}


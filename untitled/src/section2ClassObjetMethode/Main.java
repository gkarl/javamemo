package section2ClassObjetMethode;

import section2ClassObjetMethode.business.Compagny;

import java.time.LocalDate;




public class Main {

    static private Compagny compagny = new Compagny();

    public static void methodeWhithVariableParameter(String... text) {};

    public static final Double NBEULER = 12.03;




    public static void main(String[] args) {

        System.out.println("Hello world!");


        Person karl = new Person("Karl", "Gavillot", LocalDate.of(1973, 02, 16));
        Person anne = new Person("Anne", "Inconnu", LocalDate.of(1984, 8, 15));

        karl.setSpouse(anne);

        Dog bababar = new Dog("Babar", LocalDate.of(2000, 3, 12));

        karl.setPet(bababar);
        bababar.bark();

        System.out.println(karl);
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


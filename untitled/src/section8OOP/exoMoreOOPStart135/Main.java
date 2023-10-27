package section8OOP.exoMoreOOPStart135;

import java.util.EnumSet;
import java.util.Random;


public class Main {

    private Aphabet alphabet;


    public Main(Aphabet alphabet) {
        this.alphabet = alphabet;
    }

    public Main(String alphabet) {
        this.alphabet = Aphabet.valueOf(alphabet);
    }


    public Aphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Aphabet alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return this.alphabet.toString();
    }

    //Question 3
    public static String getMealsForDays(String someDays) {
        Meal[] meal = Meal.values();
        String[] days  = someDays.split(", ");
        /*String t1 = someDays.replace(days[0], meal[0].name());
        String t2 = t1.replace(days[1], meal[1].name());
        String t3 = t2.replace(days[2], meal[2].name());
        String t4 = t3.replace(days[3], meal[3].name());
        String t5 = t4.replace(days[4], meal[4].name());
        String t6 = t5.replace(days[5], meal[5].name());
        String t7 = t6.replace(days[6], meal[6].name());*/
        for (int i = 0; i < meal.length; i ++) {
            someDays = someDays.replace(days[i], meal[i].name());
        }
        return someDays;
    }

    // Question 4
    public int letterIndex(String letter) {
        String x = letter.valueOf(alphabet);
        return switch (x) {
            case "a","b","c", "x" -> alphabet.ordinal()+1;
            default -> -1;
        };
    }

    public String numberToLetter(int nbre) {

        //String x = letter.valueOf(alphabet);
        String letter = switch (nbre) {
            case 1 -> "a";
            case 2-> "b";
            case 3 -> "c";
            case 4 -> "d";
            case 5 -> "e";
            default -> "";
        };
        return letter;
    }

    public static void main(String[] args) {
        /**
         * Exercices
         * 1. Utiliser une Enum pour modéliser les jours de la semaine et les imprimer à l'aide d'une boucle.
         *     1.1. Les imprimer avec la première lettre en majuscule (sans changer les constantes de l'Enum).
         *     1.2. Alterner entre l'impression de la première lettre en majuscule et celle de la lettre qui se trouve approximativement au milieu du mot.
         *         au milieu du mot. Par exemple : Sunday, monDay, Tuesday, wednEsday, etc.
         *     1.3. Imprimer 10 jours de la semaine choisis au hasard
         */

        //_________1.1. Les imprimer avec la première lettre en majuscule (sans changer les constantes de l'Enum).
        //Methode 1
        //System.out.println(java.util.Arrays.asList(DaysOfWeek.values()));  => les print dans un tableau

        //Methode 2
        /*for (DaysOfWeek jours : EnumSet.allOf(DaysOfWeek.class)) {
            System.out.println(jours);
            //_________1.2. Alterner entre l'impression de la première lettre en majuscule et celle de la lettre qui se trouve approximativement au milieu du mot.
            String joursTypeString = jours.name(); // convertit jours de type DaysOfWeek => en joursTypeString de type string pour pouvoir appliquer les methode applicable au texte
            System.out.println(joursTypeString.substring(0,1).toUpperCase() + joursTypeString.substring(1));
        }*/

        //Methode 3
        System.out.println("_________1.1. Les imprimer avec la première lettre en majuscule (sans changer les constantes de l'Enum).");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            System.out.println(day);
        }


        //________ 1.2. Alterner entre l'impression de la première lettre en majuscule et celle de la lettre qui se trouve approximativement au milieu du mot.
        System.out.println("________ 1.2. Alterner entre l'impression de la première lettre en majuscule et celle de la lettre qui se trouve approximativement au milieu du mot.");
        // au milieu du mot. Par exemple : Sunday, monDay, Tuesday, wednEsday, etc.
        //Methode 4
        DaysOfWeek[] daysofweeks = DaysOfWeek.values();
        for (int i = 0; i < daysofweeks.length; i +=2) {
            DaysOfWeek jours = daysofweeks[i];
            String joursTypeString = jours.name();
            System.out.println(joursTypeString.substring(0,1).toUpperCase() + joursTypeString.substring(1));
        }
        for (int i = 1; i < daysofweeks.length; i += 2) {
            DaysOfWeek jours = daysofweeks[i];
            String joursTypeString = jours.name();
            System.out.println(joursTypeString.substring(0, (joursTypeString.length() /2)) + joursTypeString.substring( (((joursTypeString.length()) /2)), (((joursTypeString.length()) /2) +1)).toUpperCase() + joursTypeString.substring((joursTypeString.length() /2) +1));
        }

        //_________1.3. Imprimer 10 jours de la semaine choisis au hasard
        System.out.println("_________1.3. Imprimer 10 jours de la semaine choisis au hasard");
        for (int i = 1; i <= 10; i ++) {
            Random random = new Random();
            DaysOfWeek jours = daysofweeks[random.nextInt(7)];
            String joursTypeString = jours.name();
            System.out.println(joursTypeString);
        }

        /**
         * 2.  Ecrivez un code pour imprimer ce qui suit en utilisant uniquement un Enum et une boucle sans utiliser de conditionnalité
         * (if/else/switch/etc.)
         *     We eat pot roast on Sunday
         *     We eat spaghetti on Monday
         *     We eat tacos on Tuesday
         *     We eat chicken on Wednesday
         *     We eat meatloaf on Thursday
         *     We eat hamburgers on Friday
         *     We eat pizza on Saturday
         *
         *     2.1 Recommencez, mais mettez aussi une majuscule aux noms des plats. Ainsi, “pot roast” (pot-au-feu) devrait devenir “Pot Roast”.
         *         (Aucune solution n'est fournie parce que vous l'avez déjà fait dans l'exercice précédent - mais essayez de le faire sans regarder le travail précédent - pour vous entraîner).
         *         mais essayez de le faire sans regarder le travail précédent - pour vous entraîner)
         */

        //________ 2.1.
        System.out.println("________ 2.1.");
        DaysOfWeek[] daysofweeks2 = DaysOfWeek.values();
        Meal[] meal = Meal.values();
        for (int i = 6; i >= 0; i--) {
            DaysOfWeek jours = daysofweeks2[i];
            String joursTypeString = jours.name();
            String joursText = joursTypeString.substring(0, 1).toUpperCase() + joursTypeString.substring(1);

            Meal repas = meal[jours.ordinal()];
            String repasString = repas.name();
            //System.out.println(repasString);
            System.out.printf("We eat %s on %s %n", repasString, joursText);
        }

        //________ 2.2.
        System.out.println("________ 2.2.");
        for (int i = 6; i >= 0; i--) {
            DaysOfWeek jours = daysofweeks2[i];
            String joursTypeString = jours.name();
            String joursText = joursTypeString.substring(0, 1).toUpperCase() + joursTypeString.substring(1);

            Meal repas = meal[jours.ordinal()];
            String repasString = repas.name();
            //System.out.println(repasString);
            System.out.printf("We eat %s on %s %n", ( (repasString.substring(0,1).toUpperCase()) +  (repasString.substring(1) )), joursText);
        }

        /**
         * 3. Ecrivez une méthode qui prend la String input suivante (en gras) et renvoie la String output suivante à l'aide d'un Enum comme (imprimez la sortie):: :.
         * Chaîne de sortie en utilisant un Enum comme (imprimer la sortie) :
         * getMealsForDays(“friday, thursday, monday, saturday, tuesday”)
         * Output: hamburgers, meatloaf, spaghetti, etc…
         */
        //________3
        System.out.println("________3");
        String somedays = "friday, thursday, monday, saturday, tuesday, Wednesday, Sunday";
        System.out.println(getMealsForDays(somedays));


        /**
         * 4. Ecrivez une méthode qui prend en entrée une lettre minuscule (et seulement une lettre), comme a - b - c - z,
         *    etc., et renvoie la position ordinale de cette lettre dans l'alphabet, c'est-à-dire a = 1, b = 2, c = 3... z =
         *    26. N'utilisez PAS de conditionnelles (if/then/else/switch/etc.). N'utilisez pas de array. Écrivez des tests unitaires
         *    pour tester les entrées suivantes : a, z, w, f, c, h - qui devraient renvoyer : 1, 26, 23, 6, 3, 8
         *    respectivement
         */
        //________4
        System.out.println("________4");
        Main a = new Main(Aphabet.a);
        Main b = new Main(Aphabet.b);
        Main c = new Main(Aphabet.c);
        Main g1 = new Main("g");

        String g = String.format(g1.toString());

        System.out.println(a.letterIndex(""));
        System.out.println(b.letterIndex(""));
        System.out.println(c.letterIndex("x"));

        /**
         * 5. Écrivez une méthode qui fait l'inverse de la méthode n° 4 - qui prend un nombre, 1-26, et renvoie une lettre minuscule.
         *    lettre minuscule. 1 renverrait a, 2 = b, 26 = z, etc.
         */

        //________5
        System.out.println("________5");
        Main d = new Main("d");
        System.out.println(d.numberToLetter(3));


        /**
         * 6. Écrivez une méthode qui prend les entrées suivantes et renvoie les sorties correspondantes :
         *    8->0, 7->1, 6->2, 5->3, 4->4, 3->5, 2->6, 1->7
         */

    }


}

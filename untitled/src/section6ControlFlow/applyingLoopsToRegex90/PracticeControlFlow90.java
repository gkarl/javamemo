package section6ControlFlow.applyingLoopsToRegex90;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 6 Control Flow - 90 Applying Loops to Regex
 *
 */
class PracticeControlFlow90 {

    public static void main(String[] args) {

        String people = """
                Gavillot, Karl, 16/02/1973
                Rubble, Barney, 02/02/1995
                Flinston, William, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        //________________________Methode 1__________________________
        mat.find(); // a chaque fois qu'on appel .find() regex recherche le pattern suivant qui match
        System.out.println(mat.group("lastName")); // ligne 1
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));
        mat.find();
        System.out.println(mat.group("lastName")); // ligne 2
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));
        mat.find();
        System.out.println(mat.group("lastName")); // ligne 3
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));
        mat.find();
        System.out.println(mat.group("lastName")); // ligne 4
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));

        //________________________Methode 2__________________________

        while(mat.find()) { // A chaque boucle mat.find() regex recherche le pattern suivant qui match
            System.out.println("________________________Methode 2__________________________");
            System.out.printf("%s %s %s %n", mat.group("lastName"), mat.group("firstName"), mat.group("dob")); // Avantage pour print on écrit les groupe name une seul fois
        }
    }
}

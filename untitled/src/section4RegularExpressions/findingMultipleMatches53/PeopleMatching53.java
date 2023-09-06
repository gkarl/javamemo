package section4RegularExpressions.findingMultipleMatches53;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 53 Finding Multiple Matches
 *
 * mat.find()  => il va chercher n'importe quel partie du string qui peut matcher notre Regex, puis va rechercher le prochain match,
 *
 * Ex notre Regex cherche à matcher une ligne (chaque ligne à le meme pattern)
 *__________________Regex_____________________________
 *
 * - \\w+ => chaque ligne commence par un mot + = 1 character ou plus
 * - ,  => suivit par une virgule
 * - \\s* => 0 ou plus d'espace
 * - \\w+ =>  idem
 * - ,  => idem
 * - \\s* => idem
 * - \\d{1,2} => suivit par 1 ou 2 chiffre (pour le moi)
 * - / => suivit par un slash
 * - \\d{1,2} => idem (le  jour)
 * - / => idem
 * - \\d{4} => suivit par 4 chiffres (pour année)
 * - \\n => suivit par le character retour à la ligne
 * - ( ) => il entoure chaque parti avec un capture group car veut print()
 * -?<nom capture group> => donne un nom au capture group à appelé dans le print à la place de son index
 */
class PeopleMatching53 {

    public static void main(String[] args) {

        String people = """
                Club, Sandwich, 10/03/1999
                Rubble, Barney, 02/02/1995
                Flinston, William, 3/3/1910
                Rubble, Betty, 4/4/1915 
                """;
        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";

        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        //_________________Methode 1_____________________________
        //_________________Print Ligne 1_____________________________
        mat.find(); // find() => regex recherche le pattern suivant qui match ici de ligne en ligne
        System.out.println(mat.group("lastName"));
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));

        //_________________Print Ligne 2_____________________________
        mat.find();
        System.out.println(mat.group("lastName"));
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));

        //_________________Print Ligne 3_____________________________
        mat.find();
        System.out.println(mat.group("lastName"));
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));

        //_________________Print Ligne 4_____________________________
        mat.find();
        System.out.println(mat.group("lastName"));
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));


        //_________________Methode 2_____________________________
        mat.find(25); // find() => variente de la methode qui peut prendre en arg un index = commence à rechercher un match à partir de cet index dans le text | EX  il demare au 25 index du string évite la 1ere ligne et print la 2em
        System.out.println("Methode 2 de find()");
        System.out.println(mat.group("lastName"));
        System.out.println(mat.group("firstName"));
        System.out.println(mat.group("dob"));


        //_________________Methode 3_____________________________
        System.out.println("Methode 3 de start() & end()");
        System.out.println(mat.start()); //start() =>  Affiche ou l'index de ce match commence
        System.out.println(mat.end()); //end() =>  Affiche ou l'index de ce match fini

        //_________________Methode 4_____________________________
        System.out.println("Methode 4 de start() & end()");
        System.out.println(mat.start("firstName")); // start() => variente de la methode qui peut prendre en arg le nom du Capture Group (au lieu de l'index) = recupérer l'index ou le capture groupe désigné commence
        System.out.println(mat.end("firstName")); // end() => ariente de la methode qui peut prendre en arg le nom du Capture Group (au lieu de l'index) = recupérer l'index ou le capture groupe désigné fini

        //_________________Methode 5_____________________________
        // appendRemplacement()  =>on peut remplacer du text
        //appendTail() => nous pouvons ajouter du text à partir de la fin
    }
}

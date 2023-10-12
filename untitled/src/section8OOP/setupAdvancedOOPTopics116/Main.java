package section8OOP.setupAdvancedOOPTopics116;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 116 Setup for More Advanced OOP Topics
 * A-partir d'une data au format text comprenant sur chaque ligne un employee (nom, prenom, date de naissance, job)
 *
 * 1/ Attribuer un salaire à chaque employé => Regex | While | Switch
 * 2/ Print la somme de tous les salaires versé au format monétaire
 */
class Main {

    public static void main(String[] args) {

        String people = """
            Flinstone, Fred, 1/1/1900, Programmer
            Rubble, Barney, 2/2/1905, Manager
            Flinstone, Wilma, 3/3/1910, Analyst
            Rubble, Betty, 4/4/1915, CEO
            """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);

        int totalSalaries = 0;
        while (mat.find()) { // ça va passer sur chaque ligne du texte people
            //System.out.printf("%s %s %s %s%n", mat.group("firstName"), mat.group("lastName"), mat.group("dob"), mat.group("role")); // print tout le texte via capture group Regex
            totalSalaries += switch (mat.group("role")) { // il switch case sur le capture groupe name "role" de la Regex | additionne les retoure de salaire => salaire total versé aux employés
                case "Programmer" -> 3000; // return une valeur correspondant au salaire pour se role (job)
                case "Manager" -> 3500;
                case "Analyst" -> 2500;
                case "CEO" -> 5000;
                default -> 0; // Si aucun de ces case n'a été trouvé return la valeur 0
            };
        }
        System.out.printf("le salaire total pour tous les employés est de %d $%n", totalSalaries);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("le total des salaires format monétaire %s%n", currencyInstance.format(totalSalaries)); // print totalSalaries au format monétaire | RQ on ne met plus %s mais %d

    }




}

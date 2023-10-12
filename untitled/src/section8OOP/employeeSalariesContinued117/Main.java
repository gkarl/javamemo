package section8OOP.employeeSalariesContinued117;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 117  Employee Salaries Continued
 *
 * Complexifie le fichier texte comprend maintenant un field supplémentaire {locpd=2000, yoe=3, iq=140}
 * Ils veux exploiter les valeurs à l'intérieur pour varier les salaires en fct
 *
 */
class Main {

    public static void main(String[] args) {

        String people = """  
            Flinstone1, Rod, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
            Flinstone2, Rod, 6/2/2000, Programmer, {locpd=3000, yoe=4, iq=340}
            Flinstone3, Rod, 6/2/2000, Programmer, {locpd=4000, yoe=5, iq=120}
            Flinstone4, Rod, 6/2/2000, Programmer, {locpd=5000, yoe=5, iq=120}
            Rubble, Barney, 2/2/1995, Manager, {orgSize=100, dr=8}
            Rubble2, Barney, 2/2/1995, Manager, {orgSize=200, dr=2}
            Rubble3, Barney, 2/2/1995, Manager, {orgSize=500, dr=4}
            Flinston, William, 3/3/1910, Analyst, {projectCount=4}
            Flinston2, William, 3/3/1910, Analyst, {projectCount=10}
            Flinston3, William, 3/3/1910, Analyst, {projectCount=8}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
        Pattern peoplePattern = Pattern.compile(peopleRegex);
        Matcher peopleMat = peoplePattern.matcher(people);

        String progRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)"; //** il crée une regex particuliere car le field varie en fct des metier | ex ici pour programmer
        Pattern coderPat = Pattern.compile(progRegex);

        int totalSalaries = 0;
        while (peopleMat.find()) { // ça va passer sur chaque ligne du texte people car la regex peopleRegex passe sur chaque ligne
            totalSalaries += switch (peopleMat.group("role")) { // il switch case sur le capture groupe name "role" de la Regex | additionne les retoure de salaire => salaire total versé aux employés
                case "Programmer" -> {
                    Matcher coderMat = coderPat.matcher(peopleMat.group("detail")); //** qd on est sur la ligne case ou c'est un Programmer alors on va utiliser un Matcher pour analyser {locpd= , yoe= , iq= } | doit le mettre dans While/swhitch/case car chaque field peut etre différent
                    int salary = 0; //** Il préfére utiliser une variable qui va nous permettre d'éviter de multiplier les yield (return)
                    if (coderMat.find()) {  //** Demander de trouver le name groupe si non ne marche pas
                        int locpd = Integer.parseInt(coderMat.group("locpd")); //** Extraire dans 1 variable les valeurs des éléménts dans les fields | La regex sort un String que l'on convertit en int pour pouvoir faire des calcules mathématique
                        int yoe = Integer.parseInt(coderMat.group("yoe"));
                        int iq = Integer.parseInt(coderMat.group("iq"));
                        System.out.printf("Programmer locpd: %s programmer yoe: %s programmer yoe: %s%n", locpd, yoe, iq);
                        salary = 3000 * locpd + yoe + iq; //** le fait d'avoir extrait la valeur des éléments des field dans des variables nous permet de faire un calcule math pour afuster le salaire en fct
                    } else {
                        salary = 3000 ;
                    }
                    yield salary;
                }
                case "Manager" -> {
                    yield 3500;
                }
                case "Analyst" -> {
                    yield 2500;
                }
                case "CEO" -> {
                    yield 5000;
                }
                default -> {
                    yield 0;
                }
            };
        }
        System.out.printf("le salaire total pour tous les employés est de %d $%n", totalSalaries);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("le total des salaires format monétaire %s%n", currencyInstance.format(totalSalaries)); // print totalSalaries au format monétaire | RQ on ne met plus %s mais %d


    }
}

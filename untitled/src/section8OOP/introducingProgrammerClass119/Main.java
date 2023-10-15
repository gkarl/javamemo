package section8OOP.introducingProgrammerClass119;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 119 Introducing a Programmer Class
 *
 * Suite => transformer code procedural en OOP
 *
 * l'algorithme pour calculer le salaire avec les détails {locpd= , yoe= , iq= } sont différent selon le rôle (job) dans data texte
 * => On décide de créer différentes classes par rôle, car nous avons un comportement différent
 */
class Main {

    public static void main(String[] args) {

        String peopleText = """  
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
        Matcher peopleMat = peoplePattern.matcher(peopleText);

        String progRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)"; //** il crée une regex particuliere car le field varie en fct des metier | ex ici pour programmer
        Pattern progPat = Pattern.compile(progRegex);

        String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
        Pattern managerPat = Pattern.compile(managerRegex);

        String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
        Pattern analystPat = Pattern.compile(analystRegex);

        String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
        Pattern ceoPat = Pattern.compile(ceoRegex);

        int totalSalaries = 0;
        while (peopleMat.find()) { // ça va passer sur chaque ligne du texte people car la regex peopleRegex passe sur chaque ligne
            totalSalaries += switch (peopleMat.group("role")) { // il switch case sur le capture groupe name "role" de la Regex | additionne les retoure de salaire => salaire total versé aux employés
                case "Programmer" -> {
                    Programmer programmer = new Programmer(peopleMat.group()); // crée une instance de la class Programmer avec arg demandé par constructeur
                    /*Matcher coderMat = progPat.matcher(peopleMat.group("detail")); // qd on est sur la ligne case ou c'est un Programmer alors on va utiliser un Matcher pour analyser {locpd= , yoe= , iq= } | doit le mettre dans While/swhitch/case car chaque field peut etre différent
                    int salary = 0; // Il préfére utiliser une variable qui va nous permettre d'éviter de multiplier les yield (return)
                    if (coderMat.find()) {  // Demander de trouver le name groupe si non ne marche pas
                        int locpd = Integer.parseInt(coderMat.group("locpd")); //** Extraire dans 1 variable les valeurs des éléménts dans les fields | La regex sort un String que l'on convertit en int pour pouvoir faire des calcules mathématique
                        int yoe = Integer.parseInt(coderMat.group("yoe"));
                        int iq = Integer.parseInt(coderMat.group("iq"));
                        //System.out.printf("Programmer locpd: %s programmer yoe: %s programmer yoe: %s%n", locpd, yoe, iq); // print les valeurs des attributs dans le field
                        salary = 3000 * locpd + yoe + iq; // le fait d'avoir extrait la valeur des éléments des field dans des variables nous permet de faire un calcule math pour afuster le salaire en fct
                    } else {
                        salary = 3000 ;
                    }
                    String firstName = peopleMat.group("firstName");
                    String lastName = peopleMat.group("lastName");
                    System.out.printf("Programmer firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary)); // print nom prénom salaire format monétaire sur la meme ligne
                    yield salary;*/
                    System.out.println(programmer.toString()); // Pour print ce qu'on récupère depuis la class Programmer qu'on a défini dans la methode toString Override
                    yield programmer.getSalary();
                }
                case "Manager" -> {
                    Matcher managerMat = managerPat.matcher(peopleMat.group("detail"));
                    int salary = 0;
                    if (managerMat.find()) {
                        int orgSize = Integer.parseInt(managerMat.group("orgSize"));
                        int dr = Integer.parseInt(managerMat.group("dr"));
                        //System.out.printf("Manager orgSize: %s manager dr: %s%n", orgSize, dr);
                        salary = 3500 * orgSize * dr;
                    } else {
                        salary = 3500;
                    }
                    String firstName = peopleMat.group("firstName");
                    String lastName = peopleMat.group("lastName");
                    System.out.printf("Manager firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;
                }
                case "Analyst" -> {
                    Matcher analystMat = analystPat.matcher(peopleMat.group("detail"));
                    int salary = 0;
                    if (analystMat.find()) {
                        int projectCount = Integer.parseInt(analystMat.group("projectCount"));
                        //System.out.printf("Analyst orgSize: %s%n ", orgSize);
                        salary = 4000 * projectCount;
                    } else {
                        salary = 4000;
                    }
                    String firstName = peopleMat.group("firstName");
                    String lastName = peopleMat.group("lastName");
                    System.out.printf("Analyst firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;
                }
                case "CEO" -> {
                    Matcher ceoMat = ceoPat.matcher(peopleMat.group("detail"));
                    int salary = 0;
                    if (ceoMat.find()) {
                        int avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
                        //System.out.printf("CEO avgStockPrice: %s%n ", avgStockPrice);
                        salary = 5000 * avgStockPrice;
                    } else {
                        salary = 5000;
                    }
                    String firstName = peopleMat.group("firstName");
                    String lastName = peopleMat.group("lastName");
                    System.out.printf("CEO firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;
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

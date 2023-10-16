package section8OOP.introducingInterfaces121;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programmer implements Employee{  //** implements Employee => Toutes les class qui implémente cette interface doive implémenter les méthodes présentent dans l'interface en respectant la signature des méthodes | Une class peut implementer plusieurs interfaces

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private  int linesOfCode = 0;
    private int yearsOfExp = 0;
    private int iq = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    private final String progRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)"; //** il crée une regex particuliere car le field varie en fct des metier | ex ici pour programmer
    private final Pattern progPat = Pattern.compile(progRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année

    public Programmer(String personText) { // on va passer au constructeur la une ligne du texte data bases origin
        Matcher peopleMat = peoplePattern.matcher(personText); // crée le Matcher capable d'analyse cet String d'1 personne (arg du constructeur)
        if (peopleMat.find()) { // lance la recherche de match | Dans le constructeur va passer 1 seule personne donc pas besoin de While un if suffis
            this.lastName = peopleMat.group("lastName"); // stock la valeur récupérer du match pour valoriser un field de la class Programmer
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob"))); // pour parse String en LocaleDate

            Matcher progMat = progPat.matcher(peopleMat.group("detail")); //crée le Matcher capable d'analyse la fin du String d'1 personne name groupe detail spécifique pour chaque role ici programmeur  {locpd=2000, yoe=3, iq=140}
            if (progMat.find()) { // on dit au Matcher de trouver (find()) ces détails. if() tant qu'il trouve ces details
                this.linesOfCode = Integer.parseInt(progMat.group("locpd"));  // il peut les extraire on le convertit en int et le stock dans field (propriété de la class)
                this.yearsOfExp = Integer.parseInt(progMat.group("yoe")); // idem ...
                this.iq = Integer.parseInt(progMat.group("iq"));
            }
        }
    }

    public int getSalary() {
        return 3000 * linesOfCode + yearsOfExp + iq; // on fait des math avec pour obtenir le salaire selon nos règles arbitraires différentes sur chaque role
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }
}

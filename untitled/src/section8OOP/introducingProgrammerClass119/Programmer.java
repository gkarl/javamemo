package section8OOP.introducingProgrammerClass119;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Réfléchis, comment pouvoir réutiliser une grande partie du code qui est dans la class Main en procedural
 */
class Programmer {

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
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année

    public Programmer(String personText) { // on va passer au constructeur la 1er grande regex
        Matcher peopleMat = peoplePattern.matcher(personText); // Prépare cherche regex match data text
        if (peopleMat.find()) { // lance la recherche de match | Dans le constructeur va passer 1 seule personne donc pas besoin de While un if suffis
            this.lastName = peopleMat.group("lastName"); // stock la valeur récupérer du match dans une variable
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob"))); // pour parse String en LocaleDate

            Matcher progMat = progPat.matcher(peopleMat.group("detail")); // on cherche à extraire la dernière partie dans group name detail
            if (progMat.find()) { // si matcher trouve match groupe name detail alors on peut extraire les éléments qui sont dedans
                this.linesOfCode = Integer.parseInt(progMat.group("locpd"));  // récupére dans des variables les valeurs des éléments dans detail
                this.yearsOfExp = Integer.parseInt(progMat.group("yoe"));
                this.iq = Integer.parseInt(progMat.group("iq"));
            }
        }
    }

    public int getSalary() { // la ligne de calcul des salaires dans le main() devient une methode | seule partie qui effectue un calcul
        return 3000 * linesOfCode + yearsOfExp + iq; // meme si linesOfCode, yearsOfExp, iq égale 0 getSalary() return 3000 => pas besoin de else
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs | le return de la methode getSalary est mis au format monétaire
    }
}

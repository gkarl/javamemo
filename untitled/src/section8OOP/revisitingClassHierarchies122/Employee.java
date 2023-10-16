package section8OOP.revisitingClassHierarchies122;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Transforme interface en super class qui va etre hérité par Programmer, Manager, Analyst, CEO
 *  Tout ce code est commun aux class et est déplacé vers cet super class mére dont elles héritent pour éviter d'avoir du code redondant
 */
public class Employee {
    protected String lastName; // field doivent etre protected ou public pour etre accéssible par class enfant (sub-class)
    protected String firstName;
    protected LocalDate dob;

    protected final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
    protected final Pattern peoplePattern = Pattern.compile(peopleRegex);

    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    protected final Matcher peopleMat; //** On a besoin de ce field aussi dans class enfant (sub-class) il transforme peopleMat de variable local dans le constructeur en field mais continue de l'instancié dans le constructeur
    public Employee(String personText) {
        // crée le Matcher capable d'analyse cet String d'1 personne (arg du constructeur)
        peopleMat = peoplePattern.matcher(personText); //** continue à etre instancié dans le constructeur mais en a fait un field de la super class pour le rendre accéssible aux class filles
        if (peopleMat.find()) { // lance la recherche de match | Dans le constructeur va passer 1 seule personne donc pas besoin de While un if suffis
            this.lastName = peopleMat.group("lastName"); // stock la valeur récupérer du match pour valoriser un field de la class Programmer
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob"))); // pour parse String en LocaleDate
        }
    }

    public int getSalary() { // Comme c'est une class on doit implémenter les methodes
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }

}

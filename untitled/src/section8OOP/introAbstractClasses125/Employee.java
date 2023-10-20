package section8OOP.introAbstractClasses125;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - Interface => si on a qq class qui implément 1 methode ou plus qui prend des input ou output du mem type mais interieurement elles font qqc de différent ex GetSalary()
 *   et si ces class n'on rien d'autre en commun comme des (methode) implémenté, ou des datas (attributs) en commun, ex Hé, nous savons tous comment fournir un salaire.
 *   une interface peut etre la chose à faire pour relier ses class ensemble afin que vous puissiez traiter  tous de la même chose du point de vue du code client =  Main qui utilise ce que les autres class peuvent fournir (ex elles peuvent fournir toString() et getSalary() )
 *   il suffit de faire référence à eux (instanciéer les class qui implemente interface) tous via cette interface type
 *
 * - super Class (class mére)  => si on a 2 class ou plus qui partage les meme datas (propriétés) et ou partage les meme implémentations (methodes ou code)
 *   notre ex des propriétés et une partie du constructeur (instanciation des fields) sont en commun
 *
 * -  Abstract Class => tres similaire à 1 super class excepté 2 choses :
 *    -  1/ <font size=4, color='green'><b>on ne veut permettre a personnes d'instancier une abstract class </b></font> peut etre par elle meme ça n'a pas bcp de sens
 *    -  2/ ou on veux etre sur de forcer les sub class d'implementer certaines methode présent dans cet abstract class (ex getSalary()) en déclarant cette methode abstract (possible que si la class qui la contiend est elle mem abstract)
 *       Donne la possibiliter d'utiliser le Template Methode Pattern
 *
 *
 */
//___________________1________________________________
abstract class Employee { // abstract class => on ne veut permettre a personnes d'instancier une abstract class | flag pour dire qu'il y aura une abstract methode qui devra etre implementé par les class filles

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

    /*public int getSalary() { // Comme c'est une class on doit implémenter les methodes
        return 0;
    }*/
    //___________________2________________________________
    abstract public int getSalary(); // abstract methode => les sous-classes doivent implémenter cette méthode pour que la hiérarchie des class soit valide (comme le ferait une interface) | cette methode est aussi utilisè dans getBonus() et toString() IDE ne fait pas d'erreur il sait qu'il doit attendre son implémentation = Template Methode Pattern

    public double getBonus() {
        return getSalary() * 1.10;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }
}

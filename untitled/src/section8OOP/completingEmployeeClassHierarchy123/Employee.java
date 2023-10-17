package section8OOP.completingEmployeeClassHierarchy123;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 123 Completing the Employee Class Hierarchy
 *
 * interface VS super Class (héritage) :
 *
 * - Interface  =>   Ce que je considérerai comme une approche plus légère. Si chacune de vos classes auxquelles vous appliquez l'interface
 *  - n'a pas de détails d'implémentation en communs**  (methodes implémenté de la meme façon) les uns avec les autres
 *  - et n'ont pas non plus de données et les données dans ce cas seraient les fields en commun
 * Vous pouvez donc simplement adopter une approche d'interface pure
 *
 * - super Class (héritage)==  => D'un autre côté, si vos classes partagent
 *  - des données (fields en commun)
 *  - et/ou des détails d'implémentation, (methodes implémenté de la meme façon)
 * je veux bien envisager, concidérer la possibilité** d’introduire une super classe.
 *  - surtout si vous finissez par avoir une bonne somme de duplication de code,
 * alors vous devriez vraiment envisager de le faire car cette duplication de code est
 * est une mauvaise chose et cela devrait généralement être évité,
 *
 *
 */
class Employee {

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

package section8OOP.factoryMethods126;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 126 Factory Methods
 *
 * Factory Methode = methode static pas besoin d'etre instancier
 *
 * Des methode static ne peuve pas interagir avec des élémént (methode ou field) non static
 */
abstract  class Employee {// abstract class => on ne veut permettre a personnes d'instancier une abstract class | flag pour dire qu'il y aura une abstract methode qui devra etre implementé par les class filles

    protected String lastName; // field doivent etre protected ou public pour etre accéssible par class enfant (sub-class)
    protected String firstName;
    protected LocalDate dob;

    //__________1____________//** met ces 2 fields static | Quand on met des field static il faut les nommer en Mjuscule
    protected static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
    protected static final Pattern PEOPLE_PATTERN = Pattern.compile(PEOPLE_REGEX);

    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    protected final Matcher peopleMat; //** On a besoin de ce field aussi dans class enfant (sub-class) il transforme peopleMat de variable local dans le constructeur en field mais continue de l'instancié dans le constructeur
    public Employee(String personText) {
        // crée le Matcher capable d'analyse cet String d'1 personne (arg du constructeur)
        //___________2_____________//** techniquement, maintenant que nous avons rendu  peopleRegex et peoplePat static, nous devrions y faire référence via le nom de classe complet Employee | peoplePattern =>  Employee.peoplePattern
        peopleMat = Employee.PEOPLE_PATTERN.matcher(personText); //** continue à etre instancié dans le constructeur mais en a fait un field de la super class pour le rendre accéssible aux class filles
        if (peopleMat.find()) { // lance la recherche de match | Dans le constructeur va passer 1 seule personne donc pas besoin de While un if suffis
            this.lastName = peopleMat.group("lastName"); // stock la valeur récupérer du match pour valoriser un field de la class Programmer
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob"))); // pour parse String en LocaleDate
        }
    }

    /*public int getSalary() { // Comme c'est une class on doit implémenter les methodes
        return 0;
    }*/
    abstract public int getSalary(); // abstract methode => les sous-classes doivent implémenter cette méthode pour que la hiérarchie des class soit valide (comme le ferait une interface) | cette methode est aussi utilisè dans getBonus() et toString() IDE ne fait pas d'erreur il sait qu'il doit attendre son implémentation = Template Methode Pattern

    public double getBonus() {
        return getSalary() * 1.10;
    }

    //___________3_______________ //** Crée cette methode static (pas besoin d'instance pour etre lancé) Ctrl V le switch qui était présent dans la class Main => meilleur emplacement pour lui car concerne le sub-class
    public static final Employee createEmployee(String employeeText) {
        //_____________4_____________ //** on crée une variable local de peopleMat duplique car on a besoin d'utilisé le field peopleMat dans cette methode pour le switch | une methode static ne peut utiliser que des fields static et comme il est utilisé aussi dans le constructeur
        Matcher peopleMat = Employee.PEOPLE_PATTERN.matcher(employeeText);
        //___________5_____________ //** Avec peopleMat Matcher beoin de chercher qqc => find() |  ajoute le mot clé return retoure de la fct = retoure du swirch
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) { // Il a changé le type de return du switch ce n'est plus le salaire (totalSalaries+=) int qui est retourné mais type Employee (interface) stocké dans une variable de ce type => vire les { } | pour chaque ligne on utilise un switch pour instancier quel class on a besoin en fct du role (poste)
                //____________6______________ //** remplace peopleMat.group() => employeeText car il représente la meme valeur une ligne du data texte
                case "Programmer" -> new Programmer(employeeText);  // Avant de le simplifier comme ça il instancie les class avec le type Employee (interface) EX => Employee programmer = new Programmer(peopleMat.group()); | puis simplifie encore en virant { } et avant =  grace à la variable de stockage du switch type Employee (interface)
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> null;  // Il doit donc renvoyer quelque chose qui peut représenter un objet si on met 0 erreur | ce code actuel peut lever une exception erreur car si le switch return null on est entré dans aucun case on ne peut appeler une fct dessus (ex getSalary()) => on vera comment résoudre ça dans une autre leçon = empty class
                //default -> new Employee(peopleMat.group()); // Methode 1 Méthode default ne return plus un objet null mais une instance Employee car si return null on ne peut plus appeler les methodes qui sont juste aprés => erreur

            };
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }
}


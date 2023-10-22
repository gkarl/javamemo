package section8OOP.lambdaVersusAnonymousClasses130;



import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 130 Lambdas Versus Anonymous Classes
 *
 * Il existe plusieurs type de Nested Class
 - 3/ Anonymous Class => une class imbriqué qui n'a pas de nom, on remplace le nom cette clas anonyme par le nom de la class englobante
 *      EX :
 *      default -> new Employee() {  // Donc, ce que nous venons de faire, c'est de déclarer une nouvelle classe qui n'a pas de nom. Et nous avons simultanément créé une instance de cette nouvelle classe ici même
 *          @Override
 *          public int getSalary() {  // Cette class anonyme hérite de la super-class Employee qui a la methode abstract getSalary() l'obligeant à l'implémenté à l'inetrieur de cette class
 *              return 0
 *          }
 *      };
 *
 * type de Nested Class sont tres peu utilisé et ne servent pas notre programme c'est pour cela qu'on ne l'avait pas implémenté
 * On peut faire tout cecode avec une Lambda qui bcp plus court
 *
 * _____________________________________________________________________________
 *
 * Ce qui ce passe qd utilise la Lambda :
 *
 * - Qd on a la Lamda Java analyse le return de createEmployee() => change Employee en IEmployee
 * - check si l'interface a une methode avec la meme signature que la lambda si une ok si plusieurs avec la meme signature pb Donc, pour que ce soit simple, Java s'attend à ce que nous fassions référence à une interface qui ne définit qu'une seule méthode dessus.
 * - Java ce dit  Ah, OK, alors voici ce que je vais faire, puis je vais créer un objet qui implement l'interface IEmployee et qui a la methode getSalary() et cet methode getSalary() dans cet objet derriére le rideau elle va return 0 ce que return la Lambda
 *
 *
 */
//___________4____________La Class Employee doit implémenté l'interface IEmployee pour que la methode createEmployee puisse l'utiliser comme type de return
abstract  class Employee implements IEmployee{// abstract class => on ne veut permettre a personnes d'instancier une abstract class | flag pour dire qu'il y aura une abstract methode qui devra etre implementé par les class filles

    protected String lastName; // field doivent etre protected ou public pour etre accéssible par class enfant (sub-class)
    protected String firstName;
    protected LocalDate dob;

    // Met ces 2 fields static | Quand on met des field static il faut les nommer en Majuscule
    protected static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; //** rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
    protected static final Pattern PEOPLE_PATTERN = Pattern.compile(PEOPLE_REGEX);

    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // utilisé avec la ligne parse String en LocaleDate formate date moi/jour/année
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    protected final Matcher peopleMat; //** On a besoin de ce field aussi dans class enfant (sub-class) il transforme peopleMat de variable local dans le constructeur en field mais continue de l'instancié dans le constructeur

    // IDE nous demande de crée un constructeur vide, DummyEmployee va hériter de ce constructeur vide
    protected Employee() {  //** On met ce constructeur protected car il est utilisé qu'a l'interieur de cette class pour DummyEmployee
        peopleMat = null;  //** On avait une erreur avec peopleMat juste haut dessus comme il est final (constante) IDE a peur que cette variable ne se retrouve sans valeur (indéfini) avec ce constructeur vide
        lastName = "N/A"; //** Rajoute qq field à instancier pour que si DummyEmployee est instancié en passant par default case du switch cela affiche qqc en run
        firstName= "N/A";
        dob = null;
    }

    // Met ce constructor protected => ça forcera les dev a utiliser seulement createEmployee() pour crée de instance Employee plutot que ce constructor
    protected Employee(String personText) {
        // crée le Matcher capable d'analyse cet String d'1 personne (arg du constructeur)
        // techniquement, maintenant que nous avons rendu  peopleRegex et peoplePat static, nous devrions y faire référence via le nom de classe complet Employee | peoplePattern =>  Employee.peoplePattern
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

    // Crée cette methode static (pas besoin d'instance pour etre lancé) Ctrl V le switch qui était présent dans la class Main => meilleur emplacement pour lui car concerne le sub-class
    //___________2____________ Fait que la Methode createEmployee() return l'interface IEmploye qui a une methode qui a la meme signature que la Lambda (à la place dy type Employee)
    public static final IEmployee createEmployee(String employeeText) {
        // on crée une variable local de peopleMat duplique car on a besoin d'utilisé le field peopleMat dans cette methode pour le switch | une methode static ne peut utiliser que des fields static et comme il est utilisé aussi dans le constructeur
        Matcher peopleMat = Employee.PEOPLE_PATTERN.matcher(employeeText);
        // Avec peopleMat Matcher beoin de chercher qqc => find() |  ajoute le mot clé return retoure de la fct = retoure du switch
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) { // Il a changé le type de return du switch ce n'est plus le salaire (totalSalaries+=) int qui est retourné mais type Employee (interface) stocké dans une variable de ce type => vire les { } | pour chaque ligne on utilise un switch pour instancier quel class on a besoin en fct du role (poste)
                // remplace peopleMat.group() => employeeText car il représente la meme valeur une ligne du data texte
                case "Programmer" -> new Programmer(employeeText);  // Avant de le simplifier comme ça il instancie les class avec le type Employee (interface) EX => Employee programmer = new Programmer(peopleMat.group()); | puis simplifie encore en virant { } et avant =  grace à la variable de stockage du switch type Employee (interface)
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                // Remplace les null par instanciation de DummyEmployee pour éviter que le programme plante si la methode createEmployee return null | On ne peut pas appler de methode depuis un null
                //default -> null;  // Il doit donc renvoyer quelque chose qui peut représenter un objet si on met 0 erreur | ce code actuel peut lever une exception erreur car si le switch return null on est entré dans aucun case on ne peut appeler une fct dessus (ex getSalary()) => on vera comment résoudre ça dans une autre leçon = empty class
                //default -> new Employee(peopleMat.group()); // Methode 1 Méthode default ne return plus un objet null mais une instance Employee car si return null on ne peut plus appeler les methodes qui sont juste aprés => erreur
                //default -> new Employee.DummyEmployee();
                //___________1____________
                default -> () -> 0;
            };
        } else {
            //return null;
            //___________6____________On a pas d'erreur avec return DummyEmploye alors que createEmployee return IEmployee car DummyEmployee hérite de Employee qui implement IEmployee | on aurais aussi pu faire que DummyEmployee implemente IEmployee | ou remplacer ce return directement par la Lambda
            return new Employee.DummyEmployee();
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs dans le main() | le return de la methode getSalary est mis au format monétaire
    }

    // Crée une fausse class pour avoir un objet pour remplacer les null case dans le switch createEmployee() car si cette methode return null le programme peut plater on ne peut lancer des methode depuis un null

    private static final class DummyEmployee extends Employee { //** private => car il n'y a pas de code externe qui on besoin de l'instancier | static => car c'est la façon dont est utilisé les nested class par le compiler Java | final => pour prévenir d'autre class d'etre extended (hérite) de cette class
        @Override
        public int getSalary() { //** on est obligé d'implémenté cette abstract methode issu de la class mére Employee
            return 0;
        }
    }
}


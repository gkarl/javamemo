package section9Collection.looseEndsOfLists145;



import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 9 Collection - 145 Loose Ends of Lists
 *
 * Autre maniéres abréger d'ajouter des éléments à une List ou supprimer des éléments de la List

 *
 */
class Main {
    public static void main(String[] args) {

        // data de base list d'employees
        // On fait volontairement une erreur sur le role d'un employee ligne 2 Programmerzzzzzzz => qd lance le program plante car on entre dans case default return nul => employee = null => Erreur car le code apres qui appel les methode toString() et getSalary() à partir d'un objet null (pointe vers rien) = Null pointer exception
        String peopleText = """  
            Flinstone1, Rod, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
            Flinstone2, Rod, 6/2/2000, Programmerzzzzzzz, {locpd=3000, yoe=4, iq=340}
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

        //  regex qui sais comment parse la data texte d'employee ligne par ligne
        //ETAPE 2 Il trouve que ces 2 ligne de code peopleRegex et peoplePattern sont du code redondant car déja présent | et pour que ça passe remplace peoplePattern => Employee.peoplePattern 3em ligne
        // String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n"; // rajoute ça \s*\{(?<detail>.*)\} pour prendre en compte le field à la fin de chaque ligne
        // Pattern peoplePattern = Pattern.compile(peopleRegex);
        Matcher peopleMat = Employee.PEOPLE_PATTERN.matcher(peopleText);

        //Si je veux que mon instance de CEO soit de type Pilot (soit un pilote) | on a une erreur si on ne met pas les triples guillemet avec le meme pattern de text qui match la regex utilisé dans le constructeur de CEO
        Flyer flyer2 = new CEO("""
                Mich, Michou, 4/4/1915, CEO, {avgStockPrice=3000}
                """);
        flyer2.fly(); // Le CEO vole


        Programmer coder = new Programmer("""
                Charles, Boudouar, 4/4/1915, CEO, {avgStockPrice=3000}
                """);
        coder.cook("Hamburger"); // Une instance de la class Programmer peut utiliser les méthodes déja implémenté dans une interface | Ce programmeur cuisine un Hamburger <=> multi héritage

        String progRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)"; // il crée une regex particuliere car le field varie en fct des metier | ex ici pour programmer
        Pattern progPat = Pattern.compile(progRegex);

        String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
        Pattern managerPat = Pattern.compile(managerRegex);

        String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
        Pattern analystPat = Pattern.compile(analystRegex);

        String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
        Pattern ceoPat = Pattern.compile(ceoRegex);

        int totalSalaries = 0;
        //Employee employee = null;  // il change le retoure du switch dans cette variable de type Employee (interface)
        //la methode createEmployee() return maintenant le type IEmployee interface pour match avec la Lambda cette variable doit etre de type également de type IEmployee pour stocker le lancement de createEmployee()
        IEmployee employee = null;

        //On crée la List à l'exterieur de la boucle while car si non la List continuera à être réinitialisée et nous n'accumulerons jamais tous les objets
        //sans modifier le code on peut remplacer new ArrayList<>() par new LinkedList<>() car la variable qui le stock est de type List (interface)
        List<IEmployee> employees = new LinkedList<>(); //                         on instancie la class ArrayList qui contiend l'interface List |  Préférer stocker les instances dans un type plus générique possible (interface List) le type est dans <> | On va y stocker des employee de type IEmployee (interface) => évite qu'on entre d'autres types d'objet => erreur
        while (peopleMat.find()) { // ça va passer (boucle) sur chaque ligne du texte people
            // remplace le switch par un appel à la methode createEmployee() qui le contiend
            employee = Employee.createEmployee(peopleMat.group()); // les employee crée son stocké dans cette variable employee de type IEmployee (interface)
            // On veut récupérer les employee qui sont crée 1 à 1 pour les insérer dans notre List
            employees.add(employee);

            //Ce code n'est pas présent pour print les détail en fct de chaque role
            /*if (employee instanceof Programmer prog) {
                System.out.printf("Nombre de ligne de code = %d, Nbre d'années d'expérience = %d, QI = %d %n",prog.getLinesOfCode(), prog.getYearsOfExp(), prog.getIq());
            } else if (employee instanceof  Manager manag) {
                System.out.printf("");
            } else if (employee instanceof  Analyst ana) {
                System.out.printf("");
            } else if (employee instanceof CEO ceo) {
                System.out.printf("");
            } else {
                System.out.println("Default output");
            }*/

            // ETAPE 1 Il commente le switch qu'il a copié dans la methode createEmployee() qu'il a mis sur la class Employee place plus adapté
            /*switch (peopleMat.group("role")) { // Il a changé le type de return du switch ce n'est plus le salaire (totalSalaries+=) int qui est retourné mais type Employee (interface) stocké dans une variable de ce type => vire les { } | pour chaque ligne on utilise un switch pour instancier quel class on a besoin en fct du role (poste)
             *//*case "Programmer" -> { //
                    Programmer programmer = new Programmer(peopleMat.group()); //  si le poste est un programmer instancie un nell programmer et le constructeur lui passe une ligne du data text représentant un analyst (peopleMat.group()) => Thread entre dans la class programmer pour ça
                    System.out.println(programmer.toString()); // Pour print ce qu'on récupère depuis la class Programmer qu'on a défini dans la methode toString Override
                    yield programmer.getSalary(); // return le calcul du salaire pour programmer
                }*//*
                case "Programmer" -> new Programmer(peopleMat.group());  // Avant de le simplifier comme ça il instancie les class avec le type Employee (interface) EX => Employee programmer = new Programmer(peopleMat.group()); | puis simplifie encore en virant { } et avant =  grace à la variable de stockage du switch type Employee (interface)
                case "Manager" -> new Manager(peopleMat.group());
                case "Analyst" -> new Analyst(peopleMat.group());
                case "CEO" -> new CEO(peopleMat.group());
                default -> null;  // Il doit donc renvoyer quelque chose qui peut représenter un objet si on met 0 erreur | ce code actuel peut lever une exception erreur car si le switch return null on est entré dans aucun case on ne peut appeler une fct dessus (ex getSalary()) => on vera comment résoudre ça dans une autre leçon = empty class
                //default -> new Employee(peopleMat.group()); // Methode 1 Méthode default ne return plus un objet null mais une instance Employee car si return null on ne peut plus appeler les methodes qui sont juste aprés => erreur
            };*/
            //Au lieu de le répéter dans chaque case maintenant ce code n'est écrit qu'1 foi

            // Commente le if employee est null plus nécéssaire car null a été remplacé par DummyEmployee instanciation
            //if (employee != null) { // Methode2 si la variable (instance) employee n'est pas égale à null on entre dans se block de code et lance des methodes plus d'erreur
            //System.out.println(employee.toString()); // Toute les class hérite de la super class Object ou réside la méthode toString()
            //totalSalaries += employee.getSalary(); // la variable employee qui stock le return du switch est de type Employee (interface) elle peut lancer uniquement la seule methode présente sur cette interface getSalary()
            //}
        }

        //____________Methode 1_______________
        //il crée une list de type String avec les noms des employees qu'on désire supprimer de la List principal employees
        List<String> removalNames = new ArrayList<>();
        removalNames.add("Flinstone4");  // add() => methode qui permet d'ajouter des éléments à notre List
        removalNames.add("Rubble3");
        removalNames.add("Flinston3");

        //Si on avait voulu le faire avec la boucle for classique pour les Collections (ne marchera pas car 2 Thread concurrent) Lesson 143
        /*for (IEmployee worker : employees) {
            if (worker instanceof Employee) {  //  Ici on vérifie qu'on est de type Employee <=> dans le case ou un Programmer, Manager .. et pas le case default alors on entre dans le bloc | Si on lance sans ça plante car IDE repére la Lambda dans la methode createEmployee qui return 0 qui n'a pas de firstName ... et n'est donc pas un Employee en tant que tel et donc pas un IEmployee | autre methode worker.getClass().equals(Employee.class) ici pas tres utile car ça e prend pas en compte les hiérarchies
                Employee tmpWorker = (Employee) worker; // Ctrl Alt V il crée une variable pour simplifier le if
                if (removalNames.contains(tmpWorker.firstName)) { //Si List2 contiend éléments de List1 sur lequel on itére avec la Boucle for | pour accéder à firstName besoin de cast worjer en Employee
                    employees.remove(worker); // remove() => methode qui permet de supprimer un élément de la List ici worker élément de List1 sur lequel on itére |
                }
            }

        }*/

        //Methode de la boucle for avec Iterator => utile si on doit supprimer des éléments de la List pendant qu'on itére sur cette List
        for (Iterator<IEmployee> it = employees.iterator(); it.hasNext(); ) { // 1er parti it est un Iterator permet d'accéder aux éléments de la List | 2em partie jusqu'a qd on itére hasNext() => methode qui prend le prochain élément de la List jusqu'à qu'il n'y en ait plus alors return false| 3em partie on ne met pas d'incrément
            IEmployee worker = it.next();  //next()  => methode de Iterator qui nous donnera le prochain élément de la List | on le stock dans une variable de type IEmployee
            // La suite du code est identique à ce qu'on aurais tenté avec une boucle for adapté aux collection
            if (worker instanceof Employee tmpWorker) {  //  Ici on vérifie qu'on est de type Employee <=> dans le case ou un Programmer, Manager .. et pas le case default alors on entre dans le bloc | Si on lance sans ça plante car IDE repére la Lambda dans la methode createEmployee qui return 0 qui n'a pas de firstName ... et n'est donc pas un Employee en tant que tel et donc pas un IEmployee | autre methode worker.getClass().equals(Employee.class) ici pas tres utile car ça e prend pas en compte les hiérarchies | On peut simplifier grace au Design Pattern  => if (worker instanceof Employee tmpWorker) { => cela nous évite d'écrire la ligne suivante
                //Employee tmpWorker = (Employee) worker; // Ctrl Alt V il crée une variable pour simplifier le if
                if (removalNames.contains(tmpWorker.lastName)) { //Si List2 contiend éléments de List1 sur lequel on itére avec la Boucle for | pour accéder à firstName besoin de cast worjer en Employee
                    // employees.remove(worker); // remove() => methode qui permet de supprimer un élément de la List ici worker élément de List1 sur lequel on itére |
                    it.remove(); // Demande à cet Itérator de supprimer lui-même des éléments pendant qu'il effectue la boucle (itére)
                }
            }
        }

        //____________Methode 2_______________ Autre maniére abréger d'ajouter des éléments à une List
        List<String> undesirables = List.of("Flinstone3", "Rubble2", "Flinston2"); // of() => permet de rentrer des élément dans la List

        //____________Methode 2_______________Autre methode pour select les élément à supprimer et les supprimé
        //1__________ Autre méthode pour supprimer des élément d'une liste
        IEmployee first = employees.get(0); // get()  => récupérer les éléments de la List1 employees grace à l'indexe | puis les stoker dans une variable
        IEmployee seconde = employees.get(1); // ici on a select les 3 1er employer de la data text
        IEmployee third = employees.get(2);
        //2__________ Supprime les élément de la List employees à partir de leur index défini juste haut dessus
        employees.remove(first); // remove()  => methode de List qui permet de supprimer des éléments qu'on aura capturé au préalable dans une variable
        employees.remove(seconde);
        employees.remove(third);

        //____________Methode 2.2_______________Autre methode pour select les élément à supprimer et les supprimé
        employees.remove(1); // Il faut faire attention car en utilisant les autres methode la taille de la List à diminué

        //Pour nous montrer ce qu'on peut faire avec une List il fait un for loop adapté aux List
        for (IEmployee worker : employees) {  // worker est la variable dans laquelle nous allons conserver les employés pendant que nous les parcourons.
            System.out.println(worker.toString()); // Toute les class hérite de la super class Object ou réside la méthode toString()
            totalSalaries += worker.getSalary();  // la variable employee qui stock le return du switch est de type Employee (interface) elle peut lancer uniquement la seule methode présente sur cette interface getSalary()
        }

        System.out.printf("le salaire total pour tous les employés est de %d $%n", totalSalaries);

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("le total des salaires format monétaire %s%n", currencyInstance.format(totalSalaries)); // print totalSalaries au format monétaire | RQ on ne met plus %s mais %d

    }
}

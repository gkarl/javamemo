package section8OOP.defaultsMethods132;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //__________3__________
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
    while (peopleMat.find()) { // ça va passer (boucle) sur chaque ligne du texte people
        // remplace le switch par un appel à la methode createEmployee() qui le contiend
        employee = Employee.createEmployee(peopleMat.group());
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
        System.out.println(employee.toString()); // Toute les class hérite de la super class Object ou réside la méthode toString()
        totalSalaries += employee.getSalary(); // la variable employee qui stock le return du switch est de type Employee (interface) elle peut lancer uniquement la seule methode présente sur cette interface getSalary()
        //}
    }
    System.out.printf("le salaire total pour tous les employés est de %d $%n", totalSalaries);

    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.printf("le total des salaires format monétaire %s%n", currencyInstance.format(totalSalaries)); // print totalSalaries au format monétaire | RQ on ne met plus %s mais %d

}
}

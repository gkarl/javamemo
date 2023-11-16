package section10StreamsAndLambdas.summingWithSreams164;


/**
 * Section 10: Streams & Lambdas - 164 Summing with Streams
 *
 * On veut afficher la somme des salaires + voir les salaires imprimés de chaque employees grace au meme Stream
 */
class StreamsStuff {
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


        int sum = peopleText  // on utilise une variable pour stocker la somme des salaires
                .lines()  // crée un Streams => découpe le multi String en ligne => output
                .map(Employee::createEmployee) // Return un type IEmployee | J'ai du virér \\n à la fin de la Regex pour que ça marche | map() => methode de Stream API prend 1 arg et return 1 output (IEmployee return de createEmployee()) signature interface Function | Appelé Reference Methode | écrit en Lambda  ((s) -> Employee.createEmployee(s)) RQ pas besoin d'intancier Employee pour utiliser createEmployee car static
                //.mapToInt(IEmployee::getSalary) // pipe que les nbres salaires de tous les employees | Comme le pipeline haut dessus return IEmployee on doit l'utiliser ici pour accéder à la methode getSalary() | mapToInt => return un IntStream qui lui dispose de methode plus spécifique pour les nbre comme sum() RQ map() aurait return lui un Stream<Integer> | transmet plus que des nbres les salaires de chaque employee
                .mapToInt(e -> { //  pipe que les nbres salaires de tous les employees + noms et salaires
                    System.out.println(e); // print ce qu'on avait avant la somme (noms et salaires)
                    return e.getSalary(); // il return les salaires qui vont passer au pipe suivant pour faire la somme des salaires
                })
                //.mapToInt(StreamsStuff::showEmpAndGetSalary) // si on avait voulu factoriser (utiliser une methode qui va contenir ce code) la Lambda utilisé pour le pipe du dessus
                .sum(); // sum() fait la somme de tos les salaires  | C'est une Terminal Operation pour un stream pipeline on ne peut pas avoir de fct aprés | sum() => accécible que si le pipe du dessus lui passe un type IntStream comme le fait mapToInt()
                //.forEach(System.out::println); //  | orEach() => methode de fin de pipeline pour Streams car 1 input et 0 output | écrit avec Lambda  ((s) => System.out.println(s))

        System.out.println(sum); // print la somme des salaires
    }

    public static int showEmpAndGetSalary(IEmployee e) { // permet de factoriser la Lambda e -> dans le pipe
        System.out.println(e);
        return e.getSalary();
    }
}

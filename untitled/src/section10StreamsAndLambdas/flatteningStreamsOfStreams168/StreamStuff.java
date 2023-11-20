package section10StreamsAndLambdas.flatteningStreamsOfStreams168;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Section 10: Streams & Lambdas - 168 Flattening Streams of Streams
 *
 * flatMap() => qd on a un Streams de Streams ce n'est probablement pas ce que vous vouliez dans de très nombreux cas. Et vous devez aplatir cette structure en un seul Stream
 *
 * EX Print toutes les lettres des firstName sans doublons
 *
 */
class StreamStuff {
    public static void main(String[] args) {

        // data de base list d'employees
        // On fait volontairement une erreur sur le role d'un employee ligne 2 Programmerzzzzzzz => qd lance le program plante car on entre dans case default return nul => employee = null => Erreur car le code apres qui appel les methode toString() et getSalary() à partir d'un objet null (pointe vers rien) = Null pointer exception
        String peopleText = """
            Flinstone, Rod, 6/2/2000, Programmer, {locpd=1000, yoe=3, iq=140}  
            Flinstone, Rod, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}  
            Flinstone, Rod, 6/2/2000, Programmer, {locpd=3000, yoe=3, iq=140}  
            Flinstone, Rod, 6/2/2000, Programmer, {locpd=4000, yoe=3, iq=140}  
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


        Predicate<String> dummyEmployeeSelector = s1 -> s1.contains("Programmerzzzzzzz");
        Predicate<Employee> employeePredicate = e -> "N/A".equals(e.getLastName());
        Predicate<Employee> overFourtyKSelector = e -> e.getSalary() > 40000;

        //int sum = peopleText  // on utilise une variable pour stocker la somme des salaires
        peopleText
                .lines()  // crée un Streams => découpe le multi String en ligne => output

                //_______________ Methode B.2.1 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz________
                //.filter(Predicate.not(s -> s.contains("Programmerzzzzzzz"))) // On le fait avant que la ligne String soit converti en Object Employee | not() => static methode qui va inverser le return de la Lambda
                //___________________________________________________________________________________________________________

                //_______________ Methode B.2.2 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz________
                //.filter(dummyEmployeeSelector.negate()) // negate() => pour obtenir l'inverse de ce que nous return la Lambda
                //___________________________________________________________________________________________________________

                //_______________ Methode B.2.2 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz________
                //.filter(((Predicate<String>) s1 -> s1.contains("Programmerzzzzzzz")).negate()) // on defactorise B.2.2 avec Ctrl Alt N on remarque que IDE nous a cast notre Lambda en Predicate<String>
                //___________________________________________________________________________________________________________

                .map(Employee::createEmployee) // Return un type IEmployee | J'ai du virér \\n à la fin de la Regex pour que ça marche | map() => methode de Stream API prend 1 arg et return 1 output (IEmployee return de createEmployee()) signature interface Function | Appelé Reference Methode | écrit en Lambda  ((s) -> Employee.createEmployee(s)) RQ pas besoin d'intancier Employee pour utiliser createEmployee car static
                .map(e -> (Employee)e)// map()  => cast IEmployee en Employee pour pouvoir accéder à ses fields

                //________________*** Print toutes les lettres des firstName sans doublons__________________________________
                .map(Employee::getFirstName)  // return un ou 2 String pour le prénom simple ou composé
                .map(fn -> fn.split("")) // output 1 ou 2 array de chracter String dans un Stream
                .flatMap(Arrays::stream)  // PB si utilise map() crée un Stream pour chaque array et les met dans un Stream plus grand qui les contient | flatMap() => Lorsque vous avez un Stream de Sreams et que vous ne le souhaitez pas, vous voulez juste un Stream ultime | output un Streams de String character
                .map(String::toLowerCase)  // pour éviter que le print final nous affiche ex A et a
                .distinct() // distinct()  => on veut les lettres uniques, ça vire les lettres en doublons
                .forEach(System.out::print);
                //___________________________________________________________________________________________________________

                //_______________ Methode A.1 Retire les doublons firstName lastName dob du pipe____________________________
                //.distinct() // distinct() => utilise la methode equals et le field qu'on y a défini pour retirer les doublons
                //___________________________________________________________________________________________________________

                //_______________ Methode A.2 Retire les doublons firstName lastName dob du pipe____________________________
                //.collect(Collectors.toSet()).stream()   // collect() est comme un filet qui recupére un a un les objets Employee pour les mettre dans Set qui élimine les doublons | PB cette methode est Terminal cad que généralement on ne rajoute pas de pipe aprés (voire commentaire plus haut qd on s'arrete la on le met dans une variable de type Set) | stream() => permet de recréer un stream pour pouvoir continuer à pipe si non Erreur
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz________
                //.filter(e -> !e.getLastName().equals("N/A"))   // Ici on a remarqué quand cette ligne est print elle affiche N/A à cause de ce qu'on a défini dans DummyEmployee | Si on ne met pas ! équivalent à not on affichera que cette ligne
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1.2 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz_______
                //.filter(Predicate.not(e -> e.getLastName().equals("N/A")))   // not() à la place de !
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1.3 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz_______
                //.filter((e -> !"N/A".equals(e.getLastName())))   // ! => not equals()
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1.4 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz_______
                //.filter(Predicate.not(e -> "N/A".equals(e.getLastName())))   // mettre "N/A" la constante String au commencement car si non on risquerait un null pointer exception si il ne trouve pas N/A (null)
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1.5 On veux retirer l'Employee ou son role est mal écrit Programmerzzzzzzz_______
                //.filter(employeePredicate.negate())   // il factorise la Lambda puis appel la methode negate() appartenant à l'interface Predicate (type de la variable contenant la Lambda)
                //___________________________________________________________________________________________________________

                //_______________ Methode C On veut filtrer en se débarassant de tous les Programmer________________________________
                //.filter(Predicate.not(e -> e instanceof Programmer))   // Si on ne met pas not() on affichera que les Programmer
                //___________________________________________________________________________________________________________

                //_______________ Methode D.1 On veut voir seulement les Employee qui ont un salaire supérieur à 40 000 $____________
                //.filter(e -> e.getSalary() > 40000)
                //___________________________________________________________________________________________________________

                //_______________ Methode D.2.1 Et on veut voir seulement les Employee qui ont un salaire supérieur à 7,000,000 $____
                //.filter(e -> e.getSalary() < 7000000)
                //___________________________________________________________________________________________________________

                //_______________*** Methode D.1.2 On veut voir seulement les Employee qui ont un salaire supérieur à 40 000 $____________
                //.filter(overFourtyKSelector) // C'est la meme que Methode D.1.1 mais factorise
                //___________________________________________________________________________________________________________

                //_______________ Methode D.2.1 Et on veut voir seulement les Employee qui ont un salaire supérieur à 7,000,000 $____
                //.filter(e -> e.getSalary() < 7000000)
                //___________________________________________________________________________________________________________

                //_______________ Methode B.1.5 + Methode D.1.2 _______
                //.filter(employeePredicate.negate().and(overFourtyKSelector))   // il combine 2 filter() avec and() | or() existe aussi | on on afactorisé les 2 pipe plus facile pour le faire | on peut meme factoriser ce pipe
                //___________________________________________________________________________________________________________



                //_______________Trie par firstName lastName puis dob________________________________________________________
                /*.sorted(Comparator.comparing(Employee::getLastName) // comparing() => build un Comparator pour nous veut en arg Method Reference :: | Racourci equivalent derriére le rideau à expression Lambda pour initialiser un Comparator (x,y) -> x.getLastName().compareTo(y.getLastName()
                        .thenComparing(Employee::getFirstName) // thenComparing() => permet de faire comme nested si lastName égalité passe au niveau suivant compare les firstNames
                        .thenComparing(IEmployee::getSalary)) */// Si on voulait trier par le salaire c'est facile car on avait un output du pipe supérieur de type IEmployee qui pocéde la methode getSalary | si on veut des fields de la class Employee pour faire le trie on doit cast IEmployee en Employee juste au dessus
                //.reversed())// reversed() => Permet d'inverser l'ordre du trie alphabétique
                //__________________________________________________________________________________________________________

                //_____________Print tous les employees et leurs salaire et pipe print la somme des salaire_________________
                //.mapToInt(IEmployee::getSalary) // pipe que les nbres salaires de tous les employees | Comme le pipeline haut dessus return IEmployee on doit l'utiliser ici pour accéder à la methode getSalary() | mapToInt => return un IntStream qui lui dispose de methode plus spécifique pour les nbre comme sum() RQ map() aurait return lui un Stream<Integer> | transmet plus que des nbres les salaires de chaque employee
                /*.mapToInt(e -> { //  pipe que les nbres salaires de tous les employees + noms et salaires
                    System.out.println(e); // print ce qu'on avait avant la somme (noms et salaires)
                    return e.getSalary(); // il return les salaires qui vont passer au pipe suivant pour faire la somme des salaires
                })*/
                //.mapToInt(StreamsStuff::showEmpAndGetSalary) // si on avait voulu factoriser utiliser une methode qui va contenir le code de la Lambda utilisé pour le pipe du dessus (on remplace le pipe du dessus par ce pipe plus concis)
                //.sum(); // sum() fait la somme de tos les salaires  | C'est une Terminal Operation pour un stream pipeline on ne peut pas avoir de fct aprés | sum() => accécible que si le pipe du dessus lui passe un type IntStream comme le fait mapToInt()
        //__________________________________________________________________________________________________________
        //.forEach(System.out::println); //  | orEach() => methode de fin de pipeline pour Streams car 1 input et 0 output | écrit avec Lambda  ((s) => System.out.println(s))

        //System.out.println(sum); // print la somme des salaires
    }

    public static int showEmpAndGetSalary(IEmployee e) { // permet de factoriser la Lambda e -> dans le pipe
        System.out.println(e);
        return e.getSalary();
    }
}

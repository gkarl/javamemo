package section10StreamsAndLambdas.functionalMethodsOfCollections180;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Section 10: Streams & Lambdas - 180 Functional Methods of Collections
 *
 * Leçon 179 => dans un grand nombre de ces Stream API methodes, ils acceptent des input arg qui font référence à diverses interfaces comme les Predicates et les Consumers
 *
 * Pour connaitre la signature des methodes de ces interfaces Ctrl P sur la methode du API Stream + voire la doc (Package java.util.function) =>  https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 * Ctrl Q => ouvre la java doc de la methode => regarde code qui se passe derriére le rideau :
 * Ex function.apply() => le mot function fait référence à une Lambda ou Methode Reference + Java va prendre notre Lambda ou Methode Reference :: et le brancher sur un objet qu'il crée pour nous EX BiFunction et qui match la signature  | Toutes ces interfaces fonctionnelles ont une méthode apply()
 * Ex entry (key value paire)
 * Ex setValue() => modifie la value d'un Map
 * Ex get(key) => il récupère la key
 * Ex remapingFunction.apply(key, oldValue) => appel la Lambda qu'on lui fournit lui passe en arg la key et oldValue
 *
 * __________________________________________________________________________________________________________________________________________
 *
 * Dans cette leçon on voit quelques-unes des méthodes utilisées dans les Collections (classes ou interfaces) liées à la réalisation de Stream
 * ___________________________________________________________________________________________________________________________________________
 *
 * Methodes pour les Map :
 *
 * - forEach() => prend en input un BiConsumer => Functional interface qui attend 2 input (Map = key value paire) et return rien | print
 * - replaceAll() =>  prend en arg un BiFunction cette interface a une fct qui prend 2 input et return un output | modifier les values du Map Ex *2 .. si la key commence par tel lettre
 * - compute() => prend en arg1 une key en arg2 un BiFunction => c'est une fct qui prend 2 inputs et return 1 output | Ex Affiche le nbre de Person par state d'une Map
 *                On peut utiliser compute() pour autre chose que compter ou additionner des choses, si on a des mots vous voudrez peut-être ajouter quelque chose aux mots
 *                appel notre lambda, qu'il y ait ou non une valeur déjà associée a la key
 * - computeIfAbsent() => cette methode prend en arg aussi une key et une Function | remplace la value par une autre valeur ex la lenght de la key
 * - computeIfPresent() => prend en arg une key et aussi en arg2 BiFunctional => c'est une fct qui prend 2 inputs et return 1 output
 *                appel notre lambda que s'il n'y avait pas déjà de valeur associée à la key
 * - merge() => prend en arg1 une key et en arg2 une value de type Long en arg3 un BiFunction => c'est une fct qui prend 2 inputs et return 1 output | Semble donc presque identique à la méthode compute() sauf qu'elle a ce deuxième arg Long | Ex faire la somme des Person par state | Préféré pour faire un décompte car plus concis
 *                Et encore une fois, je ne saurais trop insister sur cette méthode merge(), mais elle ne doit pas nécessairement être utilisée uniquement avec des nombres.
 *                Encore une fois, il s’agit probablement de l’un des cas d’utilisation par excellence.
 *
 * Methodes pour les List et Set :
 *
 * - replaceAll() => Si on veut remplacer un élément d'1 List | Ex si on veut mettre en majuscule les éléments de cette List
 * - removeIf() => Il prend en arg 1 Predicate => fct qui prend 1 input et return un true ou false  qui sont utilisé pour dire si on vire qqc | Ex supprimer un élement String de la List s'il commenc epar la lettre "c"
 */
class BigData {
    record Person(String firstName, String lastName, BigDecimal salary, String state, char gender) {} // On met salary en type BigDecimal à la source, on aurait pit peut etre faire un map() plustard dans le stream | On rajoute le field gender qui va nous servir pour notre 2em niveau de grouping | les Record sont essentiellement des classes avec moins de passe-partout => on a pas a définir les les getter et setter ni equals() ou hashCode() => toutes ces choses sont généré pour nous
    public static void main(String[] args) {
        try {
            HashMap<String, Long> stateCounts = new HashMap<>(); //*** Methode 11-12
            //__________On veut faire la somme de tous les salaire field salary dans le .csv__________________
            long startTime = System.currentTimeMillis(); // capture le temps pris en milliseconde au demarage
            //Map<String, Long> result = Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv")).parallel()  //*** Change le type de la variable pour correspondre a output du stream | Pour importer un file qui est sur l'ordi | parallel() => permet de faire du multi processor en parrallele pour ganer en temps de calcule
            Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv"))  //*** Methode 11-12 | Pour importer un file qui est sur l'ordi
                //.limit(2)  // limit() => on lui dit d'afficher que les 2 premiére lignes du Stream
                .skip(1)
                //.forEach(System.out::println); // print les 2 lignes | Ctrl C les 2 ligne print + ouvre Excel + clic le coin du tableur select toute la grille + Accueil/Coller/Utiliser l'assistant importation de texte/coche le séparateur virgule => affiche un entete de colle avec 1 enregistrement sur la ligne du dessous cela permet de voire convenablement de quoi parle le file
                //.limit(100) // limite le Stream à 100 lignes | la 1er ligne etant juste le titre
                //.forEach(System.out::println); // print les 10 1ere lignes | les rajoute dans le tableur Excel => tape 0 1 2 3 4 dans les 4 1ere colonnes + select 0 Shift 4  + clic drag la selction jusqu'a la derniére colonne => numéronne auto chaque colonne => ça nous donne l'index du field colonne salary
                .map(s -> s.split(","))// map() => Il mappe un type de données à un autre type de données. | split(",") =>  Divisé par des virgules return des array de String String[] 1 par ligne | *** On pourrais pensser à utiliser une Lambda qui output juste le String plus leger que String[]

                //.map(arr -> arr[25]) // map() => ce qui arrive par le Stream est de type array String[] on veut juste récupérer les salaires en type String | Lambda index 25 dans chaque array du Stream supérieur

                //_______________Methode 1 faire la somme des salaires du data file_______________________
                //.map(sal -> Long.parseLong(sal))  // map() => convertit le Stream salary qui est de type String en Long
                //.collect(Collectors.summingLong(sal -> sal)); // summingLong() => prend une valeur et return une valeur | Mais décide de combiner les 2 dernier pipes voire ligne suivante
                //.collect(Collectors.summingLong(sal -> Long.parseLong(sal)));


                //_______________Methode 2_______________________
                //.mapToLong(sal -> Long.parseLong(sal))  // mapToLong() => pour convertir le String en long (primitif) permet de faire des opérations Maths
                //.sum(); // sum() => fait la somme des salaires

                //_______________Methode 3_______________________  // pour cette methode on n'utilise pas le pipe =>  .map(arr -> arr[25])
                //.map(a -> new Person(a[2], a[4], new BigDecimal(a[25]), a[32], a[5].charAt(0))) //* On map cast en BigDecimal la value String salary venant du pipe précédente String[] array |  On doit introduire le field gender à l'instanciation de Person il est à index 5 dans String array d'1 ligne | charAt(0) => on doit le cast en char car à la base ce qui arrive en input c'est un String[ ] | Pour cette methode on converti Strin[] en un Domain Models (type instance de class)
                //.collect(Collectors.summingLong(Person::salary)); // on utilise la methode 1 mais en arg on peut lui mettre un Model Reference :: salary field fait référence derriere le rideau a getSalary()

                //_______________ Methode 1 On veut regrouper les Person par state (état)__________________
                //.collect(Collectors.groupingBy(Person::state)); //groupingBy => prend juste en arg la colonne sur lequel on va regrouper Ex il ira 10 personnes dans cet etat | par default va utilisé un HashMap les state sont dans le désordre | Person::state ce Model Référence à pu etre utilisé car on utilise un Model Domain (class ou record) => .map(a -> new Person(a[2], a[4], Long.parseLong(a[25]), a[32]))

                //_______________ Methode 2 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique__________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.toList())); //groupingBy => dispose de plusieurs version on va utiliser celle avec 3 arg | TreeMap::new => arg2 instancie un TreeMap qui rande ses élément par ordre alphabétique plutot qu'un HashMap par default | toList() => garde output comme il était mais les lignes personnes dans une liste [ ]

                //_______________ Methode 3.1 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique + la somme des salary par regroupement par state__________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new,  Collectors.summingLong(Person::salary))); //_______________Methode 3.1 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique + la somme des salary par regroupement par state__________________

                //_______________ Methode 3.2 idem mais format monétaire le salary__________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), s -> String.format("$%,d.00%n", s) )));  // collectingAndThen() => permet de combiner 2 opération le output de la somme des salary va en input de arg Lambda pour format | En arg3 on peut utiliser n'importe quel methode de la class Collectors

                //_______________ Methode 3.2 idem autre façon de format monétaire le salary__________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), s -> NumberFormat.getCurrencyInstance().format(s))));  // la 1er opération summingLong output un Long qu'on peut utliser en input de NumberFormat via Lambda | En arg3 on peut utiliser n'importe quel methode de la class Collectors

                //_______________ Methode 3.3 idem autre façon de format monétaire le salary__________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), NumberFormat.getCurrencyInstance()::format)))  // idem à methode précédente mais on utilise une Methode REference :: plutot qu'une Lambda FVM comprend que c'est le output de l'autre opération qui arrive en input de la 2em opération | En arg3 on peut utiliser n'importe quel methode de la class Collectors

                //_______________ Methode 3.4 Pour format print 1 key value paire par ligne  __________________
                //.forEach(((state, salary) -> System.out.printf("%s -> %s%n", state, salary))); // forEach() => ici fait référence à une methode de la class Map RQ on a comment la variable qui contiend l'ensemble pour ça | dans la vrai vie de dev printf n'est pas utilisé | comme on print ici on commente la variable qui collecte le output

                //_______________ Methode 3.5 Pour format print 1 key value paire par ligne __________________
                //.entrySet().stream() // entrySet() comme c'est une Collection offre la methode stream()
                //.forEach(((s) -> System.out.printf("%s%n", s))); // | comme on print ici on commente la variable qui collecte le output

                //_______________ Methode 4 Rajouter un 2em niveau de groupage par gender => somme des salaires par sexe dans un state __________________
                //.collect(Collectors.groupingBy(Person::state, TreeMap::new,
                //Collectors.groupingBy(Person::gender, Collectors.collectingAndThen(Collectors.summingLong(BigData.Person::salary), NumberFormat.getCurrencyInstance()::format)))); //*** nested groupingBy() arg1 le field sur lequel grouper arg2 apération + formatage (qui était arg3 du 1er groupingBy()) |** à la place de summingLong on peut faire toutes les methodes de la class Collectors Ex averagingLong() +> fait la moyenne des salaires  | idem à methode précédente mais on utilise une Methode Reference :: plutot qu'une Lambda FVM comprend que c'est le output de l'autre opération qui arrive en input de la 2em opération | En arg3 on peut utiliser n'importe quel methode de la class Collectors

                //_______________ Methode 5 faire la somme des salaires mais en type BigDecimal pour plus de précision si on a des decimal __________________
                /*.collect(Collectors.groupingBy(Person::state, TreeMap::new,
                        Collectors.groupingBy(Person::gender, Collectors.collectingAndThen(
                                Collectors.reducing(BigDecimal.ZERO, Person::salary, (a, b) -> a.add(b)), //*** reducing() => Collectors n'a pas toujours le methode toute préte on utilise cette methode pour fabriquer nos propres récursive opération | on a choisit la version a 3 arg | arg1 identy nbre on le met à 0 pour une addition pour que le 1er stream concerve ça valeur (0+a=a=) | Function build mapping Person en salary grace à Model Reference :: | arg3 BinaryOperator => une Lambda qui prenne 2 valeurs pour nous permettre de faire une opération
                                NumberFormat.getCurrencyInstance()::format))));*/

                //_______________ Methode 6 filtrer éliminer les hommes __________________
                //.filter(person -> person.gender()=='F'); // sorte de boolean opération Soit vous avez une correspondance, soit vous n'avez pas de correspondance le stream vire les Hommes

                //_______________ Methode 7 faire Map key true si c'est une Femme et value Person __________________
                //.collect(Collectors.partitioningBy(p -> p.gender() == 'F'));  // partitioningBy() => prend en arg un Predicate ( c'est une interface qui prend 1 input arg (Lambda ou Model Reference) et return un boolean (true ou false)) et return un Map (key = match ou pas le prédicate true ou false | value = liste des Person

                //_______________ Methode 8 Savoir combien d'Hommes et combiens de Femmes il y a __________________
                //.collect(Collectors.partitioningBy(p -> p.gender() == 'F', Collectors.counting()));// counting() => Nous allons simplement compter le nombre total d'éléments du Stream par partition ou grouping

                //_______________ Methode 9 on fait un regroupement des hommes et des femmes pour savoir combien ils y en a dans chaque état __________________
                //.collect(Collectors.partitioningBy(p -> p.gender() == 'F',  // partitioningBy() => fait un 1er groupe H/F | prend en arg un Predicate ( c'est une interface qui prend 1 input arg (Lambda ou Model Reference) et return un boolean (true ou false)) et return un Map (key = match ou pas le prédicate true ou false | value = liste des Person
                //Collectors.groupingBy(Person::state, Collectors.counting()))); // groupingBy() => est nested ça fait un regroupement secondaire on compte le nbre de Person par state | ici on a mis counting() comme arg2 mais on pourrais mettre une autres fct de la class Collector

                //_______________*** Methode 10.1 replaceAll() pour modifier les values nbr de Person (*2) d'une Map (Collection) __________________
                // décommente Methode 3 ligne 75 + File avec variable result + print result
                //.collect(Collectors.groupingBy(Person::state, Collectors.counting()));// Affiche le nbre de Person par state | groupingBy() => est nested ça fait un regroupement secondaire on compte le nbre de Person par state | ici on a mis counting() comme arg2 mais on pourrais mettre une autres fct de la class Collector
                //result.replaceAll((k,v) -> v*2); // On a multiplié la value Person du Map par 2 => 2 fois plus de person par state |

                //_______________*** Methode 10.2 replaceAll() Si la key (state) commence par cette lettre alors modifie les values nbr de Person (*2) d'une Map (Collection) __________________
                // décommente Methode 3 ligne 75 + File avec variable result + print result
                //.collect(Collectors.groupingBy(Person::state, Collectors.counting()));// Affiche le nbre de Person par state | groupingBy() => est nested ça fait un regroupement secondaire on compte le nbre de Person par state | ici on a mis counting() comme arg2 mais on pourrais mettre une autres fct de la class Collector
                //result.replaceAll((k,v) -> k.startsWith("H") ? v * 2 : v); // On a multiplié la value Person du Map par 2 => 2 fois plus de person par state |

                //_______________*** Methode 11 compute() Affiche le nbre de Person par state d'une Map (Collection) __________________
                ///.collect(Collectors.groupingBy(Person::state, Collectors.counting()));// RQ on sait le faire avec API Stream On va utiliser compute() C'est juste une manière plus procédurale d'obtenir des décomptes de Person par state
                // .map(a -> new Person(a[2], a[4], new BigDecimal(a[25]), a[32], a[5].charAt(0)))  // On vire cette ligne pour cet exemple
                // .forEach(a -> stateCounts.compute(a[32], (k,v) -> v == null ? 1L : v + 1)); // 32 c'est l'index de state dans String[] array | Expression Lambda => si value null => met value a 1 si non value + 1 (incrémente)
                // System.out.println(stateCounts);

                //_______________*** Methode 12 computeIfAbsent() il met en value la length de la key dans une Map (Collection) __________________
                ///.collect(Collectors.groupingBy(Person::state, Collectors.counting()));// RQ on sait le faire avec API Stream On va utiliser compute() C'est juste une manière plus procédurale d'obtenir des décomptes de Person par state
                 //.forEach(a -> stateCounts.computeIfAbsent(a[32], k -> Long.valueOf(k.length()))); // 32 c'est l'index de state dans String[] array | Expression Lambda => il met en value la length de la key dans une Map
                 //System.out.println(stateCounts);

                //_______________*** Methode 13 merge() faire la somme des Person par etat dans une Map (Collection) de façon plus concis __________________
                ///.collect(Collectors.groupingBy(Person::state, Collectors.counting()));// RQ on sait le faire avec API Stream On va utiliser compute() C'est juste une manière plus procédurale d'obtenir des décomptes de Person par state
                .forEach(a -> stateCounts.merge(a[32], 1L, (x,y) -> x + y)); // 32 c'est l'index de state dans String[] array | arg2 1L si cette key est deja dans la Map mais que sa value est null ça remplace ce null par cette value 1 (Nbre de Person) |Expression Lambda => va passer en arg1 x la oldValue va additionner a
                System.out.println(stateCounts);

                //_______________*** Methode 14 replaceAll() avec List (Collection) mettre en majuscule les éléments de cette List __________________
                //.forEach(a -> stateCounts.merge(a[32], 1L, (x,y) -> x + y)); // Juste pour pas planter le Stream du Map | 32 c'est l'index de state dans String[] array | arg2 1L si cette key est deja dans la Map mais que sa value est null ça remplace ce null par cette value 1 (Nbre de Person) |Expression Lambda => va passer en arg1 x la oldValue va additionner a
            //List.of("cat", "dog").replaceAll(String::toUpperCase);

            //_______________*** Methode 14 removeIf() avec List (Collection) on veut retirer toute entré qui commence avec la Lettre "c" de cette List __________________
                //.forEach(a -> stateCounts.merge(a[32], 1L, (x,y) -> x + y)); // Juste pour pas planter le Stream du Map | 32 c'est l'index de state dans String[] array | arg2 1L si cette key est deja dans la Map mais que sa value est null ça remplace ce null par cette value 1 (Nbre de Person) |Expression Lambda => va passer en arg1 x la oldValue va additionner a
            //ArrayList animals = new ArrayList(Collections.singleton(List.of("cat", "dog").removeIf(w -> w.startsWith("c")))); // Erreur Pb Immutabilité | List.of() renvoie une unmodifiable List ce qui veut dire qu'elle ne peut pas etre changé => erreur => cast en ArrayList
            //System.out.println(animals);

            //System.out.println(result); //***
            long endTime = System.currentTimeMillis(); // capture le temps pris en milliseconde a la fin du calcule de la somme
            //System.out.println(result);
            //System.out.printf("$%,d.00 %n", result); // pour formater la somme des salaires au format monétaire USA
            System.out.println(endTime - startTime); // Prit le temps que ordi a pris pour faire ce calcule en milliseconde
            //____________________________________________________________________________________________________________________________


            //___________Methode 1_________________
            //.count(); // count() => compte le nombre de lignes dans le file set
            //___________Methode 2_________________
            //.collect(Collectors.toList())  // Il ne faut pas utiliser en arg toList() pour stream tous les éléments du Streams vers une List car bcp trop d'éléments 5 millions
            //.collect(Collectors.counting()); // collect() => | Collectors Framework avec des millions de methode pour Stream API | counting(


            //System.out.println(result);

        } catch (IOException e) {  // IDE n'est pas sur que le fichier existe ou que le path soit valide il demande qu'on gére l'exception avec un try catch | en arg du catch si l'exception IOException est levé lance le bloc de code en dessous
            throw new RuntimeException(e);
        }
    }
}

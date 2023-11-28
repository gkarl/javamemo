package section10StreamsAndLambdas.summingByGroups175;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Section 10: Streams & Lambdas - 175 Summing by Groups
 *
 * Dans la leçon précedente on a fait un regroupement par state + ordre alphabetique => dans ce regroupement on veut aussi avoir la somme des salary
 *
 * RQ on est plus obligé de limit() car on plus tous les field juste state et salary
 */
class BigData {
    record Person(String firstName, String lastName, long salary, String state) {} // les Record sont essentiellement des classes avec moins de passe-partout => on a pas a définir les les getter et setter ni equals() ou hashCode() => toutes ces choses sont généré pour nous
    public static void main(String[] args) {
        try {

            //__________On veut faire la somme de tous les salaire field salary dans le .csv__________________
            long startTime = System.currentTimeMillis(); // capture le temps pris en milliseconde au demarage
            //Map<String, String> result = Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv")).parallel()  // Pour importer un file qui est sur l'ordi | parallel() => permet de faire du multi processor en parrallele pour ganer en temps de calcule
                    Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv"))  // Pour importer un file qui est sur l'ordi
                    //.limit(2)  // limit() => on lui dit d'afficher que les 2 premiére lignes du Stream
                    .skip(1)
                    //.forEach(System.out::println); // print les 2 lignes | Ctrl C les 2 ligne print + ouvre Excel + clic le coin du tableur select toute la grille + Accueil/Coller/Utiliser l'assistant importation de texte/coche le séparateur virgule => affiche un entete de colle avec 1 enregistrement sur la ligne du dessous cela permet de voire convenablement de quoi parle le file
                    //.limit(100) //*** limite le Stream à 100 lignes | la 1er ligne etant juste le titre
                    //.forEach(System.out::println); // print les 10 1ere lignes | les rajoute dans le tableur Excel => tape 0 1 2 3 4 dans les 4 1ere colonnes + select 0 Shift 4  + clic drag la selction jusqu'a la derniére colonne => numéronne auto chaque colonne => ça nous donne l'index du field colonne salary
                    .map(s -> s.split(","))// map() => Il mappe un type de données à un autre type de données. | split(",") =>  Divisé par des virgules return des array de String String[] 1 par ligne | *** On pourrais pensser à utiliser une Lambda qui output juste le String plus leger que String[]

                    //.map(arr -> arr[25]) // map() => ce qui arrive par le Stream est de type array String[] on veut juste récupérer les salaires en type String | Lambda index 25 dans chaque array du Stream supérieur
                    //_______________Methode 1_______________________
                    //.map(sal -> Long.parseLong(sal))  // map() => convertit le Stream salary qui est de type String en Long
                    //.collect(Collectors.summingLong(sal -> sal)); // summingLong() => prend une valeur et return une valeur | Mais décide de combiner les 2 dernier pipes voire ligne suivante
                    //.collect(Collectors.summingLong(sal -> Long.parseLong(sal)));
                    //_______________Methode 2_______________________
                    //.mapToLong(sal -> Long.parseLong(sal))  // mapToLong() => pour convertir le String en long (primitif) permet de faire des opérations Maths
                    //.sum(); // sum() => fait la somme des salaires
                    //_______________Methode 3_______________________  // pour cette methode on n'utilise pas le pipe =>  .map(arr -> arr[25])
                    .map(a -> new Person(a[2], a[4], Long.parseLong(a[25]), a[32])) // Pour cette methode on converti Strin[] en un Domain Models (type instance de class)
                    //.collect(Collectors.summingLong(Person::salary)); // on utilise la methode 1 mais en arg on peut lui mettre un Model Reference :: salary field fait référence derriere le rideau a getSalary()
                    //_______________ Methode 1 On veut regrouper les Person par state (état)__________________
                    //.collect(Collectors.groupingBy(Person::state)); //groupingBy => prend juste en arg la colonne sur lequel on va regrouper Ex il ira 10 personnes dans cet etat | par default va utilisé un HashMap les state sont dans le désordre | Person::state ce Model Référence à pu etre utilisé car on utilise un Model Domain (class ou record) => .map(a -> new Person(a[2], a[4], Long.parseLong(a[25]), a[32]))
                    //_______________ Methode 2 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique__________________
                    //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.toList())); //groupingBy => dispose de plusieurs version on va utiliser celle avec 3 arg | TreeMap::new => arg2 instancie un TreeMap qui rande ses élément par ordre alphabétique plutot qu'un HashMap par default | toList() => garde output comme il était mais les lignes personnes dans une liste [ ]
                    //_______________*** Methode 3.1 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique + la somme des salary par regroupement par state__________________
                    //.collect(Collectors.groupingBy(Person::state, TreeMap::new,  Collectors.summingLong(Person::salary))); //_______________*** Methode 3.1 On veut regrouper les Person par state (état) mais également ranger ces state par ordre alphabetique + la somme des salary par regroupement par state__________________
                    //_______________*** Methode 3.2 idem mais format monétaire le salary__________________
                    //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), s -> String.format("$%,d.00%n", s) )));  // collectingAndThen() => permet de combiner 2 opération le output de la somme des salary va en input de arg Lambda pour format | En arg3 on peut utiliser n'importe quel methode de la class Collectors
                    //_______________*** Methode 3.2 idem autre façon de format monétaire le salary__________________
                    //.collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), s -> NumberFormat.getCurrencyInstance().format(s))));  // la 1er opération summingLong output un Long qu'on peut utliser en input de NumberFormat via Lambda | En arg3 on peut utiliser n'importe quel methode de la class Collectors
                    //_______________*** Methode 3.3 idem autre façon de format monétaire le salary__________________
                    .collect(Collectors.groupingBy(Person::state, TreeMap::new, Collectors.collectingAndThen( Collectors.summingLong(Person::salary), NumberFormat.getCurrencyInstance()::format)))  // idem à methode précédente mais on utilise une Methode REference :: plutot qu'une Lambda FVM comprend que c'est le output de l'autre opération qui arrive en input de la 2em opération | En arg3 on peut utiliser n'importe quel methode de la class Collectors
                    //_______________*** Methode 3.4 Pour format print 1 key value paire par ligne  __________________
                    //.forEach(((state, salary) -> System.out.printf("%s -> %s%n", state, salary))); // forEach() => ici fait référence à une methode de la class Map RQ on a comment la variable qui contiend l'ensemble pour ça | dans la vrai vie de dev printf n'est pas utilisé | comme on print ici on commente la variable qui collecte le output
                    //_______________*** Methode 3.5 Pour format print 1 key value paire par ligne __________________
                    .entrySet().stream() // entrySet() comme c'est une Collection offre la methode stream()
                    .forEach(((s) -> System.out.printf("%s%n", s))); // | comme on print ici on commente la variable qui collecte le output
            //System.out.println(result); //
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

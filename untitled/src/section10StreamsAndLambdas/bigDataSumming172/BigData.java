package section10StreamsAndLambdas.bigDataSumming172;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Section 10: Streams & Lambdas - 172  Big Data Summing
 *
 * On veut faire la somme de tous les salaire field salary dans le .csv
 *
 * **Je pense donc qu'il est souvent utile, en programmation, de réfléchir à votre problème :**
 *
 * - **Pensez d'abord à l'objectif final, puis en quelque sorte, au moins mentalement ou sur papier, si c'est trop compliqué,  commencez en quelque sorte par cet objectif final,**
 * - **puis travaillez en arrière à partir de là.**
 *
 * Mon objectif final est donc d'obtenir un big nbre.
 *
 * - 1/ On par d'un Stream de String (ligne de mot avec des virgules) => Je pense donc que nous voudrions pouvoir isoler ces valeurs champ salary (type String) => split(",") => crée des array de String String[] 1 par ligne
 * - 2/ Veut récupérer que le field salary qui ce trouve a index 25 dans chaque array
 * - 3/ Convertir String salary en type nbre (long) pour pouvoir faire des maths
 *
 * Il fait 2 methode pour voire laquel est la plus rapide
 *
 * parallel() => fondamentalement, ce que cela va faire, c'est que cela va permettre à notre pipeline de Stream (flux)
 * et être capable d'être traité par plusieurs cœurs Cores processor de notre ordinateur en parallèle.
 * Java gérera tout cela comme par magie, mais il déterminera le nombre de connexions parallèles en fct des ressource de l'ordi
 * Ex 5 millions de lignes serons divisé en ct du nbre de processor ex 2 processor => 2 groupes qui vont process traité en simultané
 *
 *
 */
class BigData {
    public static void main(String[] args) {
        try {

            //***__________On veut faire la somme de tous les salaire field salary dans le .csv__________________
            long startTime = System.currentTimeMillis(); // capture le temps pris en milliseconde au demarage
            long result = Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv")).parallel()  // Pour importer un file qui est sur l'ordi | parallel() => permet de faire du multi processor en parrallele pour ganer en temps de calcule
            //Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv"))  // Pour importer un file qui est sur l'ordi
                    //.limit(2)  // limit() => on lui dit d'afficher que les 2 premiére lignes du Stream
                    .skip(1)
                    //.forEach(System.out::println); // print les 2 lignes | Ctrl C les 2 ligne print + ouvre Excel + clic le coin du tableur select toute la grille + Accueil/Coller/Utiliser l'assistant importation de texte/coche le séparateur virgule => affiche un entete de colle avec 1 enregistrement sur la ligne du dessous cela permet de voire convenablement de quoi parle le file
                    //.limit(10) // limite le Stream à 10 lignes
                    //.forEach(System.out::println); // print les 10 1ere lignes | les rajoute dans le tableur Excel => tape 0 1 2 3 4 dans les 4 1ere colonnes + select 0 Shift 4  + clic drag la selction jusqu'a la derniére colonne => numéronne auto chaque colonne => ça nous donne l'index du field colonne salary
                    .map(s -> s.split(","))// map() => Il mappe un type de données à un autre type de données. | split(",") =>  Divisé par des virgules return des array de String String[] 1 par ligne
                    .map(arr -> arr[25]) // map() => ce qui arrive par le Stream est de type array String[] on veut juste récupérer les salaires en type String | Lambda index 25 dans chaque array du Stream supérieur
                    //_______________Methode 1_______________________
                    //.map(sal -> Long.parseLong(sal))  // map() => convertit le Stream salary qui est de type String en Long
                    //.collect(Collectors.summingLong(sal -> sal)); // summingLong() => prend une valeur et return une valeur | Mais décide de combiner les 2 dernier pipes voire ligne suivante
                    //.collect(Collectors.summingLong(sal -> Long.parseLong(sal)));
                    //_______________Methode 2_______________________
                    .mapToLong(sal -> Long.parseLong(sal))  // mapToLong() => pour convertir le String en long (primitif) permet de faire des opérations Maths
                    .sum(); // sum() => fait la somme des salaires

            long endTime = System.currentTimeMillis(); // capture le temps pris en milliseconde a la fin du calcule de la somme
            //System.out.println(result);
            System.out.printf("$%,d.00 %n", result); // pour formater la somme des salaires au format monétaire USA
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

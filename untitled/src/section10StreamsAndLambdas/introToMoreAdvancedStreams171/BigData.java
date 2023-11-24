package section10StreamsAndLambdas.introToMoreAdvancedStreams171;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Section 10: Streams & Lambdas - 171 Intro to More Advanced Streams
 *
 * Quelle est la différence entre count() et counting( ) ?
 *
 * Eh bien, en termes d’objectif final, il n’y a évidemment aucune différence.
 * Mais en ce qui concerne la manière dont ils sont mis en œuvre, il existe de grandes différences.
 *
 * - .collect()  vous pouvez la considérer comme un Framework  pour nous permettre de faire des choses tres puissante commes des requétes avec les Stream API.
 *  Comme c'est un Framework  toutes sortes de capacités ont été implémenté de manière assez générique derrière une interface.
 *  La principale chose à savoir est donc que dans de nombreux cas, vous n’avez pas vraiment besoin de l'utiliser
 *  Mais à mesure que nous en apprendrons davantage sur ce que nous pouvons faire avec vous verrez qu'il y a certaines choses que vous ne peut faire qu'avec collect() dans l'API streams.
 * - count() sont considérés comme étant plus spécialement conçus. Ainsi, dans certains cas, ils pourraient en fait être un peu plus efficaces.
 */
class BigData {
    public static void main(String[] args) {
        try {
            long result = Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Hr5m.csv"))  // Pour importer un file qui est sur l'ordi
                    //.limit(2)  // limit() => on lui dit d'afficher que les 2 premiére lignes du Stream
                    //.forEach(System.out::println); // print les 2 lignes | Ctrl C les 2 ligne print + ouvre Excel + clic le coin du tableur select toute la grille + Accueil/Coller/Utiliser l'assistant importation de texte/coche le séparateur virgule => affiche un entete de colle avec 1 enregistrement sur la ligne du dessous cela permet de voire convenablement de quoi parle le file
                    .skip(1)

                    //___________Methode 1_________________
                    //.count(); // count() => compte le nombre de lignes dans le file set

                    //___________Methode 2_________________
                    //.collect(Collectors.toList())  // Il ne faut pas utiliser en arg toList() pour stream tous les éléments du Streams vers une List car bcp trop d'éléments 5 millions
                    .collect(Collectors.counting()); // collect() => | Collectors Framework avec des millions de methode pour Stream API | counting(


            System.out.println(result);

        } catch (IOException e) {  // IDE n'est pas sur que le fichier existe ou que le path soit valide il demande qu'on gére l'exception avec un try catch | en arg du catch si l'exception IOException est levé lance le bloc de code en dessous
            throw new RuntimeException(e);
        }
    }
}

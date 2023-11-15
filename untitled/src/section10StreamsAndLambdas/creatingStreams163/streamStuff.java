package section10StreamsAndLambdas.creatingStreams163;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Section 10: Streams & Lambdas - 163 Creating Streams
 */
class streamStuff {

    public static void main(String[] args) {


        //______________Stream avec List________________
        System.out.println("_________Stream avec List_____________");
        List<String> numsList = List.of("one", "two", "three", "four");
        numsList
                .stream()  // on obtiens un stream à partir d'une Collection
                .map(String::toUpperCase)     // met le stream de String en majuscule | la meme chose avec une Lambda  (n -> n.toUpperCase())
                //.map(String::length) // Pour afficher la taille de chaque mot dans la List
                .forEach(System.out::println);
        System.out.println("________________________");


        //______________Stream avec Set________________ idem
        System.out.println("_________Stream avec Set_____________");
        Collection<String> numsSet = Set.of("one", "two", "three", "four");  // Crée un Set de String | si on met des éléments en doublons ça plante
        numsSet
                .stream()  // on obtiens un stream à partir d'une Collection
                //.map(String::toUpperCase)     // met le stream de String en majuscule | la meme chose avec une Lambda  (n -> n.toUpperCase())
                //.map(String::length) // Pour afficher la taille de chaque mot dans la List
                .map(String::hashCode)  // affiche le hashCode de chaque élément dans le Set
                .map(Integer::toHexString) // pour afficher ce hahsCode en hexadecimal | Methode 2 on peut remplacer les 2 derniére ligne par .forEach(h -> Systeme.out.printf("%h%n", h))
                .forEach(System.out::println);
        System.out.println("________________________");


        //_____________Crée un stream de String juste en utilisant la class Stream
        System.out.println("_________stream de String avec la class Stream_____________");
        Stream.of("one", "two", "three", "four")
                .map(String::toUpperCase)     // met le stream de String en majuscule | la meme chose avec une Lambda  (n -> n.toUpperCase())
                //.map(String::length) // Pour afficher la taille de chaque mot dans la List
                .forEach(System.out::println);
        System.out.println("________________________");


        //_____________Crée un stream de int juste en utilisant la class Stream
        System.out.println("_________stream de int avec la class Stream_____________");
        Stream.of(1, 2, 3, 4)  // Stream<Integer>
                .map(Integer::toHexString)
                .forEach(System.out::println);
        System.out.println("________________________");


        //_____________Crée un stream de class en utilisant la class Stream
        System.out.println("_________stream de class avec la class Stream_____________");
        record Car(String maker, String model){}
        Stream.of(new Car("Ford", "Branco"), new Car("Tesla", "M"), new Car("Ferrari", "Testarossa"), new Car("Tesla", "A"))
                .filter(c -> "Tesla".equals(c.maker)) // n'affichera que les marque Tesla
                .forEach(System.out::println);
        System.out.println("________________________");


        //______________Stream avec une variable null________________
        System.out.println("_________Stream variable null_____________");
        String myVar = null;
        Stream.of(myVar)
                .forEach(System.out::println);
        System.out.println("________________________");

        Stream.ofNullable(myVar)  // ofNullable() => pour éviter que le stream prenne en compte les valeur null
                .forEach(System.out::println);
        System.out.println("________________________");

        Stream.empty()  // empty() => Si on veut explicitement créer un stream vide
                .forEach(System.out::println);

        /*Stream myStream = null;
        if (myVar == null) {
            myStream = Stream.empty();
        } else {
            myStream = Stream.of(myVar);
        }
        myStream
                .forEach(System.out::println);*/


        //_____________Crée un stream de Integer en utilisant la class IntStream (il existe aussi DoubleStream et LongStream)
        System.out.println("_________stream de Integer avec la class IntStream_____________");
        IntStream.of(1, 2, 3, 4)  // IntStream => c'est juste un stream (flux) explicite d'Integer | mais n'est pas du meme type que stream | à qq methode en plus par rapport a Stream  obtenir le nbre max, faire la somme total des nbre
                .forEach(System.out::println);
        System.out.println("________________________");

        IntStream.range(1, 101)  // range() => est exlusif (le dernier chiffre n'est pas pris en compte)
                .forEach(System.out::println);
        System.out.println("________________________");

        //______________Methode 1 cast IntStream en stream de String pour concat qqc____________________
        IntStream.rangeClosed(1, 5)  // rangeClosed()  => est inclusif (le dernier chiffre est pris en compte)
                .mapToObj(String::valueOf) // mapToObj() => cast le intStream en String Stream
                .map(s -> s.concat("-"))  // rajoute des - entre les String de nbre
                .forEach(System.out::println);
        System.out.println("________________________");

        //______________Methode 2 (exo précédent)____________________
        IntStream.rangeClosed(1, 5)  // rangeClosed()  => est inclusif (le dernier chiffre est pris en compte)
                .boxed() // boxed() => cast le intStream en Stream<Integer>
                .map(String::valueOf)
                .map(c -> c.concat("-"))  // rajoute des - entre les String de nbre
                .forEach(System.out::println);
        System.out.println("________________________");


        //_____________Crée un stream de array en utilisant la class Array
        System.out.println("_________stream de array avec la class Array_____________");
        String[] names = new String[]{"karl", "Didier", "danielle"};
        Arrays.stream(names)  // Stream<Integer>
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("________________________");


        //_____________Crée un stream d'1 file texte en utilisant la class Files
        System.out.println("_________stream d'1 file texte avec la class Files_____________");
        try {
            Files.lines(Path.of("E:\\Udemy\\Java\\TerryMartin\\Projects\\6\\untitled\\src\\section10StreamsAndLambdas\\creatingStreams163\\employees.txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("________________________");


    }





}

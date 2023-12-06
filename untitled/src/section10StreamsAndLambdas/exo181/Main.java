package section10StreamsAndLambdas.exo181;



import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
class Main {
    record Car2(String make, String model, Year year){}

    record Car3(String make, String model, Year year, BigDecimal price){}

    public static void main(String[] args) {

        /*List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "S", Year.of(2014), 90000));
        cars.add(new Car("Tesla", "X", Year.of(2015), 110000));
        cars.add(new Car("Tesla", "3", Year.of(2016), 55000));
        cars.add(new Car("Tesla", "Y", Year.of(2017), 60000));
        cars.add(new Car("Tesla", "Roadster", Year.of(2009), 135000));

        //___________________Exo1___________________________
        System.out.println("___________________Exo1___________________________");
       *//* 1. En utilisant la même approche de collection de car (voitures) que dans les exercices de la dernière section,
        créez une Collection de car mais utilisez l'API Streams pour imprimer uniquement les noms de modèles de car.*//*
        cars.stream()
                .map(Car::getModel)
                .forEach(System.out::println);

        //___________________Exo2___________________________
        System.out.println("___________________Exo2___________________________");
       *//* 2. Comment pourriez-vous utiliser l'API Streams pour filtrer (ne pas afficher) toutes les cars fabriquées avant une certaine année ?
        (Si vous avez modélisé l'année de la voiture à l'aide Year date/time class, celle-ci possède une méthode isAfter()). *//*
        cars.stream()
                .filter(c -> c.getYear().isAfter(Year.of(2014)))
                .forEach(System.out::println);

        //___________________Exo3___________________________
        System.out.println("___________________Exo3___________________________");
        *//*3. Comment créer un stream (flux) de cars (voitures) sans créer explicitement une collection de cars ?
                Aide => Stream.of(new Car(), new Car(),…etc.)*//*


        *//*4. Ajoutez un field price (prix) Integer supplémentaire à votre classe/record Car. Utilisez les Streams (flux) pour ajouter le cost (coût) total
        de toutes les cars de votre collection/stream. (Il y a deux façons de procéder)*//*

        //___________________Exo4.1___________________________
        System.out.println("___________________Exo4.1___________________________");
        *//*4.1  Utilisez les Streams (flux) pour trouver le prix moyen (average price) de toutes les cars (deux façons de procéder également) - aucun code fourni*//*
        // Just showing an alternative way of creating the stream of cars
        // without first creating an explicity collection/List. This
        // approach is not necessarily better, just an alternative.
        int sum = Stream.of(
                        new Car("Tesla", "S", Year.of(2014), 90000),
                        new Car("Tesla", "X", Year.of(2015), 110000),
                        new Car("Tesla", "3", Year.of(2016), 55000),
                        new Car("Tesla", "Y", Year.of(2017), 60000),
                        new Car("Tesla", "Roadster", Year.of(2009), 135000))
//                .mapToInt(Car::getPrice) // this is first way you could do it
//                .sum(); // first way you could do it
                .collect(Collectors.summingInt(Car::getPrice)); // this is second way you could do it
        System.out.println(sum/5);*/

        //___________________Exo4.2___________________________
        System.out.println("___________________Exo4.2___________________________");
        /*4.2 Comment pourriez-vous faire l'exercice 4 avec Streams et BigDecimal (pour la précision des décimales) ?*/
        BigDecimal sum = Stream.of(
                                new Car("Tesla", "S", Year.of(2014), new BigDecimal("90000.99")),
                                new Car("Tesla", "X", Year.of(2015), new BigDecimal("110000.99")),
                                new Car("Tesla", "3", Year.of(2016), new BigDecimal("55000.99")),
                                new Car("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                                new Car("Tesla", "Roadster", Year.of(2009), new BigDecimal("135000.99")))
                        .map(Car::getPrice)

                        // solution for 4.2
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);


        //___________________Exo4.3___________________________
        System.out.println("___________________Exo4.3___________________________");
       /* 4.3 Comment pourriez-vous faire l'exercice 4.2 mais en output une String money en utilisant uniquement l'API Streams ?
        Solution présentée dans la solution 4.2*/
        String sum1 = Stream.of(
                        new Car("Tesla", "S", Year.of(2014), new BigDecimal("90000.99")),
                        new Car("Tesla", "X", Year.of(2015), new BigDecimal("110000.99")),
                        new Car("Tesla", "3", Year.of(2016), new BigDecimal("55000.99")),
                        new Car("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                        new Car("Tesla", "Roadster", Year.of(2009), new BigDecimal("135000.99")))
                .map(Car::getPrice)
                .collect(Collectors.collectingAndThen(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add), NumberFormat.getCurrencyInstance()::format));
        System.out.println(sum1);


        //___________________Exo5___________________________
        System.out.println("___________________Exo5___________________________");
        /*5. Utilisez l'API Streams pour sort (trier) un stream (flux) de cars (voitures) dans l'ordre inverse par modèle (model) */
        List<Car2> cars = new ArrayList<>();
        cars.add(new Car2("Tesla", "S", Year.of(2014)));
        cars.add(new Car2("Tesla", "X", Year.of(2015)));
        cars.add(new Car2("Tesla", "3", Year.of(2016)));
        cars.add(new Car2("Tesla", "Y", Year.of(2017)));
        cars.add(new Car2("Tesla", "Roadster", Year.of(2009)));

        cars.stream()
                .sorted(Comparator.comparing(Car2::model).reversed())
                .forEach(System.out::println);


        //___________________Exo5.1___________________________
        System.out.println("___________________Exo5.1___________________________");
        /*5.1 Pour ce faire, il faut trier (sorting) par marque (mark), puis par modèle (model), puis par année (year) - le tout en une seule fois.*/
        cars.stream()
                .sorted(
                        Comparator.comparing(Car2::make)        // notice I've statically imported 'comparing' here
                                .thenComparing(Car2::model).reversed()
                                .thenComparing(Car2::year)
                )
                .forEach(System.out::println);

        //___________________Exo6___________________________
        System.out.println("___________________Exo6___________________________");
        /*6. Utilisez uniquement l'API Streams et une collection ou un Stream (flux) d'objets Car pour produire la sortie suivante : "S, X, 3, Y, Roadster"*/
        StringBuilder sb = new StringBuilder();
        Optional<String> models = cars.stream()
                .map(Car2::model)
                .reduce((a, b) -> a.concat(", ").concat(b));
        System.out.println(models.get());

        //___________________Exo7___________________________
        /*7. Ajoutez d'autres marques (makes) de cars (voitures) à votre collection de cars (voitures), puis Marque (Make)
        Make   Model   Year     Price
        Tesla   S       2014    $90,000.99
        Tesla   X       2015    $110,000.99
        Tesla   3       2016    $55,000.99
        Tesla   Y       2017    $60,000.99
        Tesla  Roadster 2009    $135,000.99
        Lucid   Air     2021    $77,399.99
        Hyundai Ioniq   2021    $34,250.00
        Hyundai Kona    2021    $38,575.00
        Porsche Taycan  2021    $81,250.00
        Audi e-tron     2021    $66,995.00
        Volkswagen ID.4 2021    $41,190.00*/

        List<Car3> cars3 = List.of(
                new Car3("Tesla", "S", Year.of(2014), new BigDecimal("90000.99")),
                new Car3("Tesla", "X", Year.of(2015), new BigDecimal("110000.99")),
                new Car3("Tesla", "3", Year.of(2016), new BigDecimal("55000.99")),
                new Car3("Tesla", "Y", Year.of(2017), new BigDecimal("60000.99")),
                new Car3("Tesla", "Roadster", Year.of(2009), new BigDecimal("135000.99")),
                new Car3("Lucid", "Air", Year.of(2021), new BigDecimal("77399.99")),
                new Car3("Hyundai", "Ioniq", Year.of(2021), new BigDecimal("34250.00")),
                new Car3("Hyundai", "Kona", Year.of(2021), new BigDecimal("38575.00")),
                new Car3("Porsche", "Taycan", Year.of(2021), new BigDecimal("81250.00")),
                new Car3("Audi", "e-tron", Year.of(2021), new BigDecimal("66995.00")),
                new Car3("Volkswagen", "ID.4", Year.of(2021), new BigDecimal("41190"))
        );


        //___________________Exo7.1___________________________
        System.out.println("___________________Exo7.1___________________________");
        /*7.1 Déterminer le prix (price) total par marque (make)*/
        Map<String, BigDecimal> sumByMake = cars3.stream()
                .collect(Collectors.groupingBy(
                        Car3::make,
                        Collectors.reducing(BigDecimal.ZERO, Car3::price, BigDecimal::add)));
        System.out.println(sumByMake);


        //___________________Exo7.2.1___________________________
        System.out.println("___________________Exo7.2.1___________________________");
       /* 7.2 Déterminer le prix moyen d'une voiture par marque (average car price by make)*/
        /*7.2.1 Cette question sera amusante et stimulante. Vous voudrez jeter un coup d'œil à la fonction Collectors.teeing()
        que je n'ai pas explicitement enseignée, mais jetez un coup d'œil à sa javadoc.
        Si cela s'avère trop difficile mais que vous voulez quand même l'essayer sans regarder @ ma solution, ce sera
        BEAUCOUP plus facile si vous convertissez les prix en n'importe quel autre type numérique avant d'utiliser l'API
        API Streams (mais pas aussi amusant...)*/
        Map<String, BigDecimal> averageByMake = cars3.stream()
                .collect(Collectors.groupingBy(
                        Car3::make,
                        Collectors.teeing(
                                Collectors.reducing(BigDecimal.ZERO, Car3::price, BigDecimal::add),
                                Collectors.counting(),
                                (sum3, count) -> sum3.divide(new BigDecimal(count))
                        )
                ));
        System.out.println(averageByMake);


        //___________________Exo7.2.2___________________________
        System.out.println("___________________Exo7.2.2___________________________");
        /*7.2.2 Avez-vous reussit 7.2.1 ? Rendons les choses encore plus amusantes. Formatez les prix moyens pour devise (currency), dans l'API Streams.*/
        Map<String, String> formattedAverageByMake = cars3.stream()
                .collect(Collectors.groupingBy(
                        Car3::make,
                        Collectors.collectingAndThen(Collectors.teeing(
                                Collectors.reducing(BigDecimal.ZERO, Car3::price, BigDecimal::add),
                                Collectors.counting(),
                                (sum4, count) -> sum4.divide(new BigDecimal(count))
                        ), NumberFormat.getCurrencyInstance()::format)
                ));
        System.out.println(formattedAverageByMake);



        //___________________Exo7.3___________________________
        System.out.println("___________________Exo7.3___________________________");
        /*7.3 Déterminer le nombre de voitures par année puis par marque (Determine number of cars by year and then by make)*/
        Map<Year, Map<String, Long>> countByYearAndMake = cars3.stream()
                .collect(Collectors.groupingBy(Car3::year,
                                Collectors.groupingBy(Car3::make, Collectors.counting())
                        )
                );
        System.out.println(countByYearAndMake);


        //___________________Exo7.4___________________________
        System.out.println("___________________Exo7.4___________________________");
        /*7.4 Déterminer le nombre de voitures par marque en créant d'abord une nouvelle Map vide, puis en itérant sur la collection de cars voitures (que vous avez utilisée pour les exercices précédents)
        et en utilisant une Méthode Fonctionnelle de l'interface Map pour remplir votre Map vide.*/
        Map<String, Integer> countsByMake = new HashMap<>();
        cars3.stream()
                .forEach(car -> countsByMake.merge(car.make, 1, Integer::sum));
        System.out.println(countsByMake);




    }
}

package section9Collection.exo159;

import section2ClassObjetMethode.objectOrientation10.Person;

import java.sql.Array;
import java.time.LocalDate;
import java.util.*;

class Main {



    public static void main(String[] args) {
       // 1. Ecrivez un code qui vous permette de modéliser et de stocker une collection d'au moins 5 voitures
       // et de les conserver dans l'ordre dans lequel elles ont été saisies. Imprimez-les également à l'écran.

        List<String> carsList = new ArrayList<>(6);
        carsList.add("make=Ferrari, model=250 GTO, year=1999");
        carsList.add("make=Jaguar, model= E-Type, year=2020");
        carsList.add("make=Lamborghini, model=Miura, year=2000");
        carsList.add("make=Aston Martin, model=DB5, year=1970");
        carsList.add("make=Bugatti, model=Type 57SC Atlantic, year=2023");
        //carsList.add("make=Bugatti, model=Type 57SC Atlantic, year=2023");
        //System.out.println(carsList);

        //2. Même chose que l'exercice 1 sauf que nous ne nous soucions pas de conserver l'ordre et que nous voulons nous assurer que les doublons n'existent pas.
        Set<String> carsSet = new HashSet<>(6);
        carsSet.addAll(carsList);
       // System.out.println(carsSet);

        /*3. Identique à l'exercice 1 mais associez le prénom du propriétaire à chaque voiture.
        N'ajoutez pas le nom du propriétaire à votre car model class
        Imprimez chaque propriétaire avec sa voiture. Exemple :
        Bob Car[make=Tesla, model=X, year=2015]
        Jenny Car[make=Tesla, model=Y, year=2016]
        Sarah Car[make=Tesla, model=3, year=2019]*/

        List<String> propriétaires = new ArrayList<>(5);
        propriétaires.add("Karl");
        propriétaires.add("Didier");
        propriétaires.add("Eric");
        propriétaires.add("Danielle");
        propriétaires.add("Francks");
        //System.out.println(propriétaires);


        Map<String, String> ownerOfTheCar = new HashMap<>();
        ownerOfTheCar.put(propriétaires.get(0),carsList.get(0));
        ownerOfTheCar.put(propriétaires.get(1),carsList.get(1));
        ownerOfTheCar.put(propriétaires.get(2),carsList.get(2));
        ownerOfTheCar.put(propriétaires.get(3),carsList.get(3));
        ownerOfTheCar.put(propriétaires.get(4),carsList.get(4));
        //System.out.println(ownerOfTheCar);

        for (Map.Entry<String, String> entry : ownerOfTheCar.entrySet()) {
           // System.out.printf("%s Car [%s] %n", entry.getKey(), entry.getValue());
        }

        // 4. Si vous avez réalisé l'exercice 2 avec un record (enregistrement) (au lieu d'une classe), refaites-le en utilisant une classe ou vice-versa.
        Owner karl = new Owner("Karl", "Gavillot");
        Owner didier = new Owner("Didier", "Naccache");
        Owner eric = new Owner("Eric", "Nivoix");
        Owner danielle = new Owner("Danielle", "Tordjman");
        Owner francks = new Owner("Francks", "Maillet");

        List<Owner> persons = new ArrayList<>(5);
        persons.add(karl);
        persons.add(didier);
        persons.add(eric);
        persons.add(danielle);
        persons.add(francks);
        //System.out.println(persons);

        Car ferrari = new Car("Ferrari", "250 GTO", LocalDate.of(2000, 05, 20) );
        Car jaguar = new Car("Jaguar", "E-Type", LocalDate.of(2010, 10, 02) );
        Car lamborghini = new Car("Lamborghini", "Miura", LocalDate.of(2003, 01, 10) );
        Car astonMartin = new Car("Aston Martin", "DB5", LocalDate.of(1972, 02, 16) );
        Car bugatti = new Car("Bugatti", "Type 57SC Atlantic", LocalDate.of(2016, 03, 12) );
        Set<Car> carSet = new TreeSet<>();
        carSet.add(ferrari);
        carSet.add(jaguar);
        carSet.add(lamborghini);
        carSet.add(astonMartin);
        carSet.add(bugatti);


        Map<Owner, Car> ownership = new HashMap<>(5);
        ownership.put(karl, ferrari );
        ownership.put(didier, jaguar );
        ownership.put(eric, lamborghini );
        ownership.put(danielle, astonMartin );
        ownership.put(francks, bugatti );
       // System.out.println(ownership);

        /*5. Laissez les voitures de l'exercice 2 être imprimées dans l'ordre "naturel" par modèle.

        5.1 Stocker les mêmes voitures dans une liste et les trier. (Aucune solution de code n'est fournie)
        RQ Vous pouvez utiliser l'interface Comparable que vous avez probablement implémentée dans la classe Car
        sur la classe de la voiture. Il suffit alors d'appeler Collections.sort(cars).*/

        System.out.println(carSet);
        //_________methode 2+3__________
        //Collections.sort(carsList, Comparator.naturalOrder());
        //System.out.println(carsList);

        /*5.2 Stocker les mêmes voitures dans une Liste et les trier sans implémenter d'interfaces sur la classe Car.
        RQ Pour cela, il n'est même pas nécessaire d'implémenter d'implémenter Comparable dans la classe Car.
        A la place, vous pouvez appeler Collections.sort(cars, Comparator)
        et passer soit une instance de d'un comparator en tant que deuxième paramètre de sort(),
        soit une classe anonyme ou une expression Lambda.*/

        //_________methode 3__________
        //carsList.sort(Comparator.naturalOrder());
        //System.out.println(carsList);

        //5.3 Comment pouvez-vous inverser l'ordre de tri ?
        carsList.sort(Comparator.reverseOrder());
        System.out.println(carsList);

        /*6. Identique à l'exercice 5 mais permet au programme de supprimer un modèle en passant le nom du modèle comme argument à la méthode main().
        Par exemple, si vous aviez obtenu la sortie suivante au départ

        Car[make=Tesla, model=3, year=2016]
        Car[make=Tesla, model=Roadster, year=2009]
        Car[make=Tesla, model=S, year=2014]
        Car[make=Tesla, model=X, year=2015]
        Car[make=Tesla, model=Y, year=2017]

        Ensuite, vous modifiez le programme en suivant les instructions, vous ajoutez "Roadster" comme argument et vous le réexécutez,
        vous obtiendrez la sortie suivante :

        Car[make=Tesla, model=3, year=2016]
        Car[make=Tesla, model=S, year=2014]
        Car[make=Tesla, model=X, year=2015]
        Car[make=Tesla, model=Y, year=2017]

        Vous trouverez ci-dessous des instructions sur la manière de passer des arguments.*/

        /*7. Quelle serait la collection la plus efficace en termes de mémoire à utiliser pour stocker des millions ou des milliards d'objets
        dans l'ordre dans lequel ils arrivent, si vous ne savez pas exactement combien d'objets vous allez stocker à l'avance?*/

        /*J'envisagerais fortement d'utiliser une LinkedList. Tout d'abord, vous devez conserver l'ordre dans lequel ils viennent (à vous),
          vous aurez donc besoin d'un d'un type de liste. Deuxièmement, vous avez affaire à des millions ou à des milliards.
          ArrayList fonctionnerait MAIS il pré-attribue de gros morceaux de mémoire à chaque fois qu'il a besoin d'espace.
          Cela peut être inefficace et gaspilleur de temporairement de la mémoire. Une liste chaînée peut croître dynamiquement de manière très efficace.*/

        //8. Comment pourriez-vous prendre votre Collection de voitures de l'exercice 6 et les stocker dans un array de manière efficace
        // https://www.baeldung.com/java-convert-string-arraylist-array

        //_____________Methode 1________________
        /*String[] arrayResult = new String[carsList.size()];  // Ne marche pas cast exception
        carsList.toArray(arrayResult);
        System.out.println(arrayResult);
        for (String result : arrayResult) {
            System.out.println(result);
        }*/

        //_____________Methode 2________________
        /*String[] arrayResult = new String[carsList.size()];
        for (int i = 0; i < carsList.size(); i++) {
            arrayResult[i] = carsList.get(i);
            System.out.println(arrayResult[i]);
        }
        System.out.println(arrayResult.length);*/


        //_____________Methode 3________________
        String[] arrayResult = carsList.toArray(String[]::new);
        for (String result : arrayResult) {
            System.out.println(result);
        }

        /*9. Maintenant que vous connaissez les collections Java, essayez de réviser le code du jeu d'échecs
        des exercices de la section 8 pour utiliser des collections au lieu de array (sauf pour la représentation interne de l'échiquier).*/




    }
}

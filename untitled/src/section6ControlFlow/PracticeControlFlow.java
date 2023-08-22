package section6ControlFlow;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracticeControlFlow {


/*    public static void main(String[] args) {

        System.out.println("LESSON 78 ********************");
        // Lesson 78 if | else if | else
        int randomNumber = new Random().nextInt(4) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber);
        if (randomNumber == 4) {
            System.out.println("4");
        } else if (randomNumber == 3) {
            System.out.println("3");
        } else if (randomNumber == 2 ) {
            System.out.println("2");
        } else if (randomNumber == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }


        System.out.println("LESSON 79 ********************");
        // Lesson 79 != | >= | && | ||
        int randomNumber2 = new Random().nextInt(4) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber2);
        if (randomNumber > 4) {
            System.out.println("4");
        } else if (randomNumber2 != 3 && randomNumber2 % 2 == 0) {
            System.out.println("3");
        } else if (randomNumber == 2 || randomNumber2 % 2 != 0) {
            System.out.println("2");
        } else if (randomNumber == 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }


        System.out.println("LESSON 80 ********************");
        // Lesson 80 switch
        int randomNumber3 = new Random().nextInt(3) +1; // nbre random [0, 4]
        System.out.printf("Le nombre random est %d. \n", randomNumber3);
        switch (randomNumber3) {
            case 0 :
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default :
                System.out.println("3");
                break;
        }
        // ___________________________
        String command = "stop";
        switch (command) {
            case "stop":
                System.out.println("Arrez vous");
                break;
            case "go":
                System.out.println("Allez y");
                break;
            default:
                System.out.println("commande incomprise");
        }
        // ______________________________
        String command2 = null;
        if ("stop".equals(command2)) {  // dans cet ordre si non erreur
            System.out.println("Arretez vous maintenant");
        }
        // ______________________________
        if (command2 == null) {  // un moyen de se protéger avec les valeur null avec un switch
            System.out.println("commande incomprise");
        } else {
            switch (command) {
                case "stop":
                    System.out.println("Arrez vous");
                    break;
                case "go":
                    System.out.println("Allez y");
                    break;
                default:
                    System.out.println("commande incomprise");
            }
        }

        System.out.println("LESSON 81 ********************");
        // Lesson 81 switch amélioration java 14 => capable d'enr une valur dans une varible en fct des case
        String cardReceive = "3";
        int maintTotal = 11;
        int cardValue = switch (cardReceive) {
            case "roi", "reine", "valet" -> 10; // return la valeur de 10
            case "ace" -> {
                if (maintTotal <= 10) {
                    yield 11;  // si la valeur de ma main est inf à 10 alors on donne à l'as la valeur de 11
                } else {
                    yield 1;  // si non on donne à l'as la valeur de 1 (Yield return la valeur)
                }
            }
            default -> Integer.parseInt(cardReceive);  // parse un string en int
        };
        System.out.printf("La valeur de la carte recu est %d \n", cardValue);
        System.out.printf("La valeur total de la main devient %d \n ", maintTotal + cardValue);


        System.out.println("LESSON 82 ********************");
        // Lesson 82 switch amélioration java 17 => compare les type de la variable et utiliser sa valeur à l'interier de chaque case
        record Person(String firstName, String lastName, int age){};
        String var1 = "Hello world";
        Integer var2 = 34;
        String[] var3 = {"hello", "world"};
        Person var4 = new Person("Karl", "Gavillot", 50);
        Object obj = var3;
        switch (obj) {
            case String msg -> System.out.println(msg);
            case Integer num -> System.out.println("Your integer a pour valeur " + num);
            case String[] arr -> System.out.println(arr[1]);
            case Person p && p.firstName().length() > 3 -> System.out.println("Tu ressemble à " +  p.firstName());
            case null -> System.out.println("It's null");
            case default -> System.out.println("Have no Idea");
        }


        System.out.println("LESSON 83 ********************");
        // Lesson 83 Boucle While => tant que c'est vrai boucle
        // Programme ou user cherche une lettre random
        while (true) {
            int randomNum = new Random().nextInt(10) +1;
            String inputUserText = System.console().readLine("Merci de deviner un chiffre : "); //*** lance ça dans terminale pour afficher le prompte pour que user puisse entrer 1 valeur
            int inputUser = Integer.parseInt(inputUserText);  //*** Convertir un string en int
            if (inputUser == randomNum) {
                System.out.printf("Bravo vous avez trouver le bon nombre %d %n", randomNum);
                return; //*** permet de sortir du block if else
            } else {
                System.out.println("Perdu");
            }
        }


        System.out.println("LESSON 84 ******************");
        // Lesson 84 suite => rajoute une condition a la boucle While, permet sortir du programme
        // Veux mettre condition while use quite programe qd tape la lettre "q"
        int randomNum2 = new Random().nextInt(10) +1;
        String inputUserText2 = null;
        do {  //*** vérifie que 2 string ne sont égale
            inputUserText2 = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText2.matches("-?\\d{1,2}")) { //*** vérifie grace a regex qu'il y a 1 ou 2 nbre positif ou négatif
                int inputUser2 = Integer.parseInt(inputUserText2);
                if (inputUser2 == randomNum2) {
                    System.out.printf("Bravo vous avez trouver le bon nombre %d %n", randomNum2);
                    return;
                } else {
                    System.out.println("Perdu");
                }
            }
        } while (!"q".equals(inputUserText2));


        System.out.println("LESSON 85 ********************");
        // Lesson 85 suite => boucle Do While, permet de lancer au moins une fois le programme
        // il veux que le programme affiche le nbre d'essaye que ça a pris pour trouver le bon nbre
        // il veux qu'il affiche "try" 1er essaye et "tries" qd il ya plusieurs essaies
        int randomNum3 = new Random().nextInt(10) +1;
        String inputUserText3 = null;
        int nbTentative3 = 1;  // bien mettre initialisation du compteur hors de la boucle
        do {
            inputUserText3 = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText3.matches("-?\\d{1,2}")) {
                int inputUser3 = Integer.parseInt(inputUserText3);
                if (inputUser3 == randomNum3) {
                    String tryText3 = nbTentative3 == 1 ? "try" : "tries";   //*** Opérateur Ternaire permet de faire une condition en 1 ligne
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum3, nbTentative3, tryText3);
                    return;
                } else {
                    nbTentative3++;  //*** incrément du compteur
                    System.out.println("Perdu");
                }
            }
        } while (!"q".equals(inputUserText3));

        System.out.println("LESSON 86 ********************");
        // Lesson 86 suite => boucle Do While, permet de lancer au moins une fois le programme
        // il veux le nbre d'essaies
        int randomNum4 = new Random().nextInt(10) +1;
        String inputUserText4 = null;
        int nbTentative4 = 1;
        int NB_MAX_ESSAIES = 4;  // cette constante détermine le nbre d'essaie max on la retrouve  a2 endroit bien d'en faire une variable
        do {
            inputUserText4 = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText4.matches("-?\\d{1,2}")) {
                int inputUser4 = Integer.parseInt(inputUserText4);
                if (inputUser4 == randomNum4) {
                    String tryText4 = nbTentative4 == 1 ? "try" : "tries";
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum4, nbTentative4, tryText4);
                    return;
                } else {
                    nbTentative4++;
                    if (nbTentative4 > NB_MAX_ESSAIES) { // juste pour afficher message on a plus d'essaie RQ on aurais pu le mettre hors du loop moin d'imbrication (Nesting) de else if
                        System.out.printf("Vous avez depassé le nbre d'essaies max qui de %d la réponse était %d. %n", nbTentative4, randomNum4);
                        *//*return;*//* // vu quand a rajouté  && condition de sortie dans le while plus besoin d'exite par la
                    }
                    System.out.println("Perdu");
                }
            }
        } while (!"q".equals(inputUserText4) && nbTentative4 <= NB_MAX_ESSAIES); // condition && permet de sortir du programme qd dépasse le nbre essaies


        System.out.println("LESSON 87 ********************");
        // Lesson 87 suite => boucle For, permet dans sa condition de determiner combien de fois on boucle
        int randomNum5 = new Random().nextInt(10) +1;
        String inputUserText5 = null;
        int nbTentative5;
        int NB_MAX_ESSAIES5 = 4;  // cette constante détermine le nbre d'essaie max on la retrouve  a2 endroit bien d'en faire une variable
//        do {
        for (nbTentative5 = 1; nbTentative5 <= NB_MAX_ESSAIES5; nbTentative5++) {  //*** initialise le nbre une variable qui servira à d'itération | jusqu'a combien cet variable  pourra aller pour itérer | incrémente cette variable à chaque itération
            inputUserText5 = System.console().readLine("Merci de deviner un chiffre : ");
            if (inputUserText5.matches("-?\\d{1,2}")) {
                int inputUser5 = Integer.parseInt(inputUserText5);
                if (inputUser5 == randomNum5) {
                    String tryText5 = nbTentative5 == 1 ? "try" : "tries";
                    System.out.printf("Bravo vous avez trouver le bon nombre %d, au bout de %d %s %n", randomNum5, nbTentative5, tryText5);
//                    return;
                    break;  //*** dit au Thread c'est fini sort de la boucle
                } else {
//                    nbTentative5++;
                    if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY)) {  // si on a pas trouvé et qu'on est un lundi
                        System.out.printf("Tu ne la pas trouve");
                        continue; //*** permet de dire au Thread ne fait pas la suite du code passe à l'inrération suivante de la boucle
                    }
                    System.out.println("Perdu");
                }
            }
        }
//        } while (!"q".equals(inputUserText5) && nbTentative5 <= NB_MAX_ESSAIES);
        if (nbTentative5 > NB_MAX_ESSAIES) {
            System.out.printf("Vous avez depassé le nbre d'essaies max qui de %d la réponse était %d. %n", nbTentative5, randomNum5);
            *//*return;*//*
        }

        System.out.println("LESSON 88 ********************");
        // Lesson 88 for loop => un exemple simple pour etre sur qu'on a capté
        for (int counterX = 0; counterX < 10; counterX++) {
            System.out.printf("décompte %d %n", counterX);
        }


        System.out.println("LESSON 89 ********************");
        // Lesson 89 for loop => un moyen simple quand on veut juste affiché les element d'un array
        String[] fruits = {"banane", "papille", "litchi", "mague"};
        for (int i = 0; i <= fruits.length; i++) {
            System.out.printf("les fruits tropico sont : %s %n", fruits[i]);
        }

        // methode 2
        String[] fruits2 = {"banane", "papille", "litchi", "mague"};
        for (String fruit : fruits2) {
            System.out.printf("les fruits tropico sont : %s %n", fruit);
        }


        System.out.println("LESSON 90 ********************");
        // Lesson 90 Wile loop avec Regex =>
        String people7 = """
                Gavillot, Karl, 16/02/1973
                Rubble, Barney, 02/02/1995
                Flinston, William, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;
        String regex7 = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";
        Pattern pat7 = Pattern.compile(regex7);
        Matcher mat7 = pat7.matcher(people7);
        mat7.find(); // a chaque fois qu'on appel .find() regex recherche le pattern suivant qui match
        System.out.println(mat7.group("lastName")); // ligne 1
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 2
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 3
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 4
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));

        // methode 2
        String people8 = """
                Gavillot, Karl, 16/02/1973
                Rubble, Barney, 02/02/1995
                Flinston, William, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;
        String regex8 = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";
        Pattern pat8 = Pattern.compile(regex7);
        Matcher mat8 = pat8.matcher(people8);
        // a chaque fois qu'on appel .find() regex recherche le pattern suivant qui match
        while(mat8.find()) {
            System.out.printf("%s %s %s %n", mat8.group("lastName"), mat8.group("firstName"), mat8.group("dob"));
        }







    }*/
}


// C'est normale que le rn merde a cause de cette class c'est car on
// String inputUserText = System.console().readLine("Merci de deviner un chiffre : ");
// System.console().readLine doit etre lancé dans le terminal et ça marche pas
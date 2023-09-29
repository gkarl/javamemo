package section6ControlFlow.exo91;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ExoControlFlow91 {




    private static String premiereLettreRepasMajuscule(String sentence) {
        String sequenceConvert = sentence.substring(0,7) + sentence.substring(7,8).toUpperCase() + sentence.substring(8);
        return sequenceConvert;
    }
    public static void main(String[] args) {

        String[] jourDelaSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};


        /*-1. Ecrivez une méthode en 4 lignes de code (sans inclure le nom de la méthode/la signature et les accolades)
            qui produit les jours de la semaine, un par ligne, à l'aide d'une boucle "for" ordinaire et d'un Array.*/
        for (int i = 0; i < jourDelaSemaine.length; i++) {
            System.out.println(jourDelaSemaine[i]);
        }

        /*1.1 Refaites-le en utilisant la boucle enhanced ‘for-loop’.*/
        for (String day : jourDelaSemaine) {
            System.out.printf("for enhanced %s %n", day);
        }

        /*-1.2. Refaites-le en mettant une majuscule à chaque ligne de sortie.
            Dimanche
            LUNDI
            Mardi
            MERCREDI
            etc...-*/
        for (String day : jourDelaSemaine) {
            System.out.printf("for enhanced 1ere lettre en majuscule %s %n", day.substring(0, 1).toUpperCase() + day.substring(1));
        }

        /*-3. Recommencez, mais en utilisant seulement 4 lignes de code (sans inclure la méthode et les accolades de la méthode.-*/

        /*-3.1. Répétez toutes les parties de l'exercice 1, mais utilisez "while-loop" au lieu de "for-loop" (le cas échéant).-*/
        int counter = 0;
        while (counter < jourDelaSemaine.length) {
            System.out.println("Methode wjile print  jour de la semaine avec la methode while " + jourDelaSemaine[counter]);
            counter++;
        }

        /*-3.2 Refaites l'exercice 2 mais utilisez une boucle "do-while". (Aucune solution n'est fournie pour cet exercice)-*/
        int counter2 = 0;
        do {
            System.out.println("methode do while " + jourDelaSemaine[counter2]);
            counter2++;
        } while (counter2 < jourDelaSemaine.length);

        /*-4. Utilisez un Array de jours de la semaine, enhanced ‘for-loop’ et un 'if/else' pour créer la sortie suivante.
                Nous mangeons du rôti le dimanche
                Nous mangeons des spaghettis le lundi
                Nous mangeons des tacos le mardi
                Nous mangeons du poulet le mercredi
                Nous mangeons du pain de viande le jeudi
                Nous mangeons des hamburgers le vendredi
                Nous mangeons de la pizza le samedi-*/
        for (String day : jourDelaSemaine) {
            if (day.equals("lundi")) {
                System.out.printf("for enhanced Nous mangeons du rôti le %s %n", day);
            } else if (day.equals("mardi")) {
                System.out.printf("for enhanced Nous mangeons des tacos le %s %n", day);
            } else if (day.equals("mercredi")) {
                System.out.printf("for enhanced Nous mangeons du poulet le %s %n", day);
            } else if (day.equals("jeudi")) {
                System.out.printf("for enhanced Nous mangeons du pain de viande le %s %n", day);
            } else if (day.equals("vendredi")) {
                System.out.printf("for enhanced Nous mangeons des hamburgers le %s %n", day);
            } else if (day.equals("samedi")) {
                System.out.printf("for enhanced Nous mangeons de la pizza le %s %n", day);
            } else {
                System.out.printf("Nous mangeons ce qui reste le %s %n", day);
            }
        }

        /*-5. Répétez l'exercice n°4 mais au lieu de if/else, utilisez le traditionnel switch/case.-*/
        for (String day : jourDelaSemaine) {
            switch (day) {
                case "lundi" :
                    System.out.printf("switch Nous mangeons du rôti le %s %n", day);
                    break;
                case "mardi" :
                    System.out.printf("switch Nous mangeons des tacos le %s %n", day);
                    break;
                case "mercredi" :
                    System.out.printf("switch Nous mangeons du poulet le %s %n", day);
                    break;
                case "jeudi" :
                    System.out.printf("switch Nous mangeons du pain de viande le %s %n", day);
                    break;
                case "vendredi" :
                    System.out.printf("switch Nous mangeons des hamburgers le %s %n", day);
                    break;
                case "samedi" :
                    System.out.printf("switch Nous mangeons de la pizza le %s %n", day);
                    break;
                default:
                    System.out.printf("switch Nous mangeons ce qui reste le %s %n", day);
            }
        }

        /*-6. Répétez l'exercice n°5 mais utilisez newer switch expression en la répétant le moins possible.-*/
        for (String day : daysOfWeek) {
            String sentence = switch (day) {
                case "Monday" -> "We eat spaghetti on Monday";
                case "Tuesday" -> "We eat tacos on Tuesday";
                case "Wednesday" -> "We eat chicken on Wednesday";
                case "Thursday" -> "We eat meatloaf on Thursday";
                case "Friday" -> "We eat hamburgers on Friday";
                case "Saturday"-> "We eat pizza on Saturday";
                default -> "We eat pot roast on Sunday";
            };
            System.out.printf("%s %n", sentence);

        /*-6.1. Ajouter une méthode privée qui peut mettre en majuscule la première lettre de chaque mot du repas.
        Ainsi, au lieu de “We eat spaghetti on Sunday”, elle imprimerait “We eat Spaghetti on Sunday”.
         Ne mettez pas vous-même les noms des repas en majuscules. Laissez votre nouvelle méthode le faire pour vous.-*/
            System.out.printf("%s %n", premiereLettreRepasMajuscule(sentence));

        /*-6.2. Améliorez la méthode 6.1 pour qu'elle soit suffisamment intelligente pour produire un résultat :
       “We eat Pot Roast on Sunday”, c'est-à-dire qu'elle devrait mettre une majuscule à chaque mot d'une phrase,
         elle devrait mettre une majuscule à chaque mot d'un nom de repas, à plusieurs mots.-*/
            String regex = "\\w+\\s*\\w+\\s*(?<word1>\\w+)\\s?(?<word2>\\w*)\\s*\\w+";
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(sentence);
            mat.find();
            System.out.printf("We eat %s %s %s %n", mat.group("word1").substring(0,1).toUpperCase() + mat.group("word1").substring(1), mat.group("word2").substring(0,1).toUpperCase() + mat.group("word2").substring(1), day);
        }

        /*-7. Itérer sur tous les jours de la semaine dans un tableau et additionner le nombre total de caractères dans tous les jours de la semaine.
            dans tous les jours de la semaine. Par exemple, "dimanche"=6, "lundi"=6, etc. est donc 50.-*/
        int counter3 = 0;
        for (int i = 0; i < daysOfWeek.length; i++) {
            counter3 += daysOfWeek[i].length();
        }
        System.out.printf("Le nbre de lettre compris dans tous les jours de la semaine est de : %s %n", counter3);


        /*-8. Utilisez Regex avec des paramètres nommés et une boucle pour analyser les adresses ci-dessous et imprimer
        - l'adresse
        - la ville
        - l'état
        - le code postal.
        Transférez cette liste d'adresses dans votre programme à l'aide d'un bloc de texte Java """ String.
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                44444 Fourth Street, Fourth City, DD 44444
                55555 Fifth Street, Fifth City, EE 55555
                66666 Sixth Street, Sixth City, FF 66666
                77777 Seventh Street, Seventh City, GG 77777
                88888 Eighth Street, Eighth City, HH 88888
                99999 Ninth Street, Ninth City, II 99999
                00000 Tenth Street, Tenth City, JJ 00000

        Aide => Vous devez activer l'option
                MULTILINE sur le moteur regex de Java de Java.
                Vous pouvez essayer de construire les morceau par morceau en utilisant le testeur de testeur de regex à l'adresse https://regex101.com.
                Si vous utilisez le testeur de regex, assurez-vous de l'activer pour "java" et notez qu'il ne n'utilise pas les doubles espaces "\" comme l'exige l'IDE Java.-*/

        String address = """
                12345 First Street, First City, AA 90210
                22222 Second Street, Second City, BB 22222
                33333 Third Street, Third City, CC 33333
                44444 Fourth Street, Fourth City, DD 44444
                55555 Fifth Street, Fifth City, EE 55555
                66666 Sixth Street, Sixth City, FF 66666
                77777 Seventh Street, Seventh City, GG 77777
                88888 Eighth Street, Eighth City, HH 88888
                99999 Ninth Street, Ninth City, II 99999
                00000 Tenth Street, Tenth City, JJ 00000
                """;
        String regex2 = "(?<address>\\d+\\s?\\w*\\s?\\w*),\\s?(?<ville>\\w*\\s?\\w*),\\s?(?<etat>\\w*)\\s?(?<codePostal>\\d+)";
        Pattern pat2 = Pattern.compile(regex2,Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat2 = pat2.matcher(address);
        while(mat2.find()) {
            System.out.format("Address : %s \n",mat2.group("address"));
            System.out.format("Ville: %s \n", mat2.group("ville"));
            System.out.format("Etat: %s \n", mat2.group("etat"));
            System.out.format("Code Postal: %s \n", mat2.group("codePostal"));
        }



    }
}

package section5NumbersFin;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExoNumbers {

    // Exo1
    public static final int signalA = 0x01; // signal A en héxadecimal
    public static final int signalB = 0x02;
    public static final int signalC = 0x04;
    public static final int signalD = 0x08;
    public static final int signalE = 0x16;
    public static final int signalF = 0x32;
    public static final int signalG = 0x64;
    public static final int signalH = 0x128;


    public static void main(String[] args) {
        System.out.println("Exo 1 ************************");
        // Exo1
        // Si vous pouviez recevoir simultanément jusqu'à huit types de signaux radio différents (dans votre ordinateur et un programme que vous avez écrit) et que vous deviez être capable d'enregistrer quels sont ces huit types de signaux.
        //ordinateur et un programme que vous avez écrit) et que vous deviez être en mesure d'enregistrer lequel de ces huit signaux vous avez reçu à un moment donné, quel serait le format le plus compact (ou compressé - en utilisant l'expression
        //vous avez reçu à un moment donné, quelle serait la manière la plus compacte (ou comprimée - utilisant
        //de mémoire ou de stockage) pour les enregistrer (en utilisant ce que vous avez appris dans ce module) ?
        //module) ? Par exemple, vous pourriez recevoir les signaux A + B + C simultanément, ou A + D, ou juste
        //G, etc.
        //

        //Terry Martin
        //Le 7 janvier 2022 à 5:20:05 PM
        //Vous pourriez assigner chaque type de signal à un bit d'un octet.
        //signal à un bit d'un octet. Pour
        //chaque type de signal reçu, activer le
        //le bit correspondant. Ensuite,
        //convertir le schéma binaire en un
        //nombre.
        int anotherInt = 0b01 | 0b10 | 0b100; // 1 ou 2 ou 4 ... table des OR (ExoNumbers.A | ExoNumbers.B)
                                              // 001
                                              // 010
                                              // 100
                                              // ----
                                              // 111
        System.out.println(anotherInt);
        int anotherInt2 = 1 | 2 | 4; // 1 ou 2 ou 4 ... table des OR (ExoNumbers.A | ExoNumbers.B)
        System.out.println(anotherInt2);

        int signalFinal = 0b00000111; // binaire
        System.out.println(signalFinal);

         // EXO 1.2
        // Si vous recevez simultanément les signaux A + D + C, comment pouvez-vous déterminer efficacement que D est l'un des signaux que vous avez reçus ?
        //que D est l'un des signaux que vous avez reçus - en vous basant sur votre solution ci-dessus ?
        // Quelle est une autre façon d'additionner 2 + 4 sans utiliser le symbole "+" ?

        // Terry Martin
        //Le 7 janvier 2022 à 5:17:36 PM
        //Prenons le schéma binaire
        //représentant les types de signaux
        //reçus, et l'AND avec le
        //schéma binaire du type de signal
        //que vous testez.
        //Si vous avez reçu 1 0 1, et que vous voulez savoir si le bit le plus à gauche est un 1, vous pouvez utiliser la méthode de l'AND.
        //savoir si le bit le plus à gauche est un 1,
        //vous feriez AND
        //1 0 1 AND
        //1 0 0
        //Le résultat serait :
        //1 0 0
        //Et vous sauriez que le bit le plus à gauche
        //était "allumé".

        // ensuite on a une methode (dans la meme class que les attribut SIGNALa ... )qui applique un masque pour que valeur (le 4 a un maqsk = 100)
        // cette methode applique table des AND
        //                                      00000111
        //                                           100
        //                                      ----------
        //                                      00000100

        System.out.println("Exo 2 ************************");
        // EXO2
        // Quelle est une autre façon d'additionner 2 + 4 sans utiliser le symbole "+" ?
        // Terry Martin
        //Le 7 janvier 2022 à 5:25:03 PM
        //Vous pouvez utiliser une opération logique OR.
        //En Java, il s'agit du symbole de la pipe, " |
        //".
        //2 + 4 est équivalent à :
        //2 | 4
        //Remarque : cette opération ne fonctionne que pour les nombres
        //dont les motifs de bits binaires ne se
        //se chevauchent pas.
        //2 | 2 n'est pas égal à 2 + 2
        //0 0 0 0 0 0 1 0 = 2
        //OR
        //0 0 0 0 0 1 0 0 = 4
        //---------
        //0 0 0 0 0 1 1 0 = 6
        //BUT
        //0 0 0 0 0 0 1 0 = 2
        //OR
        //0 0 0 0 0 0 1 0 = 2
        //---------
        int anotherInt1 = 2 | 4;
        int anotherInt3 = 0b110;
        int anotherInt4 = 0b100 |0b10;
        int anotherInt5 = 0x02 |0x04;

//        NumberStuff myInstance = new NumberStuff();
        System.out.println(anotherInt1);
        System.out.println(anotherInt3);
        System.out.println(anotherInt4);
        System.out.println(anotherInt5);


        System.out.println("Exo 3 ************************");
        // EXO3
        // En utilisant uniquement ce que vous avez appris jusqu'à présent dans ce cours, créez une classe qui contient 10 noms en minuscules et dont la méthode peut être appelée 10 fois à chaque fois.
        //noms en minuscules et dont la méthode peut être appelée 10 fois, chaque fois,
        //retournant à chaque fois le nom suivant. Si la méthode s'appelle "next()", la première fois qu'elle est appelée, elle renvoie
        //"nom1", la deuxième fois que "next()" est appelée, elle renvoie "nom2", etc.
        //1. Faites en sorte que la méthode next() mette en majuscule la première lettre de chaque nom lorsqu'elle les produit.
        //
        //Terry Martin
        //Le 8 janvier 2022 à 3:14:11 PM
        //Vous aurez besoin d'un moyen de stocker les 10
        //noms dans une classe.
        //Vous aurez besoin d'un moyen d'accéder à chaque
        //chaque fois que la méthode next()
        //est appelée.
        //Envisagez d'utiliser un tableau, un nombre
        //et d'incrémenter le nombre.

        String[] noms = {"karl", "didier", "michael", "lionel", "eric", "davidIb", "davidHaz", "ali", "nabile", "francks"};
        for (int i = 0; i < noms.length; i++) {
            System.out.println(noms[i]);
        }

        for (String nom : noms) {
            System.out.println(nom.substring(0,1).toUpperCase() + nom.substring(1));
        }


        System.out.println("Exo 4 ************************");
        // EXO4
        // Imaginez que l'on vous fournisse des données sur la durée d'entreposage des articles dans un entrepôt. Votre tâche consiste à les classer en fonction du temps passé dans l'entrepôt.
        //Votre tâche consiste à les classer en fonction du temps passé dans l'entrepôt. Les articles peuvent être classés dans les catégories 0, 1, 2 ou 3.
        //Les articles de la classe 0 ont moins de 89 jours. Classe 1 = 90-179 jours, classe 2 = 180-269 jours,
        //Classe 3 = 270-364 jours. Pour les temps d'attente donnés dans l'entrepôt : 13, 49, 90, 130, 175, 181,
        //255, 310, 330, 359, écrivez une classe similaire à l'exercice 3 ci-dessus, qui a une méthode next() qui peut être appelée 10 fois et qui donne un résultat en forme d'indice.
        //qui peut être appelée 10 fois et qui produit un nombre représentant la classification de chaque nombre dans l'ensemble des âges ci-dessus.
        //dans l'ensemble des âges ci-dessus. Exemple : un article qui attend 5 jours renvoie 0 et un article qui attend 92 jours renvoie 1.
        //un article attendant 92 jours renverrait 1.
        //
        //Terry Martin
        //Le 8 janvier 2022 à 3:46:35 PM
        //Ce problème est surtout une question de
        //mathématiques simples et de votre capacité à
        //à reconnaître un modèle simple. Lorsque
        //vous avez une série de données dans un ensemble
        //qui doivent être classées ou
        //être classées ou regroupées à intervalles réguliers, vous
        //souvent de diviser par cet intervalle
        //intervalle régulier. Dans ce cas, l'intervalle
        //intervalle est de 90. En divisant chaque
        //par 90, vous traduirez les
        //directement les valeurs dans leur classification
        //numérique de 0, 1, 2 ou 3.

        int[] tempsAttenteEntrepos = {13, 49, 90, 130, 175, 181, 255, 310, 330, 359};
        for (int i = 0; i < tempsAttenteEntrepos.length; i++) {
            System.out.printf("La classification est %d %n",next(tempsAttenteEntrepos[i]));

            /*List<Integer> classification = new ArrayList<>();
            classification.add(tempsAttenteEntrepos[i] / 90);
            System.out.printf("la classification %s", classification);*/
        }


        System.out.println("Exo 5 ************************");
        // EXO5
        // Créez une méthode, next(), qui peut être appelée 10 fois et qui génère un nombre entier aléatoire entre
        //0 & 10 (non inclus). Cette méthode conserve la somme de tous les nombres aléatoires qu'elle génère et renvoie cette somme à chaque fois.
        //et renvoie cette somme à chaque fois. Si la première fois que next() est appelée, elle génère 5, et la deuxième fois qu'elle est appelée, elle génère 3, et la troisième fois, elle génère 3.
        //elle génère 3, elle doit renvoyer 8 lors du second appel - par exemple
        int cumulRandomNumber = 0;
        for (int i = 0; i < 10; i++) {
            cumulRandomNumber = cumulRandomNumber + next2();
            System.out.println(cumulRandomNumber);


        System.out.println("Exo 6 ************************");
        // EXO6
        // Écrivez une fonction qui prend une chaîne de caractères comme "149.32" et la formate en argent pour l'endroit où vous vivez.
        //où vous vivez. Ainsi, si vous vivez aux Etats-Unis, la fonction renverra "$149.32", Corée = ₩149, France/
        //UE = 149,32 €, etc.
        String argent = "149.32";
        System.out.println(moneyFormatter.format(monnaieConverteur(argent)));
        System.out.println(moneyFormatter2.format(monnaieConverteur(argent)));
        System.out.println(moneyFormatter3.format(monnaieConverteur(argent)));


        System.out.println("Exo 7 ************************");
        // EXO7
        // Ecrivez une fonction qui prend en entrée une chaîne de caractères "$12,345.83" et qui imprime cette valeur divisée
        //par 32,19. Elle doit retourner 383,53 $.
        String argent2 = "$12,345.83";
        String regex = "^\\$(\\d{1,3})\\,((\\d{3})*|(\\d+))(\\.\\d{2})?$";
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(argent2);
        if (mat.matches()) {
            System.out.println(mat.group(0));
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println(mat.group(3));
            System.out.println(mat.group(5));
            System.out.println(moneyFormatter2.format(monnaieConverteur2(mat.group(1).concat(mat.group(2).concat(mat.group(5))))));
            System.out.printf("$12,345.83 / 32 = %s%n", moneyFormatter2.format(monnaieConverteur2(mat.group(1).concat(mat.group(2).concat(mat.group(5))))));
        }

        System.out.println("Exo 8 ************************");
        // EXO8
        // Utilisez printf() pour formater les entrées suivantes et imprimer les sorties suivantes
        //
        //Entrée                          Sortie
        //123456.783                      $123,456.78
        //-9876.32532                     (9,876.325)
        //23.19283928394829182            2.319284e+01f
        //123456                          0000123456
        //-9876.35532                     -9,876.4

        double value1 = 123456.783;
        double value2 = -9876.32532;
        double value3 = 23.19283928394829182;
        double value4 = 123456;
        double value5 = -9876.35532;

        System.out.printf("entré = 123456.783 | sortie devient = $%,.2f\n", value1);
        System.out.printf("entré = -9876.32532 | sortie devient = %,(.2f\n", value2);
        System.out.printf("entré = 123456 | sortie devient = 0000%.0f\n", value4);
        System.out.printf("entré = -9876.35532 | sortie devient = %,.1f\n", value5);



        System.out.println("Exo 9 ************************");
        // EXO9
        // Comment pourriez-vous formater chacune des entrées du tableau ci-dessus et les stocker dans des variables de type chaîne au lieu de les imprimer directement ?
        //au lieu de les imprimer directement ?
        //10. Utilisez des instances de DecimalFormat pour effectuer les mêmes conversions que dans le tableau ci-dessus.
        //11. Ecrivez une méthode qui prend les entrées String, "37" & "13", et renvoie un entier de leur
        //somme, 50.

        DecimalFormat df1 = new DecimalFormat("$#,###.##");
        DecimalFormat df2 = new DecimalFormat("#,###.###;(#)");
        String value3ToHexa = Double.toHexString(value3);
        DecimalFormat df4 = new DecimalFormat("0000000000");
        DecimalFormat df5 = new DecimalFormat("0,000.0;-#");

        System.out.printf("entré = 123456.783 | sortie devient = %s%n", df1.format(value1));
        System.out.printf("entré = -9876.32532 | sortie devient = %s%n", df2.format(value2));
        System.out.println(value3ToHexa);
        System.out.printf("entré = 123456 | sortie devient = %s%n", df4.format(value4));
        System.out.printf("entré = -9876.35532 | sortie devient = %s%n", df5.format(value5));




        }
    }

    // EXO 4
    public static int next(int tempsAttente) {
        return tempsAttente / 90;
    }

    // EXO 5
    public static int next2() {
        Random random = new Random();
        int randomNumber = random.nextInt(10); // Methode 1
        int randomNumber2 = (int) (Math.random() * 10); // Methode 2
        System.out.printf("Le nombre random est %d%n", randomNumber2);
        return randomNumber2;
    };

    // EXO 6
    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private static final NumberFormat moneyFormatter2 = NumberFormat.getCurrencyInstance(Locale.US);
    private static final NumberFormat moneyFormatter3 = NumberFormat.getCurrencyInstance(Locale.CHINA);
    public static BigDecimal monnaieConverteur(String argent) {
        BigDecimal num = new BigDecimal(argent);
        return num;

    };

    // EXO 7
    public static BigDecimal monnaieConverteur2(String argent) {
        BigDecimal num2 = new BigDecimal(argent).divide(BigDecimal.valueOf((32)));
        return num2;
    }


}

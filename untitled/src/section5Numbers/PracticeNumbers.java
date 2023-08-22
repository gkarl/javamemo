package section5Numbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;

public class PracticeNumbers {



    public static void main(String[] args) throws ParseException {

        System.out.println("LESSON 63 ********************");
        // Lesson 63
        System.out.println(Math.abs(-6));     // absolue
        System.out.println(Math.ceil(4.4));   // de que depasse .01 il arrandi vers le haut
        System.out.println(Math.floor(4.4));  // de que depasse .01 il arrandi vers le bas
        int num1 = 2;
        int num2 = 8;
        System.out.println(Math.min(num1, num2));   // prend le chiffre le plus petit entre 2
        System.out.println(Math.max(num1, num2));   // prend le chiffre le plus grand entre 2
        System.out.println(Math.pow(2, 3));         // exposent
        System.out.println(Math.random());
        System.out.println(Math.random() * 10);
        System.out.println((int) (Math.random() * 10));  // randomise pas la meilleur methode
        System.out.println((int) (Math.random() * 10));
        System.out.println((int) (Math.random() * 10));
        System.out.println((int) (Math.random() * 10));
        System.out.println(Math.round(2.4));
        System.out.println(Math.round(2.5));       // arrondi
        System.out.println(Math.sqrt(25));        // racine carré
        System.out.println(Math.PI);
        System.out.println(Math.E);

       System.out.println("LESSON 64 ********************");
       // Lesson 64 => autre methodes de random plus valable
        Random random = new Random();
        System.out.println(random.nextInt(10));     // methode 2 random  OK
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(10));

        SecureRandom random1 = new SecureRandom();       // methode 3 random plus secure
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));

        System.out.println("LESSON 65 ********************");
        // Lesson 65 EXO => Calculer l'aire d'un cercle
        System.out.println(calcAreaOfCircle(3));

        System.out.println("LESSON 66 ********************");
        // Lesson 66 EXO => Calculer d'un modele de physique à 3 equations pour obtenir le résultat
        /*System.out.println(calcPathVelocity(0.8, 3));
        System.out.println(calcCentripetAcc(1.67, 0.8));
        System.out.println(calCentripForce(0.2, 3.504));*/
        System.out.println(calCentripForce(0.2, 0.8, 3));

        System.out.println("LESSON 67 ********************");
        // Lesson 67 Comparer des nbre
        int numA = 5;
        int numB = 7;
        System.out.println(numA == numB);
        System.out.println(numA >= numB);
        System.out.println(numA != numB);

        System.out.println("LESSON 68 ********************");
        // Lesson 68 BigDecimal => permet de faire des opération avec les nbre a virgule plus précis (on l'utile pour banque et sciences)
        float numC = 2.15f;
        float numD = 1.10f;
        System.out.println(numC - numD);
        BigDecimal numE = new BigDecimal("2.15");
        BigDecimal numF = new BigDecimal("1.10");
        System.out.println(numE.subtract(numF));


        System.out.println("LESSON 69 ********************");
        // Lesson 69 BigDecimal => practice
        System.out.println(new BigDecimal(".314").add(new BigDecimal("5.321"))); // Addition
        System.out.println(new BigDecimal(".314").subtract(new BigDecimal("5.321"))); // Soustraction
        System.out.println(new BigDecimal(".314").multiply(new BigDecimal("5.321"))); // Multiplication

        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal(".314").divide(new BigDecimal("5.321"), mc)); // Division (attention au parenthése à la fin)

        System.out.println(new BigDecimal("25").sqrt(mc)); // Racine quarré
        System.out.println(new BigDecimal(".314").max(new BigDecimal("5.321"))); // Max => affiche le chiffre le plus grand des 2
        System.out.println(new BigDecimal(".314").min(new BigDecimal("5.321"))); // Min => affiche le chiffre le plus metit des 2
        System.out.println(new BigDecimal("-.314").abs()); // Valeur Absolut
        System.out.println(new BigDecimal("13").remainder(new BigDecimal("8"))); // Modulo


        System.out.println("LESSON 70 ********************");
        // Lesson 70 BigDecimal => suite
        BigDecimal numG = new BigDecimal("2.15");
        byte b = numG.byteValue(); // cast en byte idem double float
        String myString = numG.toString(); // cast en string

        System.out.println("LESSON 71 ********************");
        // Lesson 71 BigDecimal => suite exo calcule comptable
        System.out.println(calculeComptable("10000.00", ".08", 10, "1000"));

        System.out.println("LESSON 72 ********************");
        // Lesson 72 BigDecimal => suite exo 71 veux pouvoir entrer des valeur monney et % qd lance la methode
        BigDecimal balance2 = calculeComptable2("10000.00", ".08", 10, "1000");
        System.out.println(moneyFormatter.format(balance2));
        /*BigDecimal balance3 = calculeComptable3("$10,000", "8%", 10, "$1,000"); //n'a pas marché
        System.out.println(moneyFormatter.format(balance3));*/


        System.out.println("LESSON 73 ********************");
        // Lesson 73 DecimalFormat => suite exo 71 methode 2 custom format nbre
        DecimalFormat df = new DecimalFormat("#");
        DecimalFormat df2 = new DecimalFormat("#.##");
        DecimalFormat df3 = new DecimalFormat("#,###.##");
        DecimalFormat df4 = new DecimalFormat("$#,###.##");
        DecimalFormat df5 = new DecimalFormat("$#,###.##;$(#)");
        DecimalFormat df6 = new DecimalFormat("$#,###.00;$(#)");
        DecimalFormat df7 = new DecimalFormat("$0000000,000.00;$(#)");
        BigDecimal balance4 = PracticeNumbers.calculeComptable2("10000.00", ".08", 10, "1000");
        System.out.println(df.format(balance4));
        System.out.println(df2.format(balance4));
        System.out.println(df3.format(balance4));
        System.out.println(df4.format(balance4));
        System.out.println(df5.format(balance4.negate()));
        System.out.println(df6.format(balance4.negate()));
        System.out.println(df7.format(balance4));

        DecimalFormat pf = new DecimalFormat("#%");
        DecimalFormat pf2 = new DecimalFormat("#,###%");
        System.out.println(pf.format(.08));
        System.out.println(pf2.format(2737.08));

        System.out.println("LESSON 74 ********************");
        // Lesson 74 printf ou String.format() => suite exo 71 methode 3 custom format nbre
        System.out.printf("%f\n", balance2);
        System.out.printf("%.2f\n", balance2);
        System.out.printf("$%.2f\n", balance2);
        System.out.printf("$%,.2f\n", balance2);
        System.out.printf("$%,(.2f\n", balance2.negate());
        System.out.format("$%,(.2f\n", balance2.negate());
        System.out.format("$%,(.2f%n", balance2.negate());
        String MyMoney = String.format("$%,(.2f%n", balance2.negate()); // methode utilisé chez les pro car permet concat
        System.out.println(MyMoney);

        System.out.println("LESSON 75 ********************");
        // Lesson 7 printf ou Integer.parseInt() => convertir un string en int pour pouvoir faire des opération dessus
        int num10 = 7;
        Integer num11 = Integer.valueOf(num10); // convertit in int en Integer ex attendu en param d'1 methode (ce fait auto par IDE)

        int age = Integer.parseInt("37");  // convertir un string en int (idem pour les autres)
        System.out.printf("Ton age devrais etre de %d dans 15ans", age + 15);


    }

    // Lesson 65 EXO **********************
    /**
     * Cette methode calcule l'aire d'un cercle
     * @param radius
     * @return
     */
    public static double calcAreaOfCircle(double radius) {
       return Math.PI * Math.pow(radius, 2);
    } ;

    // Lesson 66 EXO ********************
    private static double calcPathVelocity(double radius, double periode) {
        double circonference = 2 * Math.PI * radius;
        return circonference / 3;
    }
    private static double calcCentripetAcc(double pathVelocity, double radius) {
        return Math.pow(pathVelocity, 2) / radius;
    }
    private static  double calCentripForce(double mass, double acc) {
        return mass * acc;
    }
    public static  double calCentripForce(double mass,  double radius, double periode) {
        double pathVelocity = calCentripForce(radius, periode);
        double centripetAcc = calcCentripetAcc(pathVelocity, radius);
        double centripForce = calCentripForce(mass, centripetAcc);
        return centripForce;
    }

    // Lesson 71 BigDecimal => suite exo calcule comptable
    public static  BigDecimal calculeComptable(String principal, String rate, int periode, String contribution) {
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(periode); // (1 + r) exp Y
        BigDecimal b = a.subtract(BigDecimal.ONE); // (1 + r) exp Y -1
        /*MathContext mc = new MathContext(2, RoundingMode.HALF_UP);*/
        BigDecimal c = b.divide(new BigDecimal(rate)); // ((1 + r) exp Y -1) / r
        BigDecimal d = c.multiply(new BigDecimal(contribution)); // c*[((1 + r) exp Y -1) / r]
        BigDecimal e = a.multiply(new BigDecimal(principal)); // P*((1 + r) exp Y)
        BigDecimal f = d.add(e); // P*((1 + r) exp Y) + c*[((1 + r) exp Y -1) / r]
        return f;
    }

    // Lesson 72 BigDecimal => suite exo calcule comptable
    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();  // permet en sortit d'avoir un affichage en  $
    // private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);  // la variable moneyFormatteur permet en sortit d'avoir un affichage avec € et les espacement et virgule qui vont bien en fct du pays
    private static final NumberFormat pourcentFormatter = NumberFormat.getPercentInstance();

    public static  BigDecimal calculeComptable2(String principal, String rate, int periode, String contribution) throws ParseException {
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(periode); // (1 + r) exp Y  // instanciation type BigDecimal des parametre permette la précision des calcules par l'ordi
        BigDecimal b = a.subtract(BigDecimal.ONE); // (1 + r) exp Y -1
        /*MathContext mc = new MathContext(2, RoundingMode.HALF_UP);*/
        BigDecimal c = b.divide(new BigDecimal(rate)); // (((1 + r) exp Y) -1) / r
        BigDecimal d = c.multiply(new BigDecimal(contribution)); // c*[(((1 + r) exp Y) -1) / r]
        BigDecimal e = a.multiply(new BigDecimal(principal)); // P*((1 + r) exp Y)
        BigDecimal f = d.add(e); // P*((1 + r) exp Y) + c*[(((1 + r) exp Y) -1) / r]
        return f;
    }

    public static  BigDecimal calculeComptable3(String principal, String rate, int periode, String contribution) throws ParseException {
        String rateAsPercent = pourcentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)).pow(periode); // (1 + r) exp Y
        BigDecimal b = a.subtract(BigDecimal.ONE); // (1 + r) exp Y -1
        //*MathContext mc = new MathContext(2, RoundingMode.HALF_UP);*//*
        BigDecimal c = b.divide(new BigDecimal(rateAsPercent)); // ((1 + r) exp Y -1) / r
        BigDecimal d = c.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString()));
        BigDecimal e = a.multiply(new BigDecimal(moneyFormatter.parse(principal).toString()));
        BigDecimal f = d.add(e);
        return f;
    }
}

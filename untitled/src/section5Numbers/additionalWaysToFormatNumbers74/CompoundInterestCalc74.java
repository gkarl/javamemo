package section5Numbers.additionalWaysToFormatNumbers74;

import section5Numbers.PracticeNumbers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Section 5 - 74 Additional Ways to Format Numbers
 *
 * System.out.printf() => permet de formater l'affichafe d'un float
 *
 * System.out.format() => idem
 *
 * String variable = String.format() => permet de stocker output dans une variable de type String
 *
 *
 *
 */
class CompoundInterestCalc74 {

    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    // private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    private static final NumberFormat pourcentFormatter = NumberFormat.getPercentInstance();


    /**
     * Suite 2 Méthode qui puisse calculer les intérêts composés => amélioration permet au lancement de la methode calculeComptableB entrer les input (args) au format monétaire & pourcentage
     *
     * @param principal
     * @param rate
     * @param periode
     * @param contribution
     * @return
     * @throws ParseException
     */
    public static BigDecimal calculeComptable(String principal, String rate, int periode, String contribution) throws ParseException {
        String rateAsPercent = pourcentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)).pow(periode);
        BigDecimal b = a.subtract(BigDecimal.ONE);
        BigDecimal c = b.divide(new BigDecimal(rateAsPercent));
        BigDecimal d = c.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString())); //** moneyFormatter.parse() => return type number  | PB BigDecimal attend en input (arg) des type String => toString()  => type number devient type String
        BigDecimal e = a.multiply(new BigDecimal(moneyFormatter.parse(principal).toString()));
        BigDecimal f = d.add(e);
        return f;
    }

    public static void main(String[] args) {

        BigDecimal balance = PracticeNumbers.calculeComptable("10000.00", ".08", 10, "1000");
        System.out.println(moneyFormatter.format(balance));

        //______________________Methode 1___________________
        System.out.printf("%f\n", balance);     // %f => float
        System.out.printf("%.2f\n", balance);   // %.2f => .2 il veut préciser le niveau de précision 2 chiffre apres la virgule
        System.out.printf("$%.2f\n", balance);  // $%.2f => $ veux rajouter le signe $ devant
        System.out.printf("$%,.2f\n", balance); // $%,.2f => , c'est un flag dit oui on veut grouping par 3 chiffres
        System.out.printf("$%,(.2f\n", balance.negate()); // $%,(.2f => => ( flag dit oui on veut mettre des parenthése qd nbre négatif (formatage américain)

        //______________________Methode 2___________________
        System.out.format("$%,(.2f\n", balance.negate()); // System.out.format() idem que System.out.printf()
        System.out.format("$%,(.2f%n", balance.negate());

        //______________________Methode 3___________________
        String MyMoney = String.format("$%,(.2f%n", balance.negate()); // String.format() utile pour stocker output en type String, methode utilisé chez les pro car permet concat
        System.out.println(MyMoney);

    }
}

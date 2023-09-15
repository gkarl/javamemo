package section5Numbers.formatageNumbers72;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Section 5 - 72 Formatting Numbers
 */
class CompoundInterestCalc72 {

    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();  // NumberFormat.getCurrencyInstance() => class instancié et sa methode pour pouvoir formater en € un arg de la methode concerné |
    // private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);  // la variable moneyFormatteur permet en sortit d'avoir un affichage avec € et les espacement et virgule qui vont bien en fct du pays

    private static final NumberFormat pourcentFormatter = NumberFormat.getPercentInstance();  // NumberFormat.getPercentInstance() => class instancié et sa methode pour pouvoir formater en % un arg de la methode concerné

    /**
     * Suite 1 Méthode qui puisse calculer les intérêts composés => amélioration valeur retournée formaté en valeur monétaire
     * @param principal
     * @param rate
     * @param periode
     * @param contribution
     * @return
     * @throws ParseException
     */
    public static  BigDecimal calculeComptableA(String principal, String rate, int periode, String contribution) throws ParseException {
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(periode);
        BigDecimal b = a.subtract(BigDecimal.ONE);
        BigDecimal c = b.divide(new BigDecimal(rate));
        BigDecimal d = c.multiply(new BigDecimal(contribution));
        BigDecimal e = a.multiply(new BigDecimal(principal));
        BigDecimal f = d.add(e);
        return f;
    }

    /**
     * Suite 2 Méthode qui puisse calculer les intérêts composés => amélioration permet au lancement de la methode calculeComptableB entrer les input (args) au format monétaire & pourcentage
     *
     * RQ On ne l'utilisera pas cette façon de faire dans la réalité = formatage des arg au lancement de la methode
     * Si une interface user on utilisera plutot une Regex pour formatter les nbre entré par user avant le lancement de la methode
     * et permettre à user d'entrer les chiffre au format souhaité par l'user
     *
     * @param principal
     * @param rate
     * @param periode
     * @param contribution
     * @return
     * @throws ParseException
     */
    public static  BigDecimal calculeComptableB(String principal, String rate, int periode, String contribution) throws ParseException {
        String rateAsPercent = pourcentFormatter.parse(rate).toString(); //**  pourcentFormatter.parse => return type number  | PB BigDecimal attend en input (arg) des type String => toString()  => type number devient type String | local variable crée car le meme code est utilisé à 2 endroits dans la methode

        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)).pow(periode);
        BigDecimal b = a.subtract(BigDecimal.ONE);
        BigDecimal c = b.divide(new BigDecimal(rateAsPercent));
        BigDecimal d = c.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString())); //** moneyFormatter.parse() => return type number  | PB BigDecimal attend en input (arg) des type String => toString()  => type number devient type String
        BigDecimal e = a.multiply(new BigDecimal(moneyFormatter.parse(principal).toString()));
        BigDecimal f = d.add(e);
        return f;
    }

    public static void main(String[] args) throws ParseException {

        BigDecimal balance1 = calculeComptableA("10000.00", ".08", 10, "1000");
        System.out.println(moneyFormatter.format(balance1));

        BigDecimal balance2 = calculeComptableB("10 000,00 €", "8 %", 10, "1 000,00 €");
        System.out.println(moneyFormatter.format(balance2));



    }
}

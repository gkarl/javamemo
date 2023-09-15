package section5Numbers.customizingNumberFormatters73;

import section5Numbers.PracticeNumbers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Section 5 - 73 Customizing Number Formatters
 */
class CompoundInterestCalc73 {

    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();  // NumberFormat.getCurrencyInstance() => class instancié et sa methode pour pouvoir formater en € un arg de la methode concerné |
    // private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);  // la variable moneyFormatteur permet en sortit d'avoir un affichage avec € et les espacement et virgule qui vont bien en fct du pays

    private static final NumberFormat pourcentFormatter = NumberFormat.getPercentInstance();  // NumberFormat.getPercentInstance() => class instancié et sa methode pour pouvoir formater en % un arg de la methode concerné

    private static final DecimalFormat df = new DecimalFormat("#"); //** DecimalFormat => Class qui permet de faire un format custom | "#" => ça format le chiffre pour n'afficher que la partie juste avant la virgule => 163270
    private static final DecimalFormat df2 = new DecimalFormat("#.##"); //** "#.##" => permet d'afficher 2 chiffre aprés la virgule => 163270.02
    private static final DecimalFormat df3 = new DecimalFormat("#,###.##"); //** "#,###.##"  => Si on veut faire à l'américaine avec une virgule pour marquer une dif entre les 1000 tous les 3 chiffres => 163,270.02
    private static final DecimalFormat df4 = new DecimalFormat("$#,###.##"); //** "$#,###.##"  => rajoute le signe $ devant le nbre => $163,270.02
    private static final DecimalFormat df5 = new DecimalFormat("$#,###.##;$(#)"); //** normes comptables américaine, les nbre négatifs sont mis entre parenthése
    private static final DecimalFormat df6 = new DecimalFormat("$#,###.00;$(#)"); //** "$#,###.00;$(#)"  => pour forcer un affichage 2 chiffres aprés la virgule meme si affiche des 0 aprés
    private static final DecimalFormat df7 = new DecimalFormat("$0000000,000.00;$(#)"); //** "$0000000,000.00;$(#)"  => On peut faire cette sorte de padding (rajouter des 0 devant) aussi avant la virgule => $0,000,163,270.02

    private static final DecimalFormat pf = new DecimalFormat("#%"); // "#% " =>  pour formatter en % il c'est que si il voit ce signe % il multiplie le chiffre # par 100 => 8%
    private static final DecimalFormat pf2 = new DecimalFormat("#,###%"); // Ex de formatage d'un nbre en % => 273,708%

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
    public static  BigDecimal calculeComptable(String principal, String rate, int periode, String contribution) throws ParseException {
        String rateAsPercent = pourcentFormatter.parse(rate).toString(); //**  pourcentFormatter.parse => return type number  | PB BigDecimal attend en input (arg) des type String => toString()  => type number devient type String | local variable crée car le meme code est utilisé à 2 endroits dans la methode

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

        System.out.println(df.format(balance));
        System.out.println(df2.format(balance));
        System.out.println(df3.format(balance));
        System.out.println(df4.format(balance));
        System.out.println(df5.format(balance.negate())); // negate() => methode de la class BigDecimal pour le rendre négatif
        System.out.println(df6.format(balance.negate()));
        System.out.println(df7.format(balance));

        System.out.println(pf.format(.08));
        System.out.println(pf2.format(2737.08));

    }
}

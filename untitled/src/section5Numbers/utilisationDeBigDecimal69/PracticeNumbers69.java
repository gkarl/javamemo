package section5Numbers.utilisationDeBigDecimal69;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Section 5 - 69 Utilisation de BigDecimal
 *
 * Petit tour d'horizon de certains des méthodes clés de BigDecimal pour effectuer des opérations mathématiques
 *
 */
class PracticeNumbers69 {

    public static void main(String[] args) {

        System.out.println(new BigDecimal(".314").add(new BigDecimal("5.321"))); // add() => Addition

        System.out.println(new BigDecimal(".314").subtract(new BigDecimal("5.321"))); // subtract() => Soustraction

        System.out.println(new BigDecimal(".314").multiply(new BigDecimal("5.321"))); // multiply() => Multiplication

        MathContext mc = new MathContext(2, RoundingMode.HALF_UP); // MathContext => class prend 2 args (précision, Mode d'arrondi) à instanciation utilisé avec les méthodes divide() & sqrt() | EX précision 2 = 2 chiffre aprés les 0 zero aprés la virgule
        System.out.println(new BigDecimal(".314").divide(new BigDecimal("5.321"), mc)); // divide() => Division prend 2 args (le diviseur, l'instance MathContext)
        System.out.println(new BigDecimal("25").sqrt(mc)); // sqrt() => Racine quarré prend 1 arg (l'instance MathContext)

        System.out.println(new BigDecimal(".314").max(new BigDecimal("5.321"))); // max() => affiche le chiffre le plus grand des 2

        System.out.println(new BigDecimal(".314").min(new BigDecimal("5.321"))); // min() => affiche le chiffre le plus petit des 2

        System.out.println(new BigDecimal("-.314").abs()); // abs() => Valeur Absolut

        System.out.println(new BigDecimal("1").remainder(new BigDecimal("2"))); // remainder() => Modulo | EX 13/8 return le reste 5 | Utile de le faire sur une séquence de nbre pour faire ressortir un Pattern 01010101 pour faire une action toutes les 2 lignes
        System.out.println(new BigDecimal("2").remainder(new BigDecimal("2")));
        System.out.println(new BigDecimal("3").remainder(new BigDecimal("2")));
        System.out.println(new BigDecimal("4").remainder(new BigDecimal("2")));

    }
}

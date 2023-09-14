package section5Numbers.exoCalculInteretComposes71;

import java.math.BigDecimal;

/**
 * Section 5 - 71 Exercice de codage : Calcul des intérêts composés
 */
class CompoundInterestCalc71 {


    /**
     * Méthode qui puisse calculer les intérêts composés
     * Formule de départ =
     * Balance = (P(1+r))^Y + c[(((1+r)^Y)-1)/r]
     *
     * @param principal = (capital) montant de départ
     * @param rate = principe rate (taux d'intérêt) ou rate of return (taux de rendement)
     * @param periode = years (années)
     * @param contribution = contribution amount (un montant de cotisation)
     * @return = BigDecimal
     */
    public static BigDecimal calculeComptable(String principal, String rate, int periode, String contribution) {
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(periode); // (1 + r) ^ Y
        BigDecimal b = a.subtract(BigDecimal.ONE); // ((1 + r) exp Y) -1
        /*MathContext mc = new MathContext(2, RoundingMode.HALF_UP);*/ // il n'a pas utilisé MathContext en 2em arg de la methode divide() attend de voire si le programme plante sans avant
        BigDecimal c = b.divide(new BigDecimal(rate)); // (((1 + r) exp Y) -1) / r
        BigDecimal d = c.multiply(new BigDecimal(contribution)); // c*[(((1 + r) exp Y) -1) / r]
        BigDecimal e = a.multiply(new BigDecimal(principal)); // P*((1 + r) exp Y)
        BigDecimal f = d.add(e); // P*((1 + r) exp Y) + c*[(((1 + r) exp Y) -1) / r]
        return f;
    }

    public static void main(String[] args) {

        System.out.println(calculeComptable("10000.00", ".08", 10, "1000"));
    }
}

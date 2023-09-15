package section5Numbers.exoCalculInteretComposes71;

import java.math.BigDecimal;

/**
 * Section 5 - 71 Exercice de codage : Calcul des intérêts composés
 */
class CompoundInterestCalc71 {


    /**
     * Méthode qui puisse calculer les intérêts composés
     * Formule de départ :
     * Balance = (P(1+r))^Y + c[(((1+r)^Y)-1)/r]
     *
     * @param principal = P (capital) montant de départ | type String
     * @param rate = r principe rate (taux d'intérêt) ou rate of return (taux de rendement) | type String
     * @param periode = Y years (années) | type int
     * @param contribution = c contribution amount (un montant de cotisation) | type String
     * @return = type BigDecimal
     */
    public static BigDecimal calculeComptable(String principal, String rate, int periode, String contribution) {
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)).pow(periode); // (1 + r) ^ Y
        BigDecimal b = a.subtract(BigDecimal.ONE); // ((1 + r) ^ Y) -1
        /*MathContext mc = new MathContext(2, RoundingMode.HALF_UP);*/ // il n'a pas utilisé MathContext en 2em arg de la methode divide() attend de voire si le programme plante sans avant
        BigDecimal c = b.divide(new BigDecimal(rate)); // (((1 + r) ^ Y) -1) / r
        BigDecimal d = c.multiply(new BigDecimal(contribution)); // c*[(((1 + r) ^ Y) -1) / r]
        BigDecimal e = a.multiply(new BigDecimal(principal)); // P*((1 + r) ^ Y)
        BigDecimal f = d.add(e); // P*((1 + r) ^ Y) + c*[(((1 + r) ^ Y) -1) / r]
        return f;
    }

    public static void main(String[] args) {

        System.out.println(calculeComptable("10000.00", ".08", 10, "1000"));
    }
}

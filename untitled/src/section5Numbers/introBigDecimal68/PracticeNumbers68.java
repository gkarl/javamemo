package section5Numbers.introBigDecimal68;

import java.math.BigDecimal;

/**
 * Section 5 - 68 Introducing BigDecimal
 *
 * BigDecimal Permet de faire des opérations avec les nbre a virgule plus précis
 * EX on l'utilise pour les calcule monétaires et certains calcule scientifique suivant le niveau de précision désiré
 *
 * Préférer utiliser les opérations avecles types primitifs (float, double) lorsque vous savez que vous pouvez vous en sortir avec
 */
class PracticeNumbers68 {

    public static void main(String[] args) {

        float numC = 2.15f;
        float numD = 1.10f;

        //_______________Methode1________________
        System.out.println(numC - numD);  // cette methode qui utilise des float ou des double on avait une approximation aprés opération

        //_______________Methode2________________
        BigDecimal numE = new BigDecimal("2.15");  // BigDecimal => class évite approximation mettre arg en String pour max précision | A utiliser pour les calcule monétaire
        BigDecimal numF = new BigDecimal("1.10");
        System.out.println(numE.subtract(numF));  // substract() => Une dès méthodes de la class BigDecimal pour gérer les opérations mathématiques = soustraction

    }
}

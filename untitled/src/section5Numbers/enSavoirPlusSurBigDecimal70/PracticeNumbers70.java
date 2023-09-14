package section5Numbers.enSavoirPlusSurBigDecimal70;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Section 5 - 70 En savoir plus sur BigDecimal et BigInteger
 *
 * Alternatives pour instancier BigDecimal avec des primitifs
 * Préférerez ne pas utiliser dans la plupart des cas car perd en précision de calcule
 *
 * Cast un BigDecimal :
 * - byteValue() => convertit un BigDecimal en type byte
 * - doubleValue() => convertit un BigDecimal en type double
 * - floatValue() => convertit un BigDecimal en type float
 * - intValue() => convertit un BigDecimal en type int
 * - toString() => convertit un BigDecimal en type String
 *
 * RQ quand IDE travail avec BigDecimal il convertit ce nbre tout de suite en BigInteger EX 3.141592 => 3141592
 * l'IDE a compté le nbre de fois qu'il a du déplacer la virgule vers la droite pour en faire un nbre entier
 * Permet de faire des calculs sur des nbre entier et non décimal => plus grande précision moins d'arrondis
 * Il le remet en BiGdecimal avec la virgule à la fin des calculs
 */
class PracticeNumbers70 {

    public static void main(String[] args) {

        BigDecimal num0 = new BigDecimal(3.141592f); // On peut instancier BigDecimal avec un type primitif EX float | PB perd tout de suite en précision car IDE commence à stocker arg comme un float => approximation

        BigDecimal num1 = new BigDecimal("2.15");

        byte b = num1.byteValue(); // byteValue() => convertit un BigDecimal en type byte
        String myString = num1.toString(); // toString() => convertit un BigDecimal en type String

        BigInteger num2 = new BigInteger("123456789"); // marche à peut pret de la meme façon que BigDecimal

    }
}

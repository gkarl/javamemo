package section5Numbers.floatingPointNumbers60;

/**
 * Section 5 - 60 Floating Point Numbers
 *
 * float => 32 bites = 4 Bytes (octets) => [-2 147 483 648 à 2 147 483 648] milliards
 *
 * - Le dernier bite indique le signe + ou -
 * - 8 bites pour le chiffre avant la virgule
 * - 23 bite pour chiffre apres la virgule
 *
 * double => 64 bites = 8 Bytes (octets) = [-9 223 372 036 854 775 807 à  9 223 372 036 854 775 807]
 *
 * apres la virgule le cal cule des bite est différent =>
 * EX approximation de 0.141592 en binaire
 *
 * 1/2   1/4   1/8   1/16   1/32    1/64    1/128   1/256    1/512      1/1024          (Valeur de la cases)
 *
 *            0.125                0.016625                             0.000976        (Total Approximation aprés addition = 0.141601562)
 *
 *              1     0      0       1        0      0         0            1
 */
class PracticeNumbers60 {

    public static void main(String[] args) {

        double num1 = 2.15; // par défault les nbre à virgule sont des double en java

        float num2 = 2.10f; // On doit rajouter f ou F pour que l'IDE comprenne qu'il s'agit d'un nbre float et pas double

        float num3 = 2.10F;

        System.out.println(num2 - num3); // Dans tous les cas on n'obtient une approximation
    }
}

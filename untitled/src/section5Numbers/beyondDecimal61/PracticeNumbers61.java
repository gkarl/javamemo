package section5Numbers.beyondDecimal61;

/**
 * Section 5 - 61 Beyond Decimal
 *
 * ________________Table des OR_________________________
 *  1   0   0   1
 *  1   0   1   0
 *  _______________
 *  1   0   1   1
 *
 *
 * ________________Table des AND_________________________
 *  1   0   0   1
 *  1   0   1   0
 *  _______________
 *  1   0   0   0
 *
 * Exemple utilisation Hexadecimal (binaire) en informatique
 *
 * ________________________Exemple 1______________________________
 *
 * Pattern pat = Pattern.compile(regex, Pattern.COMMENTS | Pattern.DOTALL);  // Chaque flag à une valeur Hexadécimal qui correspondant à une valeur décimal allant de 1 - 2 - 4 - 8 - 16 - 32 - 64 - 128 compatible avec Binaire | => OR les sépare
 *
 * 8    7    6    5    4    3    2    1   (Numero de la case)
 * 128  64   32   16   8    4    2    1   (Valeur de la case)
 *
 *                               0    1     = 1 (Ex flag1 avec cette valeur)
 *                                        OR
 *                          1    0    1     = 5 (Ex flag2 avec cette valeur)
 *                                        OR
 *                     1    0    0    0     = 8 (Ex flag3 avec cette valeur)
 *                     ____________________
 *                     1    1    0    1      Total
 *                                       AND
 *                     1    0    0    0      Bit Mask => permet de vérifier si un flag est on/off 0 ou 1 | Ex la il teste si le flag qui porte la valeur 8 (case 4) est activé | ... le bit mask va tester chaque flag pour connaitre son état
 *                     ____________________
 *                     1    0    0    0      Total Résultat ce flag(8 case 4) est activé
 *
 *
 * ________________________Exemple 2______________________________
 *
 * Addresse IP
 *
 * EX1 192.168.1.1  // Chaque nbre entre les points sont des Bytes (octet)
 *
 * on prend une addresse IP simple pour l'exemple

 *
 * 8    7    6    5    4    3    2    1   (Numero de la case)
 * 128  64   32   16   8    4    2    1   (Valeur de la case)
 *
 *                          1    0    1    =  5
 *
 *                          0    1    1    =  3
 *
 *
 *            Network Address | Host Address
 *
 *  EX2 5.5.5.3  => 0101 0101 0101 0011
 *
 *                  1111 1111 0000 0000  => Network mask nous sert à savoir quelle partie de IP address correspond à Network Address (adresse réseau) et quelle partie correspond à Host Address (address de l'hote = ordi)
 *
 *
 */
class PracticeNumbers61 {

    public static void main(String[] args) {

        byte anotherByte1 = 45;
        byte anotherByte2 = 0x1f; // type byte peut prendre hexadecimal | hexadecimal commence toujours par 0x
        int anotherInt1 = 0x1f; // type int peut prendre hexadecimal | hexadecimal commence toujours par 0x
        int anotherInt2 = 0b01010101; // type int peut prendre un nbre binaire | binaire commence toujours par 0b
        int anotherInt3 = 0b100 | 0b10 | 0b01 ; // 4 OR 2 OR 1 = 4 + 2 + 1 = 7
        System.out.println(anotherInt3 & 8); // & = AND => 8 (case 4 binaire) n'est pas activé => résultat 0 car ça fait une sorte de Bit Mask pour check si la case 4 (valeur 8) est a 1 ou 0



    }
}

package section5Numbers.numericDataType58;

/**
 * Section 5 -58 Numeric Data Types
 *
 * Nous voulons utiliser le plus petit type de données possible pour optimiser la mémoire de l'ordinateur.
 * 8 Giga de RAM = 8 milliards (billion) de Bytes (octet)
 * 1024 Bytes (octets) = 1 Kilo Byte
 *
 * - Bollean  => true ou false il requiére que 1 bite (0 ou 1)
 *
 * - Byte => nbre compris entre [-128 ... 127] ou 255 (si on n'utilise pas de valeur négative), utilise 1 seul Byte (octet)
 *
 * 8    7    6    5    4    3    2    1   (Numero de la case)
 * 128  64   32   16   8    4    2    1   (Valeur de la case => le dernier bite, le max (ex128) est souvent utilisé pour donner valeur négative)
 *
 * - Short => nbre compris entre [-32 768, ..., 32 767] utilise 2 Bytes (octets)
 *
 * - Char => utilise 2 Bytes (octets) pas de valeur négative
 *
 */
class PracticeNumbers58 {

    public static void main(String[] args) {

        byte myByte = 13;
        boolean myFlag = true;
    }
}

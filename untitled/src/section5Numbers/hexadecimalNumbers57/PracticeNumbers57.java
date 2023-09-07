package section5Numbers.hexadecimalNumbers57;

/**
 * Section 5 -5 Hexadecimal Numbers
 *
 * Féxadecimal système numérique très pratique qui nous permet de compresser base dix et nombres binaires
 * les nombres hexadécimaux s'alignent très bien avec les Bytes (octets) en le décomposant en 2 groupe de 4 bites
 *
 * 0   1   3   4   5   6   7   8   9   10   11   12   13   14   15  (Décimal = Base 10)
 *
 * 0   1   3   4   5   6   7   8   9   A    B    C    D    E    F   (Héxadécimal  = Base 16)
 *
 *
 * ________________________Exemple__________________________________
 *
 * 8   4   2   1  |  8   4   2   1  |  8   4   2   1  |   (Valeur de la case si on découpe en lot de 4 bites)
 *
 *         1   1  |  1   1   1   0  |  1   0   0   0  |   (codage binaire => 3 | 16 | 8)
 *
 *          3     |        E       |         8        |   (encodage héxadécimal)
 *
 *
 * RQ si on essay de print une instance de class qui n'a pas @Override la methode toSTring()
 * - ça print le nom de la class
 * -  suivie par l'address de cette objet en mémoire ex @5acf9800 => nbre héxadécimal (façon plus condensé d'afficher un  nbre)
 *
 *
 *
 */
class PracticeNumbers57 {

}

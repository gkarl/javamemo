package section4RegularExpressions.ABCsOfRegularExpressionsPartOne44;

/**
 * Section 4 Regular Expressions - 44 ABCs of Regular Expressions: Part Two
 *
 * \\w => lettre ou nbre '_' inclus
 * \\n => nbre attendu
 * {x} => nbre de répétition (peut prendre une range mettre une virgule)
 * + => répétition 1 à infini
 * * => répétition 0 à infini
 * ? => répétition 0 à 1
 *
 */
class RegexPractice44 {

    public static void main(String[] args) {

        System.out.println("cat".matches("\\wat")); // \\w => n'importe quelle lettre ou chiffre à cette position

        System.out.println("4at".matches("\\dat")); // \\w => n'importe quelle chiffre exclusivement à cette position

        System.out.println("321-333-7652".matches("\\d{3}-\\d{3}-\\d{4}")); // {} => On peut indiquer le nbre de fois que ce nbre doit apparaitre | 3 nbres

        System.out.println("321.333-7652".matches("\\d{3}[-., ]\\d{3}[-., ]\\d{4}")); // [] => ce charactére ou ce character à cette postion | il peut y avoir - ou . ou , qui sépare les nbre

        System.out.println("321.333-7652".matches("\\d{3}[-.,\\s]\\d{3}[-.,\\s]\\d{4}")); // \\s => pour spécifier que c'est le charactere espace qui est attendu en séparation

        System.out.println("321.333-7652".matches("\\d{3}[-.,\\s]+\\d{3}[-.,\\s]+\\d{4}")); // + => pour spécifier qu'on peut avoir 1 ou infini charactére qui est attendu | concerne ici les character de séparation [-.,\\s]

        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}")); // * => pour spécifier qu'on peut avoir 0 ou infini charactére qui est attendu

        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}")); // ? => pour spécifier qu'on peut avoir 0 ou 1 charactére qui est attendu

        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}")); // {3,4} => pour spécifier qu'on attend 3 ou 4 chiffre | ici pour le dernier nbre du n°

        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,}")); // {3,} => pour spécifier qu'on attend 3 à infini de chiffre |

        System.out.println("321333.7652".matches("(\\d{3}[-.,\\s]?){2}\\d{3,}")); //  (Regex){2} => Utiliser 2 fois un meme pattern |

        System.out.println("321333.7652".matches("(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  (Regex){1,2} => Utiliser 1 ou 2 fois un pattern | on attend 1 fois ou 2 fois 3 chifre suivit d'un séparateur

        System.out.println("1.321333.7652".matches("(\\d[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  (Regex)? => ce chiffre optionnele devant le n° de tel

        System.out.println("1.321333.7652".matches("(1[-.,\\s]?)(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  il sur que le 1er chiffre devant le n° de tel est un 1
    }
}

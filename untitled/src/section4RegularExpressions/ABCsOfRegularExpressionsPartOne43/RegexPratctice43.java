package section4RegularExpressions.ABCsOfRegularExpressionsPartOne43;

/**
 * Section 4 Regular Expressions - 43 ABCs of Regular Expressions: Part One
 *
 * matches() => utilisé pour comparé 2 string avec des expressions reguliére sur la 2em
 *
 * [ ] => ce sera un des character dans ces crochet
 * [a-z] => de ce character à ce character est attendu
 * ^x  => exclus ce character
 *
 * Utilitaire web qui aide à la construction d'une regex
 * https://regex101.com/
 */
class RegexPratctice43 {

    public static void main(String[] args) {

        System.out.println("cat".matches("[cC]at")); // matches()  => compare 2 string return un boolean | [ ] => match un charactere ou un autre Charactére | tout ce qui contiend c ou C majuscule en 1ere lettre (à cette position)
        System.out.println("cat".matches("[a-fA-F]at")); // - => range de lettre | 1er lettre match toutes les lettre de A à F majuscule et minuscule
        System.out.println("cat".matches("[^c-f]at")); // ^ => excepté | exclus le match la 1ere lettre compris dans la range c à f
        System.out.println("fat".matches("[^c]at")); // la 1er lettre ne doit pas etre un c pour un match toutes les autres sont valide
    }
}

package section4RegularExpressions.additionalCharacterClasses50;

/**
 * Section 4 Regular Expressions - 50 Additional Character Classes
 *
 *
 */
class RegexPractice50 {

    public static void main(String[] args) {


        System.out.println("doggy".matches(".....")); // . => match n'importe quel character

        System.out.println("doggy".matches(".*")); // * => characters de [0 à inf]

        System.out.println("doggy".matches(".+")); // + => characters de [1 à inf]

        System.out.println("doggy".matches(".?")); // ? => characters de [0 à 1]

        System.out.println("doggy".matches("[^abcd]")); // [^abcd] => qui ne match pas a ou b ou c ou d (si ^ est dans des [])

        System.out.println("doggy".matches("^.....")); // ^ => désigne le tout debut d'une ligne ou d'un string juste avant la 1re lettre

        System.out.println("doggy".matches("^.....$")); // $ => designe la fin de la ligne

        System.out.println("cat doggy".matches("...\\s\\b.....")); // \\b => match l'espace entre 1 charatere de mot et un character d'espace | \\s => match un espace

        System.out.println("cat".matches("\\w\\w\\w")); // \\w => match n'importe quel lettres et nombre d'un string

        System.out.println("---".matches("\\W\\W\\W")); // \\W => match tout sauf lettres (ou nombre), match le tiret qui n'est pas considéré comme un character

        System.out.println("123".matches("\\d\\d\\d")); // \\d => match que des chiffres dans un string

        System.out.println("cat".matches("\\D\\D\\D")); // \\D => match tout sauf des chiffres, match des non chiffre

        System.out.println(" 1 ".matches("\\s\\d\\s")); // \\s => match un espace

        System.out.println(" 1&".matches("\\s\\d\\S")); // \\S => match ce qui n'est pas un espace
    }
}

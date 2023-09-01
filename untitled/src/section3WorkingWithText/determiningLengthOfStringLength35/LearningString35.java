package section3WorkingWithText.determiningLengthOfStringLength35;

/**
 *
 * Section 3 Working Whith Text - 35 Determining the Length of a String - length()
 *
 * Connaitre le nb de character d'1 string
 */
class LearningString35 {


    public static void main(String[] args) {


        String myText = "Bonjour";
        System.out.println(myText.length()); // lenght() => nous indique la longueur de la string en termes de caractères.

        //_______________Exemple1________________
        //  lenght() est souvent utilisé comme sécurité pour éviter de dépasser index max d'un String
        char[] ArrayOfChars = myText.toCharArray();  // découpe le String en char et le met dans un Array
        int index = 2;
        if (index < myText.length()) {  // empeche que le programme plante en dépassant l'index max du string
            System.out.println(ArrayOfChars[index]);  // affiche la 3em lettre présent dans de array
        }

        //_______________Exemple2________________
        // lenght() peut etre utiliser pour optimiser les perf de StringBuilder
        String myText2 = "Bonjourno";
        String stringBuilder2 = new StringBuilder(myText.length() + myText2.length())   // StringBuilder => Vous pouvez lui indiquer la taille de la string finale info pour allouer le juste espace en mémoire
                .append(myText)
                .append(" ")
                .append(myText2)
                .toString();
        System.out.println(stringBuilder2);

    }
}

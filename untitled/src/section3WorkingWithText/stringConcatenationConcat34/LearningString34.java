package section3WorkingWithText.stringConcatenationConcat34;

/**
 * Section 3 Working Whith Text - 34 String Concatenation - concat
 *
 * Combiner deux string
 */
class LearningString34 {

    public static void main(String[] args) {

        String text1 = "this my text 1";
        String text2 = "this my text 2";


        //______________Methode1____________________
        // PB Ne pas combiner plus de 3 string avec cette méthode gourmand en mémoire ordi
        System.out.println(text1 + " " + text2);

        //______________Methode2____________________
        // PB si on a besoin d'espace entre les 2 texte cette methode n'est pas la bonne
        System.out.println(text1.concat(" " + text2)); // concat() => cela va simplement combiner le texte1 avec le texte2

        //______________Methode3____________________
        String stringBuilder = new StringBuilder()   // StringBuilder => class qui permet de créer de longues string
                .append(text1)  // append() => méthode de la class permettre de combiner des string
                .append(" ") // moyen de rajouter un espace entre les string
                .append(text2)
                .toString();  // toString => convertir le type StringBuilder en type String
        System.out.println(stringBuilder);

        //______________Methode3 V2____________________
        // StringBuilder pocéde un 2em constructeur prend 1 input
        String stringBuilder2 = new StringBuilder(text1.length() + text2.length())   // StringBuilder => Vous pouvez lui indiquer la taille de la string finale info pour allouer le juste espace en mémoire
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
        System.out.println(stringBuilder2);

        //______________Methode4____________________
        // PB encontrer avec du code plus ancien => Buffer protège les threads  les une des autres => gourmand en ressource
        String stringBuffer = new StringBuffer() // StringBuffer => class identique à StringBuilder
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
        System.out.println(stringBuffer);

        //______________Methode5____________________
        System.out.format("%s %s \n", text1, text2); // autre façon de print avec concaténation
        String stringFormat = String.format("%s %s", text1, text2); // format() => peut etre stocké dans une variable
        System.out.println(stringFormat);
    }
}

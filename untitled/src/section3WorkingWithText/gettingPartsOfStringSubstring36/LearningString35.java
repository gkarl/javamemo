package section3WorkingWithText.gettingPartsOfStringSubstring36;

/**
 * Section 3 Working Whith Text - 36 Getting Parts of a String - substring
 *
 * select grace au index une partie d'un string pour lui appliquer une modif
 */
class LearningString35 {

    public static void main(String[] args) {

        String fruit2 = "apple";


        // EXO => Mettre la 1ere lettre du string en majuscule

        //_______________Version1_________________________
        // Utilise + pour concaténer lés 2 string défini par substring()
        System.out.println(fruit2.substring(0,1).toUpperCase() + fruit2.substring(1));  // substring() => recrée un string à partir d'un interval d'indexe

        //_______________Version2_________________________
        // Utilise concat() pour concaténer lés 2 string défini par substring()
        System.out.println(fruit2.substring(0,1).toUpperCase().concat(fruit2.substring(1)));

        //_______________Version3_________________________
        // Utilise StringBuilder pour concaténé lés 2 string défini par substring() + factorisation
        String firstLetter = fruit2.substring(0, 1).toUpperCase();
        String resteDesLettres = fruit2.substring(1);
        System.out.println(new StringBuilder(firstLetter).append(resteDesLettres));

        //_______________Version3V2_________________________
        // Utilise le 2em constructor de StringBuilder pour donner à l'instanciation la taille final du String concatené => améliore perf mémoire
        String firstLetter2 = fruit2.substring(0, 1).toUpperCase();
        String resteDesLettres2 = fruit2.substring(1);
        String texteEnMajuscule = new StringBuilder(firstLetter2.length() + resteDesLettres2.length())
                .append(firstLetter2)
                .append(resteDesLettres2)
                .toString();
        System.out.println(texteEnMajuscule);
    }
}

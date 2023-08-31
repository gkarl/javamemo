package section3WorkingWithText.ComparingStringOfAlphabeticalOrderCompareTo32;

/**
 * Section 3 Working Whith Text - 32 Comparing String for Alphabetical Order - compareTo()
 *
 * vous indiquer quelle string vient en premier dans ordre alphabétique.
 *
 * - le 1er mot ses 1er lettre sont placées avant le 2em mot => valeur négative
 * - le 1er mot ses 1er lettre sont identiques au 2em mot => valeur zero
 * - le 1er mot ses 1er lettre sont placées aprés le 2em mot => valeur positive
 */
class LearningString32 {

    public static void main(String[] args) {

        String firstWord = "Apple";
        String secondWord = "apple";
        System.out.println(firstWord.compareTo(secondWord));  // compareTo() => vous indiquer quelle string vient en premier dans ordre alphabétique.
        System.out.println(firstWord.compareToIgnoreCase(secondWord));  // compareToIgnoreCase() => Met dabors les 2 string en minuscule avant de vous indiquer quelle string vient en premier dans ordre alphabétique.

        //_________________________

        System.out.println(compareToIgnoreCaseV2(firstWord, secondWord));  // Utilise la methode qu'on a crée pour immiter compareToIgnoreCase()

    }

    public static int compareToIgnoreCaseV2(String text1, String text2) {
        String lowerText1 = text1.toLowerCase();
        String lowerText2 = text2.toLowerCase();
        return lowerText1.compareTo(lowerText2);
    }


}

package section3WorkingWithText.BeginingEndingOfStringStratsWithEndsWith39;

/**
 * Section 3 Working Whith Text - 39 Beginning & Ending of Strings - startsWith() & endsWith()
 *
 * startsWhith() | endsWhith() => permet de savoir si une string fini ou commence avec une string particuliere
 *
 * EX les utilisateurs à saisir un nom  fichier vous voulez vous assurer que le nom de fichier entré se termine par une extension .txt ...
 *
 */
class LearningString39 {

    public static void main(String[] args) {

        String fileName = "   myFile.txt";

        System.out.println(fileName.endsWith(".txt")); // endsWith() => vérifier si le string fini avec l'extension .txt

        System.out.println(fileName.strip().startsWith("myFile")); // statsWith()  => vérifier si le string commence avec le text "myFile" | strip() => permet de virer les espace qui pourrait etre devant et empecher la reconnaisance par statsWith()
    }
}

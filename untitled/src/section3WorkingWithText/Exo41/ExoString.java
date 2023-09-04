package section3WorkingWithText.Exo41;

import java.time.LocalDate;

public class ExoString {

    //4.
    public static String transformInputNoSpaceCapitalizeLastLetter(String inputUser) {
        String noSpaceText = inputUser.strip();
        int tailleText = noSpaceText.length();
        String capitalizeLastLetter = noSpaceText.substring(0, tailleText - 1) + noSpaceText.substring(tailleText - 1).toUpperCase();
        return capitalizeLastLetter;
    }

    public static void main(String[] args) {
        //1. Modéliser une personne avec un prénom et un nom de famille et s'assurer que même si le prénom est saisi en minuscules, il sera stocké en majuscules.
        Personne karl = new Personne("Karl", "Gavillot", LocalDate.of(1973, 02, 16));
        System.out.println(karl.getFirstName().toUpperCase());

        //2. Ecrivez un code qui remplace le mot "chat" par le mot "chien" partout où il apparaît dans une phrase
        String longTextAvecChien = """
                    Un jour le chien abouillait il recus un avocat sur le museau
                le chien fut tres suppris
                depuis ce chien ce mefie beaucoup avant d'aboyer
                """;
        System.out.println(longTextAvecChien.replace("chien", "chat"));

        //3. Comment pouvez-vous vous assurer que lorsque des personnes entrent du texte dans un programme, il n'y a pas d'espaces involontaires au début ou à la fin de la phrase ?
        //au début ou à la fin du texte ?
        System.out.println(longTextAvecChien.strip());

        //4. Si quelqu'un saisit "  alphabet  " (remarquez les espaces) comme entrée dans une méthode, faites en sorte que cette méthode produise "alphabeT" à la place.
        //méthode produise "alphabeT" à la place.
        String inputUser = "  alphabet  ";
        System.out.println(transformInputNoSpaceCapitalizeLastLetter(inputUser));


        //5. Étant donné la chaîne "12345 Big St., Alphabet City, CA 90210" ou toute autre adresse ayant le même format, pouvez-vous écrire un code capable d'analyser et d'imprimer : "12345 Big St.
        //pouvez-vous écrire un code capable d'analyser et d'imprimer :
        //1. Le numéro du bâtiment : 12345
        //2. La rue : "Big St."
        //3. La ville : "Alphabet City
        //4. État : "CA"
        //5. Code postal : 90210
        String addressPerson = "12345 Big St., Alphabet City, CA 90210";
        int indexFirstSpace = addressPerson.indexOf(" ");
        System.out.format("1. Le numéro de batiment : %s \n", addressPerson.substring(0, indexFirstSpace));
        int indexFirstComma = addressPerson.indexOf(",", indexFirstSpace);
        System.out.format("2. La rue : %s \n", addressPerson.substring(indexFirstSpace + 1, indexFirstComma));
        int indexSecondeComma = addressPerson.indexOf(",", indexFirstComma + 1);
        System.out.format("3. La ville : %s \n", addressPerson.substring(indexFirstComma + 1, indexSecondeComma));
        int indexSpaceAfterLastComma = addressPerson.indexOf(" ", indexSecondeComma);
        int indexDernierSpace = addressPerson.indexOf(" ", indexSecondeComma + 2);
        System.out.format("4. Etat : %s \n", addressPerson.substring(indexSpaceAfterLastComma + 1, indexDernierSpace));
        System.out.format("5. Postal Code : %s \n", addressPerson.substring(indexDernierSpace + 1));

    }

}

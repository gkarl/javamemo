package section3WorkingWithText.gettingIndividualCharactersOfStringCharAt31;

/**
 * Section 3 Working Whith Text - Getting Individual Characters of a String - charAt()
 *
 * recupérer 1 lettre d'1 string
 *
 * EX souvent on imprime que les initiale d'un prénom
 */
class LearningString31 {

    public static void main(String[] args) {

        String middleName = "Christopher";

        int length = middleName.length();

        if (length > 5) {  // charAt()  => crée une erreur si on dépasse l'index max du string pour l'éviter on met cette condition
            System.out.println(middleName.charAt(5)); // charAt() => nous renvoie simplement le caractère vers lequel nous pointons avec un index
        }

    }
}

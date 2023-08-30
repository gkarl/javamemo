package section3WorkingWithText.removingWhiteSpaceStrip30;

/**
 *  Section 3 Working Whith Text - 30 Removing White Space - strip()
 *
 *  vire les espaces d'un string debut et fin
 *
 *  EX Vous voulez que vos datas soit normalisé sans espace incorrect
 *  EX Espace pourrais affecter nos comparaisons de string plutard
 */
class LeranString30 {

    public static void main(String[] args) {

        String pierre = " Pierre ";
        System.out.format(" '%s' ", pierre.strip()); //strip()  => vire les espace en debut et fin du string
        System.out.format(" '%s' ", pierre.trim()); //trim()  => idem mais plus ancien ne marche pas avec toutes les langues
        System.out.format(" '%s' ", pierre.stripLeading()); //stripLeading()  =>  vire les espace en debut du string
        System.out.format(" '%s' ", pierre.stripTrailing()); //stripTrailing() => vire les espace en fin du string


        String text1 =  "Bonjour les amies" +
                "       toi je te trouve trop bonne" +
                "       ça te dirait de venir faire un calin ce soir? \n";


        String text2 = """
                        Bonjour les amies
                            toi je te trouve trop bonne
                                ça te dirait de venir faire un calin ce soir?
                """;
        System.out.format("%s", text2.stripIndent());  // stripIndent()  => permet à tout le bloc de texte d'aller aussi loin vers la gauche possible tout en conservant tous les espaces correct
    }

    //RQ On peut faire la meme chose que strip() avec un replace()
    public static String split(String text) {
        return text.replace(" ", "");
    }
}

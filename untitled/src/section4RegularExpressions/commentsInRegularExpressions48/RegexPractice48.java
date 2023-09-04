package section4RegularExpressions.commentsInRegularExpressions48;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 48  Comments in Regular Expressions
 *
 * Ex Suite afficher élément d'un n° de tel séparément grace à Regex
 * En rajoutant des commentaire dans notre Regex pour etre encore plus explicité sur ce que fait tel ou tel partie de la Regex
 *
 * # => permet de rajouté des commentaire à notre Regex (marche uniquement si le flag Pattern.COMMENTS est activé)
 */
class RegexPractice48 {

    public static void main(String[] args) {

        String regex = """
                # Regex to compare phone number pattern  //** # => Commentaire ajouté à notre Regex
                (?:(?<countryCode>\\d{1,2})[-.,\\s]?) # Get Country code
                (?:(?<areaCode>\\d{3})[-.,\\s]?) # Get Area code
                (?:(?<exchange>\\d{3})[-.,\\s]?) # Get Exchange
                (?<lineNumber>\\d{3,4}) # Get Line number
                """;
        String phoneNumber = "12.321.333.7652";
        //System.out.println("1.321333.7652".matches(regex));

        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS); //** Pattern.COMMENTS => flag on permet d'ajouté des commentaires à notre Regex | ATTENTION ne suporte pas les espaces dans Regex => run pour tester avant d'ajouter des commentaires
        Matcher mat = pat.matcher(phoneNumber); // Matcher => class qui fait le match | on crée le Matcher depuis le Pattern  | matcher() => prend en arg le string avec lequel on veut check le match avec le Pattern

        if (mat.matches()) {  // matches() => Test si n° tel (string) match avec Regex => true ou false
            System.out.format("Country code: %s\n",mat.group("countryCode")); //** le nom qu'on a défini pour le capture groupe peut remplacer son index pour etre print()
            System.out.format("Area code: %s\n",mat.group("areaCode"));
            System.out.format("Exchange: %s\n",mat.group("exchange"));
            System.out.format("Line number: %s\n",mat.group("lineNumber"));
        }
    }
}

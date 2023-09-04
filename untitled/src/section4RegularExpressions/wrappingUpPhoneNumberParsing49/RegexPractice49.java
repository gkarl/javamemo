package section4RegularExpressions.wrappingUpPhoneNumberParsing49;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 49 Wrapping Up Phone Number Parsing
 *
 * Ex Suite afficher élément d'un n° de tel séparément grace à Regex
 * il veux que ça marche si on met ou non des parenthése sur le 1er chiffre
 *
 * \\(  => met antislash pour utiliser la parenthése comme un charactére normale et pas un spécial character Regex
 *
 */
class RegexPractice49 {

    public static void main(String[] args) {

        String regex = """
                # Regex to compare phone number pattern
                (?:(?<countryCode>\\d{1,2})[-.,\\s]?)? # Get Country code
                (?:\\(?(?<areaCode>[(]?\\d{3})\\)?[-.,)\\s]?) # Get Area code //** (  => utiliser des anti slash pour ne pas utiliser les parenthèses comme caractère spécial propre à Regex mais simplement comme un charactere
                (?:(?<exchange>\\d{3})[-.,\\s]?) # Get Exchange
                (?<lineNumber>\\d{3,4}) # Get Line number
                """;
        String phoneNumber = "12.321.333.7652";
        //System.out.println("1.321333.7652".matches(regex));

        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS); //
        Matcher mat = pat.matcher(phoneNumber); // Matcher => class qui fait le match | on crée le Matcher depuis le Pattern  | matcher() => prend en arg le string avec lequel on veut check le match avec le Pattern

        if (mat.matches()) {  // matches() => Test si n° tel (string) match avec Regex => true ou false
            System.out.format("Country code: %s\n",mat.group("countryCode"));
            System.out.format("Area code: %s\n",mat.group("areaCode"));
            System.out.format("Exchange: %s\n",mat.group("exchange"));
            System.out.format("Line number: %s\n",mat.group("lineNumber"));
        }

    }
}

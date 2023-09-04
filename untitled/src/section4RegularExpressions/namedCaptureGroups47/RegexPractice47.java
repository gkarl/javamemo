package section4RegularExpressions.namedCaptureGroups47;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 47 Named Capture Groups
 *
 *
 * Ex Suite afficher élément d'un n° de tel séparément grace à Regex non par leur index mais le nom qu'on leur donne
 *
 * ?: => placé juste dérriére '(' permet d'ignoré un capture groupe ( ) cela affectera l'index des autres
 * ?<nom du capture groupe>  => placé juste dérriére '(' permet plutot que d'utiliser l'index du capture group pour le print() utiliser le nom qu'on appelera entre " "
 */
class RegexPractice47 {

    public static void main(String[] args) {


        String regex = "(?:(?<countryCode>\\d{1,2})[-.,\\s]?)(?:(?<areaCode>\\d{3})[-.,\\s]?)(?:(?<exchange>\\d{3})[-.,\\s]?)(?<lineNumber>\\d{3,4})"; //** ?: => ignoré un capture groupe ( ) cela affectera l'index général | ?:<nom du capture groupe> utilisé à la place de index permet d'étre plus explicite
        String phoneNumber = "12.321.333.7652";
        //System.out.println("1.321333.7652".matches(regex));

        Pattern pat = Pattern.compile(regex); // Pattern => est une class qui va etre utiliser comme type pour une variable qui va contenir une Regex || compile()  => IDE besoin de compiler Regex comme un programme pour etre interprété par ordi
        Matcher mat = pat.matcher(phoneNumber); // Matcher => class qui fait le match | on crée le Matcher depuis le Pattern  | matcher() => prend en arg le string avec lequel on veut check le match avec le Pattern

        if (mat.matches()) {  // matches() => Test si n° tel (string) match avec Regex => true ou false
            System.out.format("Country code: %s\n",mat.group("countryCode")); //** le nom qu'on a défini pour le capture groupe peut remplacer son index pour etre print()
            System.out.format("Area code: %s\n",mat.group("areaCode"));
            System.out.format("Exchange: %s\n",mat.group("exchange"));
            System.out.format("Line number: %s\n",mat.group("lineNumber"));
        }

    }
}

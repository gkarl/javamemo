package section4RegularExpressions.captureGroupsPartOne45;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 45 Capture Groups: Part One
 *
 * Ex afficher élément d'un n° de tel séparément grace à Regex
 */
class RegexPractice45 {

    public static void main(String[] args) {


        String regex = "(1[-.,\\s]?)(\\d{3}[-.,\\s]?)(\\d{3}[-.,\\s]?)(\\d{3,4})";
        String phoneNumber = "1.321.333.7652";
        //System.out.println("1.321333.7652".matches(regex));

        Pattern pat = Pattern.compile(regex); // Pattern => est une class qui va etre utiliser comme type pour une variable qui va contenir une Regex || compile()  => IDE besoin de compiler Regex comme un programme pour etre interprété par ordi
        Matcher mat = pat.matcher(phoneNumber); // Matcher => class qui fait le match | on crée le Matcher depuis le Pattern  | matcher() => prend en arg le string avec lequel on veut check le match avec le Pattern

        if (mat.matches()) {  // matches() => Test si n° tel (string) match avec Regex => true ou false
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));  // group() => chaque groupe ( ) dans Regex s'appel Capture Group qui peut etre appelé par son index (l'index commence par 1) via cette méthode
            System.out.println(mat.group(3));  // | si on a un capture groupe ( ) suivit par un répéteur de Pattern {2} group() n'affichera que la derniére répétion
            System.out.println(mat.group(4));
        }

    }
}

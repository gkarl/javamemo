package section4RegularExpressions.captureGroupsPartTwo46;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 46 Capture Groups: Part Two
 *
 * Ex Suite afficher élément d'un n° de tel séparément grace à Regex en éliminent les séparateurs '.'
 * => juste rajoute des capture groupe () imbriqué et print le bonne index
 *
 * */
class RegexPractice46 {

    public static void main(String[] args) {

        String regex = "((\\d{1,2})[-.,\\s]?)((\\d{3})[-.,\\s]?)((\\d{3})[-.,\\s]?)(\\d{4})";  //** rajoute des ( ) à l'interieur des cature groupe ( ) pour ne contenir que les nombres pas les séparateurs [-.,\s]?  | le 1er capture groupe ( ) aura index 1 celui à l'interieur de lui index 2  ...
        String phoneNumber = "12.321.333.7652";
        //System.out.println("1.321333.7652".matches(regex));

        Pattern pat = Pattern.compile(regex); // Pattern => est une class qui va etre utiliser comme type pour une variable qui va contenir une Regex || compile()  => IDE besoin de compiler Regex comme un programme pour etre interprété par ordi
        Matcher mat = pat.matcher(phoneNumber); // Matcher => class qui fait le match | on crée le Matcher depuis le Pattern  | matcher() => prend en arg le string avec lequel on veut check le match avec le Pattern

        if (mat.matches()) {  // matches() => Test si n° tel (string) match avec Regex => true ou false
            System.out.format("Country code: %s\n",mat.group(2));
            System.out.format("Area code: %s\n",mat.group(4));
            System.out.format("Exchange: %s\n",mat.group(6));
            System.out.format("Line number: %s\n",mat.group(7));
        }

    }
}

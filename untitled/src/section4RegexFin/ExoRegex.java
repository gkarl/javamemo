package section4RegexFin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExoRegex {

    public static void main(String[] args) {

        System.out.println("EXO 1 *********************");
        // Exo 1. Écrivez une regex qui correspondrait aux mots suivants : Dark, bark, Lark Pour un défi supplémentaire, pourriez-vous en plus faire correspondre : stark
        String words = """
               Dark, bark, Lark, stark
               """;
        String regex = "(?<word1>\\w+)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(words);
        mat.find();
        System.out.println(mat.group("word1"));
        mat.find();
        System.out.println(mat.group("word1"));
        mat.find();
        System.out.println(mat.group("word1"));
        mat.find();
        System.out.println(mat.group("word1"));


        System.out.println("EXO 2 *********************");
        // Exo 2. Utilisez les groupes de capture pour écrire une expression rationnelle qui pourrait correspondre aux mots suivants : Abracadabra ou Agracadagra : Abracadabra ou Agracadagra
        String words2 = """
                 Abracadabra, Agracadagra
                """;
        String regex1 = "(?<word2>\\w+)";
        Pattern pat1 = Pattern.compile(regex1);
        Matcher mat1 = pat1.matcher(words2);
        mat1.find();
        System.out.println(mat1.group("word2"));
        mat1.find();
        System.out.println(mat1.group("word2"));


        System.out.println("EXO 3 *********************");
        // Exo 3. Comment utiliser des parenthèses dans une expression rationnelle pour regrouper mais sans capturer ?
        //solution :? derriere (
        System.out.println("(?:");


        System.out.println("EXO 4 *********************");
        // Exo 4. Ecrivez une regex qui teste si une chaîne est une adresse et vous permet d'en extraire les parties
        String address = "226 boulevard Jean-Jaures 92100 Boulogne";

        String regex2 = """
                        (?:(?<numero>\\d{2,3})\\s*)?.*?
                        (?:(?<type>\\w+)\\s*)?.*?
                        (?:(?<nomRue>\\w+)\\s*)?.*?
                        (?:(?<zip>\\d{4,5})\\s*)?
                        (?:(?<ville>\\w+))?
                        """;
        Pattern pat2 = Pattern.compile(regex2,Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat2 = pat2.matcher(address);
        if (mat2.matches()) {
            System.out.format("Numéro de rue : %s \n",mat2.group("numero"));
            System.out.format("Type de rue: %s \n",mat2.group("type"));
            System.out.format("Nom de rue: %s \n", mat2.group("nomRue"));
            System.out.format("Département: %s \n", mat2.group("zip"));
            System.out.format("Ville: %s \n", mat2.group("ville"));
        }


        System.out.println("EXO 5 *********************");
        // Exo 5.  Ecrivez une regex qui teste si une chaîne est une adresse e-mail.
        //1. Note : Faire ceci en regex est en fait notoirement difficile pour se conformer à TOUTES les façons dont une adresse email peut être écrite.
        //d'une adresse email. Cependant, vous pouvez utiliser la forme la plus simple d'adresse email
        //la plus simple à laquelle vous pouvez penser, telle que : first.last@domain.com

        String addressMail = "first-last@domain.com";

        String regex3 = """
               (?<base>[\\d\\w\\.\\-]+)
               @(?<domain>[\\d\\w]+)
               \\.(?<extension>[\\w]+)
        """;
        Pattern pat3 = Pattern.compile(regex3, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat3 = pat3.matcher(addressMail);
        if (mat3.matches()) {
            System.out.println(mat3.group("base"));
            System.out.println(mat3.group("domain"));
            System.out.println(mat3.group("extension"));

        }

    }
}

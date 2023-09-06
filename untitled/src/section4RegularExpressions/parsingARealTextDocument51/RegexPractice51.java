package section4RegularExpressions.parsingARealTextDocument51;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 51 Parsing a Real Text Document
 *
 * EX pour récupérer des données qui sont dans un fichier text pour les print
 * ou plus tard les enregistrer dans une base de données et pouvoir manipuler les datas
 *
 * ______________Regex Ligne 1________________________
 *
 * - \\d{10} => représente 10 chiffres exactement
 * - ( ) => on veut capturer ça donc il le met entre parenthése
 * - ?<Nom du capture groupe> => il est fan d'utilider des captures groupe pour les appeler pour print aprés
 * - .* => 0 ou infini charactere = juste on ne s'intersse pas aux autres characters (on a besoin de rajouter ça pour que ça match)
 *   PB le . ne match certain characters => pas les \n (retour à la ligne) et \r (tabulation)  => notre regex ne match pas le string
 *   SOLUTION mais on peut changer ça en changer le mode sur lequel notre Regex run
 * - Pattern.DOTALL => changer le mode de lecture =  autorise les point . de match pas seulement n'importe quel character mais aussi \n \r
 * \\s => espace explicite entre les mots qu'il a écrit en dure car il pense qu'il ne changeront jamais
 *
 * ______________Regex Ligne 2________________________
 *
 * -  \\s+ => 1 ou inf space => utiliser pour les espaces entre Grade: et la valeur plus loin
 * -  ( ) => on a un capture groupe sur la valeur qu'on souhaite récupérer et print
 * -  \\d{1,2} => match si 1 ou 2 chiffre
 * -  ?<Nom du capture groupe> => il est fan d'utilider des captures groupe pour les appeler pour print aprés
 *
 * ______________Regex Ligne 3________________________
 *
 * - ( ) => on a un capture groupe sur la valeur qu'on souhaite récupérer et print
 * - ?<Nom du capture groupe> => il est fan d'utilider des captures groupe pour les appeler pour print aprés X 3
 * - \\d{4} => 4 chiffre pour l'année se sera toujours 4
 * - \\d{2} = 2 pour jour et 2 pour moi
 * - '#'  => rajoute un commentaire pour la ligne du Regex
 * RQ aux États-Unis, les dates standard commencent généralement par le mois, puis le jour du mois puis l'année.
 *
 * ______________Regex Ligne 4________________________
 *
 * - \\w => c'est une lettre
 * - '+' => 1 ou inf de characters
 * - \\b => Word boudery la fin du mot ou du character
 *   Rq il pourrait mettre plain d'espace mais il pourrait y avoir \n ou \r il préfére assurer
 * - .* => peu importe ce qui vient ensuite
 *
 * ______________Regex Ligne 5________________________
 *
 *- ( ) => on a un capture groupe sur la valeur qu'on souhaite récupérer et print
 * - ?<Nom du capture groupe> => il est fan d'utilider des captures groupe pour les appeler pour print aprés
 * - \\s+ => 1 ou inf space => utiliser pour les espaces entre Grade: et la valeur plus loin
 *
 *  ______________Regex Ligne 6________________________
 *
 *  - \d+ => chiffre si on est pas sur du nbre d'élément
 * - \\) => on veut litéralement une parenthese pas un group
 *   RQ \\. => on veut literalement un point pas un infini
 * - [\\d\\.] => un chiffre ou 1 point
 * - '+' => 1 ou plus
 *
 * ______________Regex Ligne 7________________________
 *
 * idem à ligne 6
 */
class RegexPractice51 {

    public static void main(String[] args) {

        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        String regex = """
            Student\\sNumber:\\s(?<studentNumber>\\d{10}).*  # Get Student Number
            Grade:\\s+(?<grade>\\d{1,2}).*  # Get Grade
            Birthdate:\\s+(?<dayBirth>\\d{2})/(?<monthBirth>\\d{2})/(?<yearBirth>\\d{4}).*  # Get Birthdate
            Gender:\\s+(?<gender>\\w+)\\b.*  # Get Gender
            State\\sID:\\s+(?<stateId>\\d+)\\b.*?  # Get State ID
            Weighted\\)\\s+(?<cumulativeGpa>[\\d\\.]+)\\b.*  # Get Cumulative GPA  Weighted
            Unweighted\\)\\s+(?<cumulativeGpa2>[\\d\\.]+)\\b.*  # Get Cumulative GPA Unweighted
            """;
        Pattern pat6 = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS); // pour prendre en compte les point litteral | pouvoir rajouter des commentaires #
        Matcher mat6 = pat6.matcher(transcript);
        if (mat6.matches()) {
            System.out.println(mat6.group("studentNumber"));
            System.out.println(mat6.group("grade"));
            System.out.println(mat6.group("dayBirth"));
            System.out.println(mat6.group("monthBirth"));
            System.out.println(mat6.group("yearBirth"));
            System.out.println(mat6.group("gender"));
            System.out.println(mat6.group("stateId"));
            System.out.println(mat6.group("cumulativeGpa"));
            System.out.println(mat6.group("cumulativeGpa2"));
        }

    }
}

package section4RegularExpressions.greedyOperators52;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 4 Regular Expressions - 52 Greedy Operators
 *
 * .* => Gourmand le moteur va jusqu'à la fin du text string et par de la pour chercher la suite de la Regex à matcher
 * Qd on a notre Regex qui cherche des matchs sur des mots identiques => PB
 *
 * SOLUTION
 * .*? => dit au moteur de Regex de ne pas se positionner à la fin du text à analyser mais recherche juste le match suivant
 */
class RegexPractice52 {

    public static void main(String[] args) {


        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;
        String regex6 = """
            Student\\sNumber:\\s(?<studentNumber>\\d{10}).*  # Get Student Number
            Grade:\\s+(?<grade>\\d{1,2}).*  # Get Grade
            Birthdate:\\s+(?<dayBirth>\\d{2})/(?<monthBirth>\\d{2})/(?<yearBirth>\\d{4}).*  # Get Birthdate
            Gender:\\s+(?<gender>\\w+)\\b.*  # Get Gender
            State\\sID:\\s+(?<stateId>\\d+)\\b.*?  # Get State ID
            
            Cumulative.*?(?<cumulativeGpa3>[\\d\\.]+)\\b.*?  # Get Cumulative GPA # Lesson 52 // il ne base plus sa recherche sur Weighted ou Unweighted mais un mot présent sur 2 lignes => PB
            Cumulative.*?(?<cumulativeGpa4>[\\d\\.]+)\\b.*   # Remplace .* (cherche un match de puis la fin du texte) => .*? (cherche le prochain match dans le texte)
            #_______________________Commenté________________________________________
            #Weighted\\)\\s+(?<cumulativeGpa>[\\d\\.]+)\\b.*  # Get Cumulative GPA  Lesson 51
            #Unweighted\\)\\s+(?<cumulativeGpa2>[\\d\\.]+)\\b.*  # Get Cumulative GPA
            """;
        Pattern pat6 = Pattern.compile(regex6, Pattern.DOTALL | Pattern.COMMENTS); // pour prendre en compte les point litteral | pouvoir rajouter des commentaires #
        Matcher mat6 = pat6.matcher(transcript);
        if (mat6.matches()) {
            System.out.println(mat6.group("studentNumber"));
            System.out.println(mat6.group("grade"));
            System.out.println(mat6.group("dayBirth"));
            System.out.println(mat6.group("monthBirth"));
            System.out.println(mat6.group("yearBirth"));
            System.out.println(mat6.group("gender"));
            System.out.println(mat6.group("stateId"));
/*            System.out.println(mat6.group("cumulativeGpa"));
            System.out.println(mat6.group("cumulativeGpa2"));*/
            System.out.println(mat6.group("cumulativeGpa3"));
            System.out.println(mat6.group("cumulativeGpa4"));
        }
    }
}

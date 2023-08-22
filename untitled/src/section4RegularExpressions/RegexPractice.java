package section4RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static void main(String[] args) {

        // Lesson 43 matches() => utilisé pour comparé 2 string avec des expressions reguliére
        System.out.println("cat".matches("[cC]at")); // [xy] => tout ce qui contiend ça ou ça à cette position
        System.out.println("cat".matches("[a-fA-F]at")); // [x-y] => dans cette range à cette position | contiend a jusqu'a f minuscule et majuscule
        System.out.println("cat".matches("[^c-f]at")); // [^x-y] => excepté cette range de charactere à cette position
        System.out.println("fat".matches("[^c]at")); //[^x] => excepté ce charactere à cette position

        System.out.println("*************** Lesson 44");
        // Lesson 44 matches() => ...
        System.out.println("cat".matches("\\wat")); // \\w => n'importe quelle lettre ou chiffre à cette position
        System.out.println("4at".matches("\\dat")); // \\w => n'importe quelle chiffre exclusivement à cette position
        System.out.println("321-333-7652".matches("\\d{3}-\\d{3}-\\d{4}")); // {} => On peut utiliser indiquer le nbre de fois que ce charactere doit apparaitre
        System.out.println("321.333-7652".matches("\\d{3}[-., ]\\d{3}[-., ]\\d{4}")); // [] => On peut quel charactere de séparation peut apparaitre soit soit
        System.out.println("321.333-7652".matches("\\d{3}[-.,\\s]\\d{3}[-.,\\s]\\d{4}")); // \\s => pour spécifier que c'est le charactere espace qui est attendu en séparation
        System.out.println("321.333-7652".matches("\\d{3}[-.,\\s]+\\d{3}[-.,\\s]+\\d{4}")); // + => pour spécifier qu'on peut avoir 1 ou infini charactére qui est attendu en séparation
        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}")); // * => pour spécifier qu'on peut avoir 0 ou infini charactére qui est attendu en séparation
        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}")); // ? => pour spécifier qu'on peut avoir 0 ou 1 charactére qui est attendu en séparation
        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}")); // {3,4} => pour spécifier qu'on attend 3 ou 4 chiffre apres le dernier séparateur
        System.out.println("321333.7652".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,}")); // {3,} => pour spécifier qu'on attend 3 ou infini chiffre apres le dernier séparateur
        System.out.println("321333.7652".matches("(\\d{3}[-.,\\s]?){2}\\d{3,}")); //  (expression reguliére){2} => Utiliser 2 fois un pattern expression reguliére ex on attend 2 fois 3 chifre suivit d'un séparateur
        System.out.println("321333.7652".matches("(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  (expression reguliére){1,2} => Utiliser 1 ou 2 fois un pattern expression reguliére ex on attend 1 fois ou 2 fois 3 chifre suivit d'un séparateur
        System.out.println("1.321333.7652".matches("(\\d[-.,\\s]?)(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  ex il rajoute un chiffre optionnele devant le n° de tel
        System.out.println("1.321333.7652".matches("(1[-.,\\s]?)(\\d{3}[-.,\\s]?){1,2}\\d{3,}")); //  ex il sur que le 1er chiffre devant le n° de tel est un 1

        System.out.println("*************** Lesson 45");
        // Lesson 45 Pattern => type pour stocker dans une variable un regex
        //           mathcher() => comprarer un regex variable avec un n°
        String regex = "(1[-.,\\s]?)(\\d{3}[-.,\\s]?)(\\d{3}[-.,\\s]?)(\\d{3,4})";
        String phoneNumber = "1.321.333.7652";
        System.out.println("1.321333.7652".matches(regex)); //  ex il sur que le 1er chiffre devant le n° de tel est un 1
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phoneNumber);
        if (mat.matches()) {
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println(mat.group(3));
            System.out.println(mat.group(4));
        }

        System.out.println("*************** Lesson 46");
        // Lesson 46 faire des sous groupes pour garder que ce qu'on veut afficher capture groupe=> ((//d
        String regex2 = "((\\d{1,2})[-.,\\s]?)((\\d{3})[-.,\\s]?)((\\d{3})[-.,\\s]?)(\\d{3,4})";
        String phoneNumber2 = "1.321.333.7652";
        Pattern pat2 = Pattern.compile(regex2);
        Matcher mat2 = pat2.matcher(phoneNumber2);
        if (mat2.matches()) {
            System.out.format("Country code: %s\n",mat2.group(2));
            System.out.format("Area code: %s\n",mat2.group(4));
            System.out.format("Exchange: %s\n",mat2.group(6));
            System.out.format("Line number: %s\n",mat2.group(7));
        }

        System.out.println("*************** Lesson 47");
        // Lesson 47 dire qu'on ne veut pas tenir compte des capture group exterieur=> ?:
        // nommer les groupe =< ?<nom du groupe>
        String regex3 = "(?:(?<countryCode>\\d{1,2})[-.,\\s]?)(?:(?<areaCode>\\d{3})[-.,\\s]?)(?:(?<exchange>\\d{3})[-.,\\s]?)(?<lineNumber>\\d{3,4})";
        String phoneNumber3 = "1.321.333.7652";
        Pattern pat3= Pattern.compile(regex3);
        Matcher mat3 = pat3.matcher(phoneNumber3);
        if (mat3.matches()) {
            System.out.format("Country code: %s\n",mat3.group("countryCode"));
            System.out.format("Area code: %s\n",mat3.group("areaCode"));
            System.out.format("Exchange: %s\n",mat3.group("exchange"));
            System.out.format("Line number: %s\n",mat3.group("lineNumber"));
        }

        System.out.println("*************** Lesson 48");
        // Lesson 48 rajouter des commentaires à regex => Pattern.COMMENTS + """ #
        String regex4 = """
                # Regex to compare phone number pattern
                (?:(?<countryCode>\\d{1,2})[-.,\\s]?) # Get Country code
                (?:(?<areaCode>\\d{3})[-.,\\s]?) # Get Area code
                (?:(?<exchange>\\d{3})[-.,\\s]?) # Get Exchange
                (?<lineNumber>\\d{3,4}) # Get Line number
                """;
        String phoneNumber4 = "1.321.333.7652";
        Pattern pat4= Pattern.compile(regex4, Pattern.COMMENTS);
        Matcher mat4 = pat4.matcher(phoneNumber4);
        if (mat4.matches()) {
            System.out.format("Country code: %s\n",mat4.group("countryCode"));
            System.out.format("Area code: %s\n",mat4.group("areaCode"));
            System.out.format("Exchange: %s\n",mat4.group("exchange"));
            System.out.format("Line number: %s\n",mat4.group("lineNumber"));
        }

        System.out.println("*************** Lesson 49");
        // Lesson 49 rajouter l'option de commencer avec Area code entre parenthése (USA) => \\(?   \\)?
        String regex5 = """
                # Regex to compare phone number pattern
                (?:(?<countryCode>\\d{1,2})[-.,\\s]?)? # Get Country code
                (?:\\(?(?<areaCode>[(]?\\d{3})\\)?[-.,)\\s]?) # Get Area code
                (?:(?<exchange>\\d{3})[-.,\\s]?) # Get Exchange
                (?<lineNumber>\\d{3,4}) # Get Line number
                """;
        String phoneNumber5 = "(321) 333.7652";
        Pattern pat5= Pattern.compile(regex5, Pattern.COMMENTS);
        Matcher mat5 = pat5.matcher(phoneNumber5);
        if (mat5.matches()) {
            System.out.format("Country code: %s\n",mat5.group("countryCode"));
            System.out.format("Area code: %s\n",mat5.group("areaCode"));
            System.out.format("Exchange: %s\n",mat5.group("exchange"));
            System.out.format("Line number: %s\n",mat5.group("lineNumber"));
        }

        System.out.println("*************** Lesson 50");
        // Lesson 50 Characters additionnel
        System.out.println("doggy".matches(".....")); // . => match n'importe quel character
        System.out.println("doggy".matches(".*")); // * => [0 à inf]
        System.out.println("doggy".matches(".+")); // + => [1 à inf]
        System.out.println("doggy".matches(".?")); // ? => [0 à 1]
        System.out.println("doggy".matches("[^abcd]")); // [^abcd] => qui ne match pas a ou b ou c ou d
        System.out.println("doggy".matches("^.....")); // ^ => match juste avant la 1ere lettre
        System.out.println("doggy".matches("^.....$")); // $ => match la fin de la ligne
        System.out.println("cat doggy".matches("...\\s\\b.....")); // \\b => match l'espace entre un character et non character
        System.out.println("cat".matches("\\w\\w\\w")); // \\w => match n'importe quel lettres et de nombre string
        System.out.println("cat".matches("\\W\\W\\W")); // \\W => match tout sauf lettres et de nombre string
        System.out.println("---".matches("\\w\\w\\w")); // \\w => match aussi avec les tiret (ici false ?)
        System.out.println("123".matches("\\d\\d\\d")); // \\d => match que des chiffre dans un string
        System.out.println("123".matches("\\D\\D\\D")); // \\D => match tout sauf des chiffre dans un string
        System.out.println(" 1 ".matches("\\s\\d\\s")); // \\s => match un espace dans un string
        System.out.println(" 1&".matches("\\s\\d\\S")); // \\S => match qui n'est pas un espace espace dans un string

        System.out.println("*************** Lesson 51-52");
        // Lesson 51-52 regex match un doc reel
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
            
            Cumulative.*?(?<cumulativeGpa52>[\\d\\.]+)\\b.*  # Get Cumulative GPA # Lesson 52
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
            System.out.println(mat6.group("cumulativeGpa52"));
        }

        System.out.println("*************** Lesson 51-52");
        // Lesson 53 find() => regex methode quand pattern ce repéte de ligne en ligne
        String people = """
                Gavillot, Karl, 16/02/1973
                Rubble, Barney, 02/02/1995
                Flinston, William, 3/3/1910
                Rubble, Betty, 4/4/1915 
                """;
        String regex7 = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})\\n";
        Pattern pat7 = Pattern.compile(regex7);
        Matcher mat7 = pat7.matcher(people);
        mat7.find(); // a chaque fois qu'on appel .find() regex recherche le pattern suivant qui match
        System.out.println(mat7.group("lastName")); // ligne 1
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 2
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 3
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        mat7.find();
        System.out.println(mat7.group("lastName")); // ligne 4
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        /*mat7.find(25); // commence à rechercher un match a partir de cette indexe dans le string
        System.out.println(mat7.group("lastName"));
        System.out.println(mat7.group("firstName"));
        System.out.println(mat7.group("dob"));
        System.out.println(mat7.start()); // Affiche ou l'index de ce match commence et fini
        System.out.println(mat7.end());
        System.out.println(mat7.start("firstName")); // on peut aussi recupérer l'index du capture groupe désigné
        System.out.println(mat7.end("firstName"));
        */


    }
}

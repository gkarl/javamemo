package section3Learnstring;

class LearnString {



    public static void main(String[] args) {
        String text1 = "This is my text 1";
        String text2 = "This is my text 2";

        String finalString = new StringBuilder(text1.length() + text2.length() + 1)
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();

        System.out.println(finalString);

        String otherFinalString = new StringBuffer()
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();

        System.out.println(otherFinalString);

        System.out.format("%s %s \n", text1, text2);

        //    Lesson 26  Creating String => la 1er methode si on donne la meme valeur c'est la meme addresse 2em méthode meme si c'est la meme valeur c'est pas la meme address***********************************
        String fruit = "apple"; //methode 1
        String anotherFruit = "apple";

        String vegetable = new String("broncoli"); //methode 2
        String anotherVegetable = new String("broncoli");

        System.out.println(fruit == anotherFruit );
        System.out.println(vegetable == anotherVegetable);



        // Lesson 27 Upper & Lower => mettre en Majuscule ou en minuscule une string
        String myText ="abcdefg";
        System.out.println(myText.toUpperCase());
        String myText2 = "ABCDEFG";
        System.out.println(myText2.toLowerCase());

        // Lesson 28 isEmpty() isBlank() => dans le cas d'un input user on veux s'assuré qu'il a entré qqc => return true / false
        String myText3 ="a";
        String myText4 = " ";
        System.out.println(myText4.isEmpty());
        System.out.println(myText4.isBlank());

        // Lesson 29 Replace() => remplacer des mots ou une lettre d'un string
        String myText5 ="Il fait beau aujourd'hui foufi";
        System.out.println(myText5.replace("foufi", "Annais"));
        System.out.println(myText5.replace('u', 'Z'));

        // Lesson 30 Strip() ou trim() => vire les espaces d'un string debut et fin
        String doudou = " Karl ";
        System.out.format("'%s' \n", doudou.stripLeading());
        String text6 = """
                        Bonjour les amies
                            toi je te trouve trop bonne
                                ça te dirait de venir faire un calin ce soir?
                """;
        String text7 =  "Bonjour les amies" +
                            "       toi je te trouve trop bonne" +
                                "       ça te dirait de venir faire un calin ce soir? \n";
        System.out.format("%s", text7.stripIndent());  // pas vu de difference
        System.out.format("'%s'", doudou.trim());

        // Lesson 31 charAt() => recupérer 1 lettre d'1 string
        String text8 = "Humm sexy girl !";
        System.out.println(text8.charAt(5));

        // Lesson 32 compareTo() => compare 2 string en unicode place (Alphabetiquement) => 1er > 2 = valeur - ... (pas vu utilité)
        String text9 = "Apple";
        String text10 = "Ride";
        System.out.println(text9.compareTo(text10));

        // Lesson 33 contains() = verifie qu'1 string contiend 1 mot => return true / false
        String text11 = "La riviere pourpe de l'inocence sur le chemin de la descente";
        System.out.println(text11.contains("chemin"));

        // Lesson 34 Concatenation
        String text12 = "this my text 1";
        String text13 = "thid id my text 2";
        System.out.println(text12 + " " + text13); // methode 1
        System.out.println(text12.concat(" " + text13)); // methode 2
        String stringBuilder = new StringBuilder() // methode 3
                .append(text12)
                .append(" ")
                .append(text13)
                .toString();
        System.out.println(stringBuilder);
        String stringBuffer = new StringBuffer() // methode 4
                .append(text12)
                .append(" ")
                .append(text13)
                .toString();
        System.out.println(stringBuffer);
        System.out.format("%s %s \n", text12, text13); // methode 5
        String stringFormat = String.format("%s %s", text12, text13); // methode 6
        System.out.println(stringFormat);

        //Lesson 35 length => connaitre le nb de character d'1 string
        String text14 = "Bonjour";
        System.out.println(text14.length());
        char[] ArrayOfChars = text14.toCharArray();  // parse string en array en array de character
        System.out.println(ArrayOfChars[0]);  // affiche le 1er élément de array

        //Lesson 36 substring() => déterminer grace au index une partie d'un string pour lui appliquer une modif
        String fruit2 = "apple";
        System.out.println(fruit2.substring(0,1).toUpperCase().concat(fruit2.substring(1))); // Methode 1 de concat
        String firstLetter = fruit2.substring(0, 1).toUpperCase();
        String resteDesLettres = fruit2.substring(1);
        System.out.println(new StringBuilder(firstLetter).append(resteDesLettres)); //Methode 3 de concat (avec factorisation)

        // Lesson 37 indexOf() => determiner la présence et l'index d'un character ou un bout de string dans un string
                    //EXO 1 Lesson 37 => veux recupérer dans des variable les diverse partie d'un n°
        String phoneNumber = "    (234) 333-5551".strip();
        String areaCode = parseAreaCode(phoneNumber);
        String exchange= parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);

        System.out.println(areaCode);
        System.out.println(exchange);
        System.out.println(lineNumber);

        // Lesson 38 split() => découpe un string en array d'aprés un character
                // EXO Lesson 38 => veux recuper un tableau excel pour utiliser les données en Java
        String text = """
                Smith,Fred,01/01/1979,1111 ABC St.,Apple,CA
                McGuire,Jerry,02/02/1980,2222 DEJ St.,Orange,NV
                Flintstone,Fred,03/03/1981,3333 GHI St.,Pear,MO
                Rubble,Barney,04/04/1982,4444 JKL St.,Pineapple,IL
                Jetson,George,05/05/1983,5555 MNO St.Grapefruit,NY
                """;
        String[] people = text.split("\n"); // il decoupe le string en array en fct des lignes
        System.out.println(people.length);
        System.out.println(people[4]); // il print array a cette index affiche la derniére ligne
        String[] george = people[4].split(","); // il decoupe le string present dans l'array à l'indexe 4 et en fait un nell erray
        System.out.println(george[3]);

        // Lesson 39 startsWhith() | endsWhith() => cette methode permet de savoir si une string fini avec une string particuliere
        String fileName = "   myFile.txt";
        System.out.println(fileName.endsWith(".txt"));
        String strippedString = fileName.strip();
        System.out.println(strippedString.startsWith("myFile"));

        // Lesson 40 contentEquals() => comparer que 2 string (ou assimilé) sont eguale
        String firstText = "12 Apple";
        String secondeText = "12 Apple";
        System.out.println(firstText.contentEquals(secondeText));

    }


                //EXO 1 Lesson 37 (hors main)
    public static String parseAreaCode(String phoneNumber) {
        int indexOfLastParenthesis = phoneNumber.indexOf(")");
        return phoneNumber.substring(1, indexOfLastParenthesis); // il met pas  + 1 sur dernier car substring() non inclusion sur le dernier
    };
    public static String parseExchange(String phoneNumber) {
        int indexOfSpace = phoneNumber.indexOf(" ");
        int indexTiret = phoneNumber.indexOf("-");
        return phoneNumber.substring(indexOfSpace + 1 , indexTiret);
    };
    public static String parseLineNumber(String phoneNumber) {
        int indexTiret = phoneNumber.indexOf("-");
        return phoneNumber.substring(indexTiret + 1);
    };

}




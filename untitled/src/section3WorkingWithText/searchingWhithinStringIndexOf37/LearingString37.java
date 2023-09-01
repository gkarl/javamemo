package section3WorkingWithText.searchingWhithinStringIndexOf37;

/**
 * Section 3 Working Whith Text - 37 Searching within a String - indexOf()
 *
 * si on veux connaitre si un mot ce trouve trouve dans un string et ou il commence dans se string on peut utiliser indexOf()
 * si le string d'origine ne comporte qu'un seul mot on peut chercher un emplacement aussi
 */
class LearingString37 {


    // EXO => voire dans le main()
    public static String parseAreaCode(String phoneNumber) {
        int indexOfLastParenthesis = phoneNumber.indexOf(")"); // indexOf() => recherche index de "(" dans le String
        return phoneNumber.substring(1, indexOfLastParenthesis); // substring() => recrée un bout string à partir d'un plus gros fct index | il met pas  + 1 sur dernier car substring() non inclusion sur le dernier index
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

    public static void main(String[] args) {

        String myText = "A la belle journée pour aller cueillir des pommes.";

        //____________________Methode1____________________________
        System.out.println(myText.indexOf("aller"));  // indexOf() => Prend 1 string en arg case sensitive retourne l'indexe de la 1er lettre du mot si il est dans la String | return -1 si le mot ou la lettre n'est pas présent

        //____________________Methode2____________________________
        System.out.println(myText.indexOf(65));  // indexOf()  => Peut prendre in Integer en arg qui correspond au nombre Unicode d'un charactere (65 = A majuscule)

        //____________________Methode3____________________________
        System.out.println(myText.lastIndexOf("e"));  // lastIndexOf  => Recherche la dernière occurrence de ce que nous lui demandons de rechercher.

        //____________________Methode4____________________________
        System.out.println(myText.indexOf("e", 2)); // indexOf() => variante 2em arg on peut commencer à chercher depuis un indexe particulier


        //EXO => Veux recupérer dans des variable les diverse partie d'un n°
        String phoneNumber = "    (234) 333-5551".strip();  // strip()  => permet de supprimer les espace à gauche si user à mal tapé
        String areaCode = parseAreaCode(phoneNumber);
        String exchange= parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);

        System.out.println(areaCode);
        System.out.println(exchange);
        System.out.println(lineNumber);
    }

}

package section3Learnstring.stringBlankOrEmpty28;

/**
 * Section 3 Working Whith Text - 28 Strings: Blank or Empty?
 *
 * EX un programme qui accepte input d'user il faut s'assurer qu'il a bien entré qqc avant de process => si non Erreur
 * on préférera utiliser isBlank()
 */
class LearnString28 {

    public static void main(String[] args) {

        String myText0="";
        String myText1 = " ";
        String myText2 ="a";

        System.out.println(myText0.isEmpty());  // isEmpty() => methode qui retourne un boolean true si la longueur du String est 0
        System.out.println(myText1.isEmpty());  // false => car est espace est considéré comme un character
        System.out.println(myText2.isEmpty());  // false

        System.out.println(myText0.isBlank());  // isblank()  => methode qui considére le String blank si aucun character ou si un espace retourne true
        System.out.println(myText1.isBlank());  // true
        System.out.println(myText2.isBlank());  // false
    }
}

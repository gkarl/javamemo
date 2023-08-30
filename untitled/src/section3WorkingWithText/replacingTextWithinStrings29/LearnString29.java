package section3WorkingWithText.replacingTextWithinStrings29;

/**
 * Section 3 Working Whith Text - 29 Replacing Text Within Strings
 *
 * remplacer des mots ou une lettre d'un string
 * Attention case sensitive
 */
class LearnString29 {

    public static void main(String[] args) {

        String myText5 ="Il fait beau aujourd'hui putin";
        System.out.println(myText5.replace("putin", "incorrect")); // replace()  => lui dire ce que vous recherchez en 1er paramètre, puis 2em paramètre indiquez-lui ce par quoi vous souhaitez le remplacer.
        System.out.println(myText5.replace('u', 'Z'));  // idem mais remplacer 1 lettre du string par une autre
    }
}

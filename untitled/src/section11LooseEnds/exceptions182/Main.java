package section11LooseEnds.exceptions182;

/**
 * Section 11 Loose ends : 181 Exceptions
 *
 * par default quand le programme leve une exception il affiche cette erreur et stop il ne traite pas les lignes qui suivent
 *
 * pour ne pas planter le programme on utilise un try/catch
 * Ctrl Alt T => entoure le code select de try/catch()
 *
 * Il existe trois types généraux d'exceptions :
 *
 * - checked (vérifié) exception
 * - runtime exception (unchecked pas verifié)
 * - errors Nous ne traiterons pas les erreurs car de toute façon, vous ne pouvez pas y faire grand-chose.
 *
 * Dans cette lesson on ne verra que runtime exception = exception visible qu'aprés avoir lancé le programme
 * runtime et checked appartiend à la superclass Exception qui elle est une sub-class de la super-class Throwable error appartient a la super-class Throwable
 *
 */
class Main {

    public static void main(String[] args) {
        doSecondeLevel(1);
        System.out.println("You made it to the end");


    }

    private static void doSecondeLevel(int num) {  // Ctrl Alt M => On met tout ce code dans une methode juste pour EX  pour le lancer avec des valeur de arg différent qui vont potentiellement lever des exception et nous montre l'interet de la stackrace en clicant sur lien bleu IDE nous met le cursseur la d'ou provient l'exception
        String[] array = {"one", "two", "tree"};
        //int num = 1;  // Ctrl Alt P  => met cette variable locale en arg de la methode | Cette variable est maintenant valorisé directement au lancement de cette methode ligne 24 => si on met cet arg à 0 on va lever une exception car on ne peut pas diviser par 0
        try {
            System.out.println(array.length / num); // si num est à 0 ça léve une exception car on ne peut pas diviser par 0
            System.out.println(array[3]);  // On depasse la range de array ça leve une exception qui peut planter le programme
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) { // On a été plus spécifique dans le catch de l'exception levé ici on utilise un multi catch | RQ la JVM nous les a affiché aprés run par default
            System.out.println("Something went terribly wrong"); // ci on fait ça il print un message trop général on ne sais pas d'ou il vient
            System.out.printf("Exception type : %s, Message : %s %n", exception.getClass(), exception.getMessage()); // Exception dispose de methode te d'attribut ici on affiche la subclass d'ou vient l'erreur et le message comme le ferait la stack trace de la JVM par default | mais encore une fois il n'affiche que la derniére exception
            exception.printStackTrace(); // affiche le message par default de la JVM sans try/catch
        }
    }
}

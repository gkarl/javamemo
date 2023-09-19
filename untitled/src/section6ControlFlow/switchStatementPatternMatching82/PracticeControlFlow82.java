package section6ControlFlow.switchStatementPatternMatching82;

/**
 * Section 6 Control Flow - 82 Switch Statement Pattern Matching JDK 17 Preview
 *
 * Swtich depuis Java 17 permet de tester le type d'une variable alors print un truc
 *
 * Pour activer cette fct :
 * Clic D sur le projet / OpenModule Settings / Project / SDK 17 + Pattern mathing for switch
 *
 */
class PracticeControlFlow82 {

    public static void main(String[] args) {

        record Person(String firstName, String lastName, int age){};
        String var1 = "Hello world";
        Integer var2 = 34;
        String[] var3 = {"hello", "world"};
        Person var4 = new Person("Karl", "Gavillot", 50);

        Object obj = var3; // variable de type Object (si non switch ne marchera pas) => assigne une de ces variables au dessus qui est d'un type différent
        switch (obj) {
            case String msg -> System.out.println(msg); // cas si la variable assigné à obj est de type String on la print |
            case Integer num -> System.out.println("Your integer a pour valeur " + num);
            case String[] arr -> System.out.println(arr[1]);
            case Person p && p.firstName().length() > 3 -> System.out.println("Tu ressemble à " +  p.firstName()); //cas si de type Person Et son firstname est de plus de 3 lettres
            case null -> System.out.println("It's null"); // cas ou on aurait assigné à obj une valeur null
            case default -> System.out.println("Have no Idea"); // Si aucun trouvé pour obj
        }
    }
}

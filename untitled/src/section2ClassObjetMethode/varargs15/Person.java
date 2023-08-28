package section2ClassObjetMethode.varargs15;

/**
 * Section 2 - 15 Varargs
 *
 * Varargs signifiant nombre variable d'arguments.
 * Supposons que vous souhaitiez créer une méthode pouvant accepter n'importe quel nombre d'entrées
 */
class Person {

    public void test(String[] words) { // Methode 1
        // Do something clever with words
    }

    public void test2(int num1, int num2, String... words) { // Methode 2 => La partie vararg doit être le dernier argument de votre signature de méthode.
        System.out.println(words[2]);  // print le 3em argument qui sera entré dans le varargs au lancement de la fct
        System.out.println(words.length);  // print la taille du varargs entré au lancement de la fct


    }

    public static void main(String[] args) {
        Person p3 = new Person();

        String[] words = {"one", "two", "three"};
        p3.test(words);//

        p3.test2(3, 5, "one", "two", "three");

    }
}

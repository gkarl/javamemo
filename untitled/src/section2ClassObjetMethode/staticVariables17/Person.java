package section2ClassObjetMethode.staticVariables17;

/**
 * Section 2 - 17 Static Variables
 *
 * Pas besoin d'instancier la class pour utiliser ces variables
 * si vous souhaitez accéder aux variables  à partir d'une méthode statique, alors ces variables il faut aussi être statique.
 * Quand on crée des instance de Personne toutes ces instances partagerons cette variable constante (on doit rajouter le mot clé final)
 */
class Person {

    public static double PI = 3.14;  // static => car peut importe le nbre d'instance de Person crée PI ne changera jamais  => c'est comme si on n'avait besoin que d'1 instance de PI

    public static void main(String[] args) {
        System.out.println(PI);
    }
}

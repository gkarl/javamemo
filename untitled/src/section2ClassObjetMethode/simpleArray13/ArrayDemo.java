package section2ClassObjetMethode.simpleArray13;

/**
 * Section 2 - 13 Simple Collections with Arrays
 *
 * Mais fondamentalement, un Array (tableau) peut être considéré comme une collection d’autres types de données.
 * EX on peut stocker une liste de String dans un Array
 */
class ArrayDemo {
    public static void main(String[] args) {

        System.out.println(args.length);  // connaitre le nbre d'élément de l' Array
        // System.out.println(args[0]);  // retrouver quel est le 1ere élémént de l'Array => que aprés avoir remplit l'array depuis le terminal si non Erreur

        // il lance ce main depuis le Terminal grace à cette commande au lieu de laisse IDE
        // EX il rajoute 2 String a Array arg
        // java -cp out/production/section2ClassObjetMethode/simpleArray13 ArrayDemo pomme poire

        int[] nums = {10, 20, 30, 40, 50};
        System.out.println(nums.length);
        System.out.println(nums[1]);
    }
}

package section5Numbers.simpleMathOperations62;

/**
 * Section 5 - 62  Simple Math Operations
 */
class PracticeNumbers62 {

    public static void main(String[] args) {


        System.out.println(5 * (3 + 2));  // les division et multiplication on un ordre d'opération prioritaire par rapport l'addition et la soustraction mais quand on met des parenthése l'ordre change

        System.out.println((double)7 /4); // On peut CAst un int pour de venir un double ou un float |  le nombre ayant le niveau de précision le plus élevé déterminera le type de données => return un double

        System.out.println(7 / 4f); // On peut assi Caster un int en float ou double de cette façon

        //____________________________________

        // Utilisation de modulo
        System.out.println(1 % 2); // on a une sequence de chiffre (n° de ligne) %2 return 01010101 => Ex utile si on veut alterner une color sur les lignes
        System.out.println(2 % 2);// on a une sequence de chiffre (n° de ligne) si %3 return 012012012 => Permet de faire qqc toutes les 3 lignes
        System.out.println(3 % 2);
        System.out.println(4 % 2);
        System.out.println(5 % 2);
        System.out.println(6 % 2);
        System.out.println(7 % 2);
        System.out.println(8 % 2);
        System.out.println(9 % 2);
        System.out.println(10 % 2);

        //____________________________________



        // Incrémenter une variable de 1 (idem methodes + ou -)
        int x = 1;
        //__________________Methode1__________________________
        x = x + 1;

        //__________________Methode2__________________________
        x += 1;

        //__________________Methode3__________________________
        System.out.println(x++);  // print le x avant d'etre incrémenté, x prend le +1 ensuite

        //__________________Methode4__________________________
        System.out.println(++x);  // print x incrémenté de +1

        //________________________________________________________


        // Flip la valeur d'un Boolean
        boolean myFlag = true;
        System.out.println(!myFlag); // ! => flip la valeur d'un boolean | Ex passe à false

    }
}

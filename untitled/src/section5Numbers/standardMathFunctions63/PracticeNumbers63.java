package section5Numbers.standardMathFunctions63;


/**
 * Section 5 - 63 Standard Math Functions
 *
 * Il existe donc une classe appelée Maths, cette classe contient un grand nombre de méthodes utilitaires,
 * comme je les appelle méthodes statiques qui sont là pour faire tout le reste des calculs typiques que vous verriez sur une calculatrice scientifique
 */
class PracticeNumbers63 {

    public static void main(String[] args) {

        System.out.println(Math.abs(-6));     // abs()  => Calcule la valeur absolue d'un nbre | supprimer tout élément négatif.

        System.out.println(Math.ceil(4.4));   // ceil()  => Dès que dépasse .01 il arrondit vers l'entier supérieur

        System.out.println(Math.floor(4.4));  // floor() =>  Il arrondit vers entier inférieur | enlève ce qui est après la virgule

        int num1 = 2;
        int num2 = 8;
        System.out.println(Math.min(num1, num2));   // min() =>  Je vais lui passer un num un et un num. Il renverra le nombre le plus petit, le minimum.
        System.out.println(Math.max(num1, num2));   // max() => Je vais lui passer un num un et un num. Il renverra le nombre le plus grand, le maximum.

        System.out.println(Math.pow(2, 3));         // pow() => exposent | RX  2 exposant 3

        System.out.println(Math.random());          // random() => cette fonction aléatoire est considérée comme être pseudo-aléatoire, pour de la sécurité on utilisera une meilleur methode | Renvoie des valeur entre [0.1 - 0.9]
        System.out.println(Math.random() * 10);     // pour rendre ce résultat exploitable on le multiplie par 10 pour obtenir un nbre compris entre [1.1 - 9.9]
        System.out.println((int)(Math.random() * 10)); // pour le rendre encore plus exploitable il cast ce nbre de type double en nbre de type int [0 - 9]


        System.out.println(Math.round(2.4));       // round() => Il arrondit les chiffres. | Qd c'est inférieur au .5 il prend le int inférieur si [.5  .9] le int supérieur

        System.out.println(Math.sqrt(25));        // sqrt() => racine carré d'un nbre

        System.out.println(Math.PI); // PI => nbre Pi | EX calculer l'aire d'un cercle ou d'un cylindre
        System.out.println(Math.E);  // E => nbre d'Euler

    }
}

package section3WorkingWithText.splittingStringApartSplit38;

/**
 * Section 3 Working Whith Text - 38 Splitting String Apart - split()
 *
 * découpe un string pour les stocker dans array de string d'aprés un character séparateur (ex , ou \n)
 *
 * RQ il existe des librarie pour importer un .csv
 */
class LearningString38 {

    public static void main(String[] args) {

        String text = """
                Smith,Fred,01/01/1979,1111 ABC St.,Apple,CA
                McGuire,Jerry,02/02/1980,2222 DEJ St.,Orange,NV
                Flintstone,Fred,03/03/1981,3333 GHI St.,Pear,MO
                Rubble,Barney,04/04/1982,4444 JKL St.,Pineapple,IL
                Jetson,George,05/05/1983,5555 MNO St.Grapefruit,NY
                """;

        String[] people = text.split("\n"); // split() => il decoupe le string et le stocke dans un Array le charactére de séparation est \n (retoure à la ligne)
        System.out.println(people.length); // affiche le nbre d'élément dans Array = nbre de ligne dans texte (ici 5 ligne de texte = 5 éléments dans notre variable de type Array de string)
        System.out.println(people[4]); // il print élément dans array a index 4  affiche la 5em ligne (derniére ligne ou personnes)
        String[] george = people[4].split(","); // split() => il decoupe le string présent à index 4 (5em personne) dans Array people (le charactére de séparation est ,) et le stocke dans un nell Array appelé george
        System.out.println(george[3]); // // il print élément dans array george a index 3 => donne adresse de la 5em personne
    }
}

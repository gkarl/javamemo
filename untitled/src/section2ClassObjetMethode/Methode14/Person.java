package section2ClassObjetMethode.Methode14;

/**
 * Section 2 - 14. Methods
 *
 * Une méthode peut prendre
 *
 * - zéro ou plusieurs entrées
 * -  et renvoyer 0 ou 1 sortie
 */
class Person {
    private String lastMiddleName = "Karl";

    // Il recommande de mettre un verbe pour le nom d'une methode car elle font une action
    public void sayHello() {  // void => la methode ne retourne aucune Data  | cette methode ne prend pas d'input rien entre les parenthéses
        System.out.println("Hello");
    }

    public void saySomething(String message){ // il veux une fct qui va print ce qu'on va lui passer en argument qd on va la lancer
        System.out.println(message);
    }

    public char getInitiale() {  // nous voulons une méthode qui return l’initiale du field lastMiddleName
        return lastMiddleName.charAt(0);  // il veut le 1er character de ce String
    }


    public int add(int num1, int num2) { //  une méthode qui peut additionner deux nombres ensemble, puis renvoyer la somme de ces nombres
        return num1 + num2;
    }


    public static void main(String[] args) {

        Person p2 = new Person();  // new Creé une instance de Person, p2 est une référence (type) Person
        p2.sayHello(); // p2 est une référence de Person je peux utiliser ses Methodes

        p2.saySomething("My Groovy message");

        char initiale = p2.getInitiale();
        System.out.println(initiale);

        System.out.println(p2.add(5, 3));
    }
}

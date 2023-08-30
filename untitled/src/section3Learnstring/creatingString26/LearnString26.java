package section3Learnstring.creatingString26;

/**
 * Section 3 Working Whith Text - Upper & Lower Casing
 */
class LearnString26 {

    public static void main(String[] args) {

        //____________Methode1________________
        String fruit = "apple";
        String anotherFruit = "apple";

        //____________Methode2________________
        String vegetable = new String("broncoli");
        String anotherVegetable = new String("broncoli");

        // l'opérateur == compare les adresses et retourne true ou false
        System.out.println(fruit == anotherFruit );  // avec la methode 1 si la valeur est identique entre les 2 variables il retourne true c'est la meme address
        System.out.println(vegetable == anotherVegetable); // avec la methode 2  si la valeur est identique entre les 2 variables false ce n'est pas la meme address
    }
}

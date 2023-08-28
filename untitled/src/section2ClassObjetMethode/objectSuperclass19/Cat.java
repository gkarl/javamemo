package section2ClassObjetMethode.objectSuperclass19;

/**
 * Section 2 - 19 The Object SuperClass
 */
class Cat {

    public void meow() {
        System.out.println("Meow meow !!");
    }

    @Override  // Dit que cette methode existe chez la class mére et on est sur le point de la remplacer
    public String toString() {
        // return super.toString();  // super fait référence à la class mére Si on ne fait rien la methode est sur le point de retourner le résultat de cette methode comme le ferais la class mére
        return "Cat - name: Peter";
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println(cat1);  // print() attend un String en argument si on lui passe une instance de class java va chercher si la methode toString() est implémenté
    }
}

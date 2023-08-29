package section2ClassObjetMethode.memberVisibilityMethods20.package2;

public class ClassB {

    public void publicMethod() {  // on peut accéder à une methode public de n'importe ou si sa class est aussi public
        System.out.println("This the public method of classB.");
        privateMethod();  // On peut accéder à une methode private lorsqu'on est dans la meme class
    }

    private void privateMethod() {  // accéssible uniquement par les methode présent dans cette class
        System.out.println("This the private method of classB.");
    }

    protected void protectedMethode() { // mot clé protected accéssible par les class dans le meme package
        System.out.println("this is the protected methode of classB.");
    }

    void packageProtectedMethode() { // package protected pas de mot clé accéssible par les class dans le meme package
        System.out.println("This package protected of classB");
        // Particularité de package protected methode
        // Dans le cas de class mére on peut décider de rendre certaine méthode accéssible au sub class ou non :
        // accés aux methodes protected de la class mére meme si package différent => pour y accéder utiliser le mot clé super
        // pas d'accés aux methodes package protected de la class mére si mére et fille dans 2 package différent
        // accés aux methodes package protected de la class mére si mére et fille dans le meme package différent


    }
}

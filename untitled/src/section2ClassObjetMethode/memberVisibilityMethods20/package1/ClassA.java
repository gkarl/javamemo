package section2ClassObjetMethode.memberVisibilityMethods20.package1;

import section2ClassObjetMethode.memberVisibilityMethods20.package2.ClassB;

/**
 * Section 2 - 20 Memeber Visibility : Methods
 *
 * on vous encourage généralement dans la programmation orientée objet à réduire la visibilité et l'accessibilité pour protéger votre code
 * public | private | protected | package protected
 * voire explication dans package2/classB
 */
public class ClassA {

    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.publicMethod();  // arrive a accéder à une methode privée dans une Class public
        //classB.privateMeth   => n'arrive pas accéder à une methode privée dans une Class public
        // Mais si dans l'autre package/class on appel la methode private dans la methode public elle se lance depuis un package/class extérieur

        //classB.protectedMeth => on a pas accés depuis une class d'un autre package aux methodes protected

        //classB.packageProtectedMeth => on a pas acces au methode package protected depuis qui sont dans un autre package
    }
}

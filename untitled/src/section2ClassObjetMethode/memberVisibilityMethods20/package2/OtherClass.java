package section2ClassObjetMethode.memberVisibilityMethods20.package2;

public class OtherClass {

    public void methode1() {
        ClassB classB = new ClassB();
        // classB.privateMeth  => dans le meme package on ne peux pas accéder au methode privé d'une autre class qui est dans le meme package

        classB.protectedMethode(); // on a acces a une methode protected si on est dans le meme package

        classB.packageProtectedMethode();  // les methodes package protected sont accéssible aux class dans le meme package
    }
}

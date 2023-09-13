package section5Numbers.exoCalculatingAreaOfCircle65;

/**
 * Section 5 - 65 Coding Exercise: Calculating the Area of a Circle
 *
 * Calculer l'aire d'un cercle
 *
 */
class PracticeNumbers65 {

    /**
     * Cette methode calcule l'aire d'un cercle
     * Utilise la formule : area = PI * radius^2
     * @param radius
     * @return
     */
    public static double calcAreaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    } ;

    public static void main(String[] args) {

        System.out.println(calcAreaOfCircle(3));

    }
}

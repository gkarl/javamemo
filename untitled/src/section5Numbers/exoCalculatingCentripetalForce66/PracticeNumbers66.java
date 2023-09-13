package section5Numbers.exoCalculatingCentripetalForce66;

/**
 * Section 5 - 66 Coding Exercise: Calculating Centripetal Force
 *
 * Calculer la Force Centripet à partir d'un modele de physique à 3 equations pour obtenir le résultat
 *
 */
class PracticeNumbers66 {

    /**
     * Cette methode calcule le Path Velocity
     * Utilise la formule : (2 * PI * radius) / période
     * @param radius
     * @param periode
     * @return
     */
    private static double calcPathVelocity(double radius, double periode) {
        double circonference = 2 * Math.PI * radius; // essaie de trouver des endroits pour décomposer la formule globale => crée une local variable = circonférence qui a pour formule C = 2 * PI * radius
        return circonference / periode;
    }

    /**
     * Cette methode calcule le Centripet Accélération
     * Utilise la formule : ((Path Velocity)^2) / radius
     * @param pathVelocity
     * @param radius
     * @return
     */
    private static double calcCentripetAcc(double pathVelocity, double radius) {
        return Math.pow(pathVelocity, 2) / radius;
    }

    /**
     * Cette methode calcule la Force Centripet (ce qu'on veux obtenir)
     * Utilise la formule : masse * Centripet Accélération
     * @param mass
     * @param acc
     * @return
     */
    private static  double calCentripForce(double mass, double acc) {
        return mass * acc;
    }

    /**
     * Overload methode (porte le meme nom signature différente) methode calcule la Force Centripet
     * Décide d'appeler les 3 méthodes précédente dans cette grosse methode plus puissante
     * Appel en arg 1 exemplaire de chaque arg deja utilisé
     * @param mass
     * @param radius
     * @param periode
     * @return
     */
    public static  double calCentripForce(double mass,  double radius, double periode) {
        double pathVelocity = calCentripForce(radius, periode);
        double centripetAcc = calcCentripetAcc(pathVelocity, radius);
        double centripForce = calCentripForce(mass, centripetAcc);  // IDE asses intelligent pour appelé la methode avant Overload qui porte le meme nom
        return centripForce;
    }

    public static void main(String[] args) {

        /*System.out.println(calcPathVelocity(0.8, 3));
        System.out.println(calcCentripetAcc(1.67, 0.8));
        System.out.println(calCentripForce(0.2, 3.504));*/
        System.out.println(calCentripForce(0.2, 0.8, 3)); // Le fait d'avoir cette methode Overload permet de tout lancer sur une ligne plutot que 3 haut dessus

    }
}

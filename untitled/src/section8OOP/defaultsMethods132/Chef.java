package section8OOP.defaultsMethods132;

/**
 * On peut mettre des signatures de méthode classique sur cette interface
 *
 * Fields sont final => pas de setter =>
 * C'est donc une assez grande limitation de ma capacité à gérer pleinement l'héritage multiple,
 * car cette interface avec les méthodes par défaut, vous ne pourrez jamais conserver aucun état.
 *
 * Néanmoins, si vous pouvez identifier certains comportements (méthodes) que vous souhaiteriez rendre partageables de cette manière,
 * c'est certainement une technique que vous pourriez envisager d'utiliser.
 *
 */
interface Chef {

    String favoriteFood = "hamburger"; // On peut également rajouter des fields sur une interface mais par default ce field est final (on ne peut pas changer ça valeur) => on ne peut mettre pas de setter => on ne peut conserver aucun état

    default String getFavoriteFood() { // On peut mettre un getter sur ce field
        return favoriteFood;
    }

    //__________1__________ On crée des méthodes avec implémentation sur une interface avec le mot clé default
    default void cook(String food) {
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    static int convertUnits() { //  Vous pouvez également mettre des méthodes statiques sur une interface potentiellement plutôt sympa
        return 2;
    }
}

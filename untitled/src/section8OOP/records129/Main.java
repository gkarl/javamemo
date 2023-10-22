package section8OOP.records129;

import java.time.LocalDate;

/**
 * Section 8 More OOP - 129 Records
 */
class Main {

    public static void main(String[] args) {

        Weirdo larry = new Weirdo("David", "Larry", LocalDate.of(1950, 1, 16));  //  Il n'y a pas de réelle différence dans l'instanciation avec une class Records | Avec une class Records pas de methodes setter la class et les fields sont finals ils ont été set à l'instanciation
        System.out.println(larry.firstName()); //  Les méthodes getter ne seront pas préfixées par le mot get. Au lieu de cela, ils correspondent simplement au nom réel du field

        Weirdo larySet = new Weirdo(larry.lastName() + "s", larry.firstName(), larry.dob() ); // Si on veut modifier une isntance on doit dans tous les cas recréer une nell instance = nell objet

        Weirdo jake = new Weirdo("London", "Jack"); // On utilise le constructeur alternatif sans date de naissance qu'on a crée pour créer une instance
        jake.sayHello(); // lance une methode de la class weirdo depuis une instance
    }
}

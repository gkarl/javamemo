package section2ClassObjetMethode;

import java.time.LocalDate;
/**
 * Section 2 - 10. Object Orientation
 */
public class Dog extends Pet{ //10. Dog est de type Pet
    //10. on a pas besoin de lui spécifier name et dob (Attributs, comportement) car il l'herite de Pet


    public Dog() {
    }

    public Dog(String name, LocalDate dob) {
        super(name, dob);
    }

    //10. il veut rajouter des comportement spécifiques au chiens en général => methodes
    public void bark() {
        System.out.println("Whaff Whaff !!");
    } //10. Les chiens peuvent aboyer


    @Override
    public String toString() {
        return "C'est moi Boriss le plus beau";
    }

    public static void main(String[] args) {

        Dog boriss = new Dog("Boriss", LocalDate.of(2020, 02, 10));
        System.out.println(boriss);

    }
}

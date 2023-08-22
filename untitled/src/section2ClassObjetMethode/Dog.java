package section2ClassObjetMethode;

import java.time.LocalDate;

public class Dog extends Pet{

    public Dog(String name, LocalDate dob) {
        super(name, dob);
    }

    public void bark() {
        System.out.println("Whaff Whaff !!");
    }


    @Override
    public String toString() {
        return "C'est moi Boriss le plus beau";
    }

    public static void main(String[] args) {

        Dog boriss = new Dog("Boriss", LocalDate.of(2020, 02, 10));
        System.out.println(boriss);

    }
}

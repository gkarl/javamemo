package section2ClassObjetMethode.constructors22;

import java.time.LocalDate;

class HelloWord {

    public static void main(String[] args) {
        Person person5 = new Person("Jhonny", "Smith", LocalDate.of(2000, 11, 1));
        Person amy = new Person();
    }
}

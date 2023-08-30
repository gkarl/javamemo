package section2ClassObjetMethode.gettersSetters23;


import java.time.LocalDate;

class HelloWord {

    public static void main(String[] args) {
        Person jhonny = new Person("jhonny", "smith", LocalDate.of(2000, 11, 1));
        System.out.format("The person's first name is: %s \n", jhonny.getFirstName());
        jhonny.setLastName("Smith"); // on a la possibilité de changer les valeurs des fields aprés instanciation avec les setters
        System.out.format("The person's last name is: %s", jhonny.getLastName());
    }
}


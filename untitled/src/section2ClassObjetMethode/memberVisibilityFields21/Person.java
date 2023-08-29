package section2ClassObjetMethode.memberVisibilityFields21;

import section2ClassObjetMethode.Address;
import section2ClassObjetMethode.Pet;

import java.time.LocalDate;

/**
 * Section 2 - 21. Memeber Visibility: Fields
 * Vous devez faire attention à limiter la quantité d'accès aux données internes d'une classe en dehors de celle-ci.
 */
class Person {

    private String firstName;
    public String lastName;

    protected LocalDate dob;

    private Address address; //10. je doit creer une class pour définir le concept d'une addresse

    private Pet pet;  //10. une personne peut avoir un animal de compagnie

    private section2ClassObjetMethode.Person spouse;  //10. une épouse est une Person


    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {

        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0, 1) + lastName.substring(1);
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public section2ClassObjetMethode.Person getSpouse() {
        return spouse;
    }

    public void setSpouse(section2ClassObjetMethode.Person spouse) {
        this.spouse = spouse;
    }

    //10. il faut rafouter cette methode pour voire s'afficher correctement print() d'une instance et pas juste l'addresse en mémoire de l'objet
    @Override
    public String toString() {
        return "section2ClassObjetMethode.Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                ", pet=" + pet +
                ", spouse=" + spouse +
                '}';
    }


    public static void main(String[] args) {
        Person person3 = new Person();
        String firstName1 = person3.firstName; // les field private sont accéssible dans la meme class

    }

}

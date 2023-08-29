package section2ClassObjetMethode.constructors22;

import section2ClassObjetMethode.Address;
import section2ClassObjetMethode.Pet;

import java.time.LocalDate;

/**
 * Section 2 - 12. Constructors
 *
 * Grace aux constructeur nous avons l'opportunité  d'instancier un objet en donnant des values aux fields
 */
class Person {



    private String firstName;
    private String lastName;

    private LocalDate dob;

    private Address address;

    private Pet pet;

    private section2ClassObjetMethode.Person spouse;


    // Si on ne met aucun constructor on a par default ce constructor vide
    // mais si on crée un constructeur avec des args ce default constructor n'est pas la
    public Person() {  // Si dans l'entrepise on ne peut pas avoir de Person sans nom il mettrait ce constructeur private
    }

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {

        return firstName.substring(0,1).toUpperCase() + firstName.substring(1);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1) + lastName.substring(1);
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
}

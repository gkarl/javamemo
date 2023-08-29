package section2ClassObjetMethode.gettersSetters23;

import section2ClassObjetMethode.Address;
import section2ClassObjetMethode.Pet;

import java.time.LocalDate;

class Person {


    // Il existe une convention forte en Java selon laquelle lorsque nous avons des fields, recommande de mettre private pour protéger les datas interne à une class
    private String firstName;
    private String lastName;

    private LocalDate dob;

    private Address address;

    private Pet pet;

    private section2ClassObjetMethode.Person spouse;

    /**
     * Section 2 - 23. Getters et Setters
     */
    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName; // on peut aussi faire ici dans le constructor que la 1ere lettre soit en majuscule
        this.lastName = lastName;
        this.dob = dob;
    }

    // Nous voulons quand exposer l'acces à ces datas via des methodes getter et setter
    // Via getters et setters nous avons la possibilité d'assurer un certain niveau de protection si nous le souhaitons.
    // getters et setters permettent d'accéder aux datas et de les protéger mais permet aussi de les modifiers si on le souhaite pour les rendre plus friendly
    // et prévenir qu'on ne fasse pas ce qu'on souhaite sur ces datas
    public String getFirstName() {

        return firstName.substring(0,1).toUpperCase() + firstName.substring(1);  // met la 1er la 1er lettre de firstname en majuscule => qd print toujours comme ça meme si instancie en minuscule
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1) + lastName.substring(1); // idem met la 1er lettre de lastName en majuscule
    } // On peut rendre le setter inteligent et changer la valeur du field aprés instanciation

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

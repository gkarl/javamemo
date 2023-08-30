package section2ClassObjetMethode.objectSuperclass19;

import java.time.LocalDate;

/**
 * Section 2 - 19 The Object SuperClass
 *
 * Si une class n'extends pas une class par défault elle hérite de la class Object
 * c'est pour ça qu'on a l'anotation @Override sur la methode toString()
 */
class Pet {  // meme si la class Pet n'étend aucune class elle extends la Class Object par défault

    private String name;

    private LocalDate dob;

    public Pet() {  //10. il a du rajouter ce constructeur vide pour eviter une erreur Dog extend Pet
    }

    public Pet(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override  // cette methode viens elle aussi d'une class mére Object et on la réécrit
    public String toString() {
        return "section2ClassObjetMethode.objectOrientation10.Pet{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}

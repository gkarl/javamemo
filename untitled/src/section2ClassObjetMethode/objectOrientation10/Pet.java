package section2ClassObjetMethode.objectOrientation10;

import java.time.LocalDate;

/**
 * Section 2 - 10. Object Orientation
 */
public class Pet extends Object{

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

    @Override
    public String toString() {
        return "section2ClassObjetMethode.objectOrientation10.Pet{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}

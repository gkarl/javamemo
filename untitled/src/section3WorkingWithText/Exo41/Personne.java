package section3WorkingWithText.Exo41;

import java.time.LocalDate;

public class Personne {

    private Long idPerson;
    private String firstName;

    private String LastName;

    private LocalDate dob;

    public Personne(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        LastName = lastName;
        this.dob = dob;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}

package section2ClassObjetMethode;

import java.time.LocalDate;


/**
 * Section 2 - 10. Object Orientation
 */
public class Person {

    private final double PI = 3.14;


    private String firstName;
    private String lastName;

    private LocalDate dob;

    private Address address; //10. je doit creer une class pour définir le concept d'une addresse

    private Pet pet;  //10. une personne peut avoir un animal de compagnie

    private Person spouse;  //10. une épouse est une Person


    public Person() {
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

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
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

//    ***************************************
//  14/ Methodes    -----------------------------------------
    private String lastMiddleName = "Karl";

    public void sayHello() {
        System.out.println("Hello");
    }

    public void saySomething(String message){
        System.out.println(message);
    }

    public char getMiddleName() {
        return lastMiddleName.charAt(0);
    }

//   15/ Vararg ------------------------------------------------
    public void test(int num1, int num2, String[] word) {
        System.out.println(word[1]);
        System.out.println(word.length);
    }

    public void test2(int num1, int num2, String... words){
        System.out.println(words[2]);
    };

//    17/ Static Variables --------------------------------------------------------
    public static double PIC = 3.14;

//    18/ Static Initializers -------------------------------------------------------------
    //methode 1
    public static int[] nums;
    static {
        nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
    }
    // methode 2
    public static int[] nums2 = initNums();
    public static int[] initNums() {
        nums2 = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        return nums2;
    }





    public static void main(String[] args) {
//    14/ Methodes   -----------------------------------------------------------
        Person p1 = new Person();
        p1.sayHello();
        p1.saySomething("Bonjourno");
        char middleName = p1.getMiddleName();
        System.out.println(middleName);
//      15/ vararg -------------------------------------------------
        // Methode 1
        String[] words = new String[] {"one", "two", "tree"};
        p1.test(1,2, words);
        // Methode 2
        p1.test2(1,0, "one", "tow", "tree");
//       18 static Initializer -----------------------------------------------------
        System.out.println(nums[2]);
        System.out.println(nums2[0]);

    }
}

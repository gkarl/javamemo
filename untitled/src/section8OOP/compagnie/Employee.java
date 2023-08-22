package section8OOP.compagnie;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee{

    protected String firstName;
    protected String lastName;
    protected LocalDate dob;
    /*protected final Matcher peopleMatcher;*/
    protected static  Matcher peopleMatcher;

    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<details>.*)\\}?\\n";
    // private static final Pattern peoplePattern = Pattern.compile(peopleRegex);
    public static final Pattern PEOPLE_PATTERN = Pattern.compile(PEOPLE_REGEX);
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    protected Employee() {
        peopleMatcher = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    protected Employee(String personText) {
        peopleMatcher = Employee.PEOPLE_PATTERN.matcher(personText);
        if (peopleMatcher.find()) {
            this.firstName = peopleMatcher.group("firstName");
            this.lastName = peopleMatcher.group("lastName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMatcher.group("dob")));
        }
    }

  /*  public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }*/

    public static final IEmployee createEmployee(String employeeText) {
        Matcher peopleMatcher = Employee.PEOPLE_PATTERN.matcher(employeeText);
        if (peopleMatcher.find()) {
            return switch (peopleMatcher.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                //default -> new DummyEmployee();
                default -> () -> 0;

            };
        } else {
            return new DummyEmployee();


        }
    }

    public abstract int getSalary();

    public double getBonus() {
        return getSalary() * 1.10;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", firstName, lastName, moneyFormat.format(getSalary()), getBonus());
    }

    private static final class DummyEmployee extends Employee {
        @Override
        public int getSalary() {
            return 0;
        }
    }
}

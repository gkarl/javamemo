package section8OOP.revisitingClassHierarchies122;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Analyst extends Employee {

    /*private String lastName;
    private String firstName;
    private LocalDate dob;*/
    private  int projectCount = 0;

    /*private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);*/
    String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
    Pattern analystPat = Pattern.compile(analystRegex);
    /*private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");*/

    public Analyst(String personText) {
        /*Matcher peopleMat = peoplePattern.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));*/
        super(personText);
        Matcher analystMat = analystPat.matcher(peopleMat.group("detail"));
        if (analystMat.find()) {
            this.projectCount = Integer.parseInt(analystMat.group("projectCount"));

        }
    }

    public int getSalary() {
        return 4000 * projectCount;
    }

    /*@Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
    }*/
}

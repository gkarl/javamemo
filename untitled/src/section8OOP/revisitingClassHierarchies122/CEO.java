package section8OOP.revisitingClassHierarchies122;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CEO extends Employee {

   /* private String lastName;
    private String firstName;
    private LocalDate dob;*/
    private  int avgStockPrice = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
    Pattern ceoPat = Pattern.compile(ceoRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public CEO(String personText) {
        Matcher peopleMat = peoplePattern.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));

            Matcher ceoMat = ceoPat.matcher(peopleMat.group("detail"));
            if (ceoMat.find()) {
                this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));

            }
        }
    }

    public int getSalary() {
        return 5000 * avgStockPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary()));
    }
}

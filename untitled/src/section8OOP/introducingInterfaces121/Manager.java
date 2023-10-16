package section8OOP.introducingInterfaces121;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Manager implements Employee {

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private  int orgSize = 0;
    private int directReports = 0;

    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<detail>.*)\\}\\n";
    private final Pattern peoplePattern = Pattern.compile(peopleRegex);
    String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
    Pattern managerPat = Pattern.compile(managerRegex);
    private final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public Manager(String personText) {
        Matcher peopleMat = peoplePattern.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));

            Matcher managerMat = managerPat.matcher(peopleMat.group("detail"));
            if (managerMat.find()) {
                this.orgSize = Integer.parseInt(managerMat.group("orgSize"));
                this.directReports = Integer.parseInt(managerMat.group("dr"));
            }
        }
    }

    public int getSalary() { // la ligne de calcul des salaires dans le main() devient une methode | seule partie qui effectue un calcul
        return 3500 * orgSize * directReports; // meme si linesOfCode, yearsOfExp, iq égale 0 getSalary() return 3000 => pas besoin de else
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s", lastName, firstName, moneyFormat.format(getSalary())); // permettra de print ces valeurs | le return de la methode getSalary est mis au format monétaire
    }
}

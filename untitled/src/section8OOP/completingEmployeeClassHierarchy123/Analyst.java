package section8OOP.completingEmployeeClassHierarchy123;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Analyst extends Employee {

    private  int projectCount = 0;

    String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
    Pattern analystPat = Pattern.compile(analystRegex);

    public Analyst(String personText) {
        super(personText);
        Matcher analystMat = analystPat.matcher(peopleMat.group("detail"));
        if (analystMat.find()) {
            this.projectCount = Integer.parseInt(analystMat.group("projectCount"));
        }
    }

    public int getSalary() {
        return 4000 * projectCount;
    }
}

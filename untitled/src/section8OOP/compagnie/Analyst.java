package section8OOP.compagnie;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Analyst extends Employee {

    private int projectCount;

    String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
    Pattern analystPattern = Pattern.compile(analystRegex);


    public Analyst (String personText) {
        super(personText);
        Matcher analystMatcher = analystPattern.matcher(peopleMatcher.group("details"));
        if (analystMatcher.find()) {
            this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));

        }
    }

    public int getSalary() {
        // salary = 1 * locpd * yoe * iq;
        return 4000 * projectCount;
    }

}

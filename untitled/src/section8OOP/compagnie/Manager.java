package section8OOP.compagnie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Manager extends Employee {

    private int orgSize;
    private int dr;


    String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
    Pattern managerPattern = Pattern.compile(managerRegex);

    public Manager (String personText) {
        super(personText);
        Matcher managerMatcher = managerPattern.matcher(peopleMatcher.group("details"));
        if (managerMatcher.find()) {
            this.orgSize = Integer.parseInt(managerMatcher.group("orgSize"));
            this.dr = Integer.parseInt(managerMatcher.group("dr"));
        }
    }
    public int getSalary() {
        // salary = 1 * locpd * yoe * iq;
        return 3500 * orgSize * dr;
    }

}

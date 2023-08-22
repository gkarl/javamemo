package section8OOP.compagnie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Flyer {
    private int avgStockPrice;
    private Flyer flyer = new Pilot(1000, true);
    private Flyer flyer2 = new Pilot(2000, true);

    String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
    Pattern ceoPattern = Pattern.compile(ceoRegex);
    public CEO (String personText) {
        super(personText);
        Matcher analystMatcher = ceoPattern.matcher(peopleMatcher.group("details"));
        if (analystMatcher.find()) {
            this.avgStockPrice = Integer.parseInt(analystMatcher.group("avgStockPrice"));
        }
    }
    public int getSalary() {
        // salary = 1 * locpd * yoe * iq;
        return 5000 * avgStockPrice;
    }
    public void fly() {
        flyer.fly();
    }
    public int getHoursFlows() {
        return flyer.getHoursFlows();
    }

    public void setHoursFlows(int hoursFlows) {
        flyer.setHoursFlows(hoursFlows);
    }
    public boolean isIfr() {
        return flyer.isIfr();
    }
    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }
}

package section8OOP.compagnie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private int nbLignesCode;
    private int yearOfExperience;
    private int iq;


    private final String programmerRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)";
    private final Pattern programmerPattern = Pattern.compile(programmerRegex);

    public Programmer(String personText) {
        super(personText);
        Matcher programmerMatcher = programmerPattern.matcher(peopleMatcher.group("details"));
        if (programmerMatcher.find()) {
            this.nbLignesCode = Integer.parseInt(programmerMatcher.group("locpd"));
            this.yearOfExperience = Integer.parseInt(programmerMatcher.group("yoe"));
            this.iq = Integer.parseInt(programmerMatcher.group("iq"));
        }
    }

    public int getNbLignesCode() {
        return nbLignesCode;
    }

    public void setNbLignesCode(int nbLignesCode) {
        this.nbLignesCode = nbLignesCode;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getSalary() {
        // salary = 1 * locpd * yoe * iq;
        return 1 * nbLignesCode * yearOfExperience * iq;
    }

}

package section8OOP.factoryMethods126;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Manager  extends Employee {

    private  int orgSize = 0;
    private int directReports = 0;

    String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
    Pattern managerPat = Pattern.compile(managerRegex);

    public Manager(String personText) {
        super(personText);
        Matcher managerMat = managerPat.matcher(peopleMat.group("detail"));
        if (managerMat.find()) {
            this.orgSize = Integer.parseInt(managerMat.group("orgSize"));
            this.directReports = Integer.parseInt(managerMat.group("dr"));
        }
    }

    public int getSalary() { // la ligne de calcul des salaires dans le main() devient une methode | seule partie qui effectue un calcul
        return 3500 * orgSize * directReports; // meme si linesOfCode, yearsOfExp, iq égale 0 getSalary() return 3000 => pas besoin de else
    }
}

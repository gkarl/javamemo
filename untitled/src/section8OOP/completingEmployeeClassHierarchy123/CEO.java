package section8OOP.completingEmployeeClassHierarchy123;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CEO extends Employee {
    private  int avgStockPrice = 0;

    String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
    Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String personText) {
        super(personText);
        Matcher ceoMat = ceoPat.matcher(peopleMat.group("detail"));
        if (ceoMat.find()) {
            this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));

        }
    }

    public int getSalary() {
        return 5000 * avgStockPrice;
    }
}

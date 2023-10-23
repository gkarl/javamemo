package section8OOP.compositionVersusInheritance131;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 8 More OOP - 131 Composition Versus Inheritance
 *
 * On a la class CEO qui hérite de la super class Employee mais on voudrait que CEO soit lié (sorte d'héritage) aussi de la class Pilot
 * le CEO est un employee mais il peut aussi etre un pilote
 *
 * On ne peut pas le faire avec l'heritage car une class ne peut extends qu'1 seule autre class
 * => technique de Composition
 *
 * Quand préférer utiliser Héritage :
 *
 * - C'est ok de faire de l'héritage pour bénéficier des avantages de OOP
 * - Mais évité plus de 3 niveaus d'heritage au max (il y a un juste milieu)
 * RQ pour éviter qu'une class puisse etre extends par une autre met le mot clé final devant ex final public class CEO
 *
 * Quand préférer utiliser Composition :
 *
 * - On ne sait pas si une class a prévu d'etre extended héritage (car vient d'une autre organisation) => prudence car des mises à jour peuvent planter notre programme
 * => plus de controle en composition car methodes Delegate peuvent etre override
 */
//__________4_____________la class CEO implemente également l'interface Flyer (crée à partir des methodes de Pilot) Comme la class Pilot
class CEO extends Employee implements Flyer{
    private  int avgStockPrice = 0;

    //__________1_____________Crée une instance de Pilot en tant que field dans CEO | Puis on la met de type Flyer à la creation de cette interface
    private Flyer pilot = new Pilot(1000, true);
    Flyer flyer = new Pilot(1000, true);

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

    //__________2_____________ Alt Insert / Delegate Methods => CEO a alors essentiellement les mêmes méthodes que Pilot (mais passe par pilot)
    public void fly() {
        pilot.fly(); // j'ai maintenant une methode fly() dans CEO qui Delegate (délégue) à la methode fly() dans Pilot
    }

    public int getHoursFlows() {
        return pilot.getHoursFlows();
    }

    public void setHoursFlows(int hoursFlows) {
        pilot.setHoursFlows(hoursFlows);
    }

    public boolean isIfr() {
        return pilot.isIfr();
    }

    public void setIfr(boolean ifr) {
        pilot.setIfr(ifr);
    }
}

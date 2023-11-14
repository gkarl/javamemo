package section10StreamsAndLambdas.firstStepsIntoStreamsAPI161;

import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Section 10: Streams & Lambdas - 161 First Steps into Streams API
 *
 * Streams C'est un pipeline de methode qui s'enchaine avec input output
 */
class StreamStuff  {
    public static void main(String[] args) {

        // data de base list d'employees
        // On fait volontairement une erreur sur le role d'un employee ligne 2 Programmerzzzzzzz => qd lance le program plante car on entre dans case default return nul => employee = null => Erreur car le code apres qui appel les methode toString() et getSalary() à partir d'un objet null (pointe vers rien) = Null pointer exception
        String peopleText = """  
            Flinstone1, Rod, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
            Flinstone2, Rod, 6/2/2000, Programmerzzzzzzz, {locpd=3000, yoe=4, iq=340}
            Flinstone3, Rod, 6/2/2000, Programmer, {locpd=4000, yoe=5, iq=120}
            Flinstone4, Rod, 6/2/2000, Programmer, {locpd=5000, yoe=5, iq=120}
            Rubble, Barney, 2/2/1995, Manager, {orgSize=100, dr=8}
            Rubble2, Barney, 2/2/1995, Manager, {orgSize=200, dr=2}
            Rubble3, Barney, 2/2/1995, Manager, {orgSize=500, dr=4}
            Flinston, William, 3/3/1910, Analyst, {projectCount=4}
            Flinston2, William, 3/3/1910, Analyst, {projectCount=10}
            Flinston3, William, 3/3/1910, Analyst, {projectCount=8}
            Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
            """;


        peopleText
                .lines()  // crée un Streams => découpe le multi String en ligne => output
                .map((s) -> Employee.createEmployee(s)) // J'ai du virér \\n à la fin de la Regex pourque ça marche | map() => methode de Stream API prend 1 arg et return 1 output (IEmployee return de createEmployee()) signature interface Function | Appelé Reference Methode | écrit en Lambda  ((s) -> Employee.createEmployee(s)) RQ pas besoin d'intancier Employee pour utiliser createEmployee car static
                .forEach(System.out::println); // orEach() => methode de fin de pipeline pour Streams car 1 input et 0 output | écrit avec Lambda  ((s) => System.out.println(s))
    }
}




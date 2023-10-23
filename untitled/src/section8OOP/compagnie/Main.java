package section8OOP.compagnie;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

class Main {

    public static void main(String[] args) {
        System.out.println("*************** Lesson 117");
        // Lesson 117 OOP => exo accumuler les salaire
        String people = """
                Canton, Rod, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
                Canton2, Rod, 6/2/2000, Programmer, {locpd=3000, yoe=4, iq=340}
                Canton3, Rod, 6/2/2000, Programmer, {locpd=4000, yoe=5, iq=120}
                Canton4, Rod, 6/2/2000, Programmer, {locpd=5000, yoe=5, iq=120}
                Rubble, Barney, 2/2/1995, Manager, {orgSize=100, dr=8}
                Rubble2, Barney, 2/2/1995, Manager, {orgSize=200, dr=2}
                Rubble3, Barney, 2/2/1995, Manager, {orgSize=500, dr=4}
                Flinston, William, 3/3/1910, Analyst, {projectCount=4}
                Flinston2, William, 3/3/1910, Analyst, {projectCount=10}
                Flinston3, William, 3/3/1910, Analyst, {projectCount=8}
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;
        //String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<details>.*)\\}?\\n";
        //String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<details>.*)\\}.*$";

        //Pattern peoplePattern = Pattern.compile(peopleRegex);

        //Matcher peopleMatcher = peoplePattern.matcher(people);
        Matcher peopleMatcher = Employee.PEOPLE_PATTERN.matcher(people);
        Flyer flyer = new CEO("""
                Mich, Michou, 4/4/1915, CEO, {avgStockPrice=3000}
                """);
        flyer.fly();
        System.out.println("flyer hours flows " + flyer.getHoursFlows());
        CEO flyer2 = new CEO("""
                Mich2, Michou, 4/4/1915, CEO, {avgStockPrice=3000}
                """);
        flyer2.fly();
        System.out.println("flyer2 salary " + flyer2.getSalary());
        flyer2.setHoursFlows(5);
        System.out.println("flyer2 hours flows " + flyer2.getHoursFlows());

        /*String programmerRegex = "\\w+\\s*\\=(?<locpd>\\d+)\\,\\s*\\w+\\s*\\=(?<yoe>\\d+)\\,\\\s*\\w+\\s*\\=(?<iq>\\d+)";
        Pattern programmerPattern = Pattern.compile(programmerRegex);

        String managerRegex = "\\w+\\s*\\=(?<orgSize>\\d+)\\,\\s*\\w+\\s*\\=(?<dr>\\d+)";
        Pattern managerPattern = Pattern.compile(managerRegex);

        String analystRegex = "\\w+\\s*\\=(?<projectCount>\\d+)";
        Pattern analystPattern = Pattern.compile(analystRegex);

        String ceoRegex = "\\w+\\s*\\=(?<avgStockPrice>\\d+)";
        Pattern ceoPattern = Pattern.compile(ceoRegex);*/

        int totalSalary = 0;
        //Employee employee = null;
        IEmployee employee = null;
        ArrayList<IEmployee> employees = new ArrayList<>();
        while (peopleMatcher.find()) {
            //System.out.printf("%s %s %s %s%n", peopleMatcher.group("lastName"), peopleMatcher.group("firstName"), peopleMatcher.group("dob"), peopleMatcher.group("role"));
            // totalSalary+= switch(peopleMatcher.group("role")) {
            /*employee = switch(peopleMatcher.group("role")) {*/
            employee = Employee.createEmployee(peopleMatcher.group());
            employees.add(employee);
            /*case "Programmer" ->  new Programmer(peopleMatcher.group());*/
                    /*
                    { Matcher programmerMatcher = programmerPattern.matcher(peopleMatcher.group("details"));
                    int salary = 0;
                    if (programmerMatcher.find()) {
                        int locpd = Integer.parseInt(programmerMatcher.group("locpd"));
                        int yoe = Integer.parseInt(programmerMatcher.group("yoe"));
                        int iq = Integer.parseInt(programmerMatcher.group("iq"));
                        //System.out.printf("Programmer locpd: %s programmer yoe: %s programmer yoe: %s%n", locpd, yoe, iq);
                        salary = 1 * locpd * yoe * iq;
                    } else {
                        salary = 1;
                    }
                    String firstName = peopleMatcher.group("firstName");
                    String lastName = peopleMatcher.group("lastName");
                    System.out.printf("Programmer firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));*/
                    /*Programmer programmer = new Programmer(peopleMatcher.group());
                    System.out.println(programmer.toString());
                    yield programmer.getSalary(); }*/

            /*case "Manager" ->  new Manager(peopleMatcher.group());*/
                   /*{ Matcher managerMatcher = managerPattern.matcher(peopleMatcher.group("details"));
                    int salary = 0;
                    if (managerMatcher.find()) {
                        int orgSize = Integer.parseInt(managerMatcher.group("orgSize"));
                        int dr = Integer.parseInt(managerMatcher.group("dr"));
                        //System.out.printf("Manager orgSize: %s manager dr: %s%n ", orgSize, dr);
                        salary = 3500 * orgSize * dr;
                    } else {
                        salary = 3500;
                    }
                    String firstName = peopleMatcher.group("firstName");
                    String lastName = peopleMatcher.group("lastName");
                    System.out.printf("Manager firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;*/
                    /*Manager manager = new Manager(peopleMatcher.group());
                    System.out.println(manager.toString());
                    yield manager.getSalary();}*/

            /* case "Analyst" ->  new Analyst(peopleMatcher.group());*/
                    /*{ Matcher analystMatcher = analystPattern.matcher(peopleMatcher.group("details"));
                    int salary = 0;
                    if (analystMatcher.find()) {
                        int projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
                        //System.out.printf("Analyst orgSize: %s%n ", orgSize);
                        salary = 4000 * projectCount;
                    } else {
                        salary = 4000;
                    }
                    String firstName = peopleMatcher.group("firstName");
                    String lastName = peopleMatcher.group("lastName");
                    System.out.printf("Analyst firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;*/
                    /*Analyst analyst = new Analyst(peopleMatcher.group());
                    System.out.println(analyst.toString());
                    yield analyst.getSalary(); }*/

            /*case "CEO" ->  new CEO(peopleMatcher.group());*/
                   /* { Matcher ceoMatcher = ceoPattern.matcher(peopleMatcher.group("details"));
                    int salary = 0;
                    if (ceoMatcher.find()) {
                        int avgStockPrice = Integer.parseInt(ceoMatcher.group("avgStockPrice"));
                        //System.out.printf("CEO avgStockPrice: %s%n ", avgStockPrice);
                        salary = 5000 * avgStockPrice;
                    } else {
                        salary = 5000;
                    }
                    String firstName = peopleMatcher.group("firstName");
                    String lastName = peopleMatcher.group("lastName");
                    System.out.printf("CEO firstName: %s lastName: %s salary: %s%n", firstName, lastName, NumberFormat.getCurrencyInstance().format(salary));
                    yield salary;*/
                    /*CEO ceo = new CEO(peopleMatcher.group());
                    System.out.println(ceo.toString());
                    yield ceo.getSalary();} */

            // default -> 0;
               /* default -> null;
            };*/
            //if (employee != null) {
            //System.out.println(employee.toString());
            //totalSalary += employee.getSalary();
            //}

            if (employee instanceof CEO ceo) {
                System.out.println("nbre houre of fly " + ceo.getHoursFlows() + " " + ceo.lastName);
            }
        }

        List<String> removalWorker = new ArrayList<>();
        removalWorker.add("Canton");
        removalWorker.add("Canton2");
        removalWorker.add("Canton3");
        removalWorker.add("Canton4");
        removalWorker.add("Flinston3");
        removalWorker.add("Rubble2");

        List<String> newStrings = new ArrayList<>();
        newStrings.addAll(removalWorker);
        System.out.println("Taille de la liste " + newStrings.size());


        String troisieme = newStrings.get(2);
        System.out.println("l'indexe de cet element est le " + newStrings.indexOf(troisieme));


        employees.set(0, Employee.createEmployee("""
                Pierre, Moriac, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
                """));
        System.out.println("Verification " + employees.get(0).toString());


        employees.sort(new Comparator<IEmployee>() {
            @Override
            public int compare(IEmployee o1, IEmployee o2) {
                if (o1 instanceof Employee emp1 && o2 instanceof Employee emp2) {
                    int lnameResult = emp1.lastName.compareTo(emp2.lastName);
                    return lnameResult != 0 ? lnameResult : emp1.firstName.compareTo(emp2.firstName);
                }
                return 0;
            }
        });


        List<IEmployee> sublist = employees.subList(0, 3);
        for (IEmployee worksub : sublist) {
            System.out.println("sublist test" + worksub.toString());
        }

        List<String> undesirables = List.of("Canton2", "Flinston3", "Rubble2");

        IEmployee employee1 = employees.get(0);
        employees.remove(employee1);

        employees.remove(1);

        employees.add(0, new Programmer("""
                    karl, Gavillot, 6/2/2000, Programmer, {locpd=2000, yoe=3, iq=140}
                    """));
        System.out.println("Test " + employees.get(0).toString());


        remodeUndesirables(employees, removalWorker);


        /*for (IEmployee worker : employees) {
            if (worker instanceof Employee) {
                Employee tmpWorker = (Employee) worker;
                if (removalWorker.contains(tmpWorker.firstName)) {
                    employees.remove(worker);
                }
            }
            System.out.println(worker.toString());
            totalSalary += worker.getSalary();
        }*/

            for (IEmployee workeri : employees) {
                System.out.println(workeri.toString());
                totalSalary += workeri.getSalary();
            }

            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            System.out.printf("Le total des paye est de %s%n", currencyInstance.format(totalSalary));
        }

    private static void remodeUndesirables(ArrayList<IEmployee> employees, List<String> removalWorker) {
        for (Iterator<IEmployee> it = employees.iterator(); it.hasNext();) {
            IEmployee worker = it.next();
            if (worker instanceof Employee tmpWorker) {
                //Employee tmpWorker = (Employee) worker;
                if (removalWorker.contains(tmpWorker.lastName)) {
                    it.remove();
                }
            }
        }
    }
}


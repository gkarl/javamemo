package section5Numbers.numericWrapperClasses75;

/**
 * Section 5 - 75 Numeric Wrapper Classes
 *
 * Integer.parseInt() => convertir un string en int pour pouvoir faire des opération dessus
 */
class PracticeNumbers {

    public static void storeData(Object obj) { // Obj => class dont hérite toutes les class | On utilise Obj en type pour dire que la methode prend en arg un objet de n'importe quel type | Java fera auto la conversion d'un type primitif à un type Objet (Wrapper) on parle d'AutoBoxing
        // Fait qqc avec arg
    }

    public static void main(String[] args) {

        String num = "7";

        //____________________Convertir un String en Number____________________________

        Integer myInteger = Integer.valueOf(num); // Integer.valueOf() => Convertit un String ou int en Integer

        Double myDouble = Double.valueOf(num); // Double.valueOf() => Convertit un String ou double en Double

        Float myFloat = Float.valueOf(num); // Float.valueOf() => Convertit un String ou float en Float

        Float myFloat2 = Float.valueOf(23.23f); // Float.valueOf() => Convertit un String ou float en Float

        Byte myByte = Byte.valueOf(num); // Byte.valueOf() => convertit un String en Byte

        //_________________Convertir un Number en un autre type de Number_____________________

        Double myDouble2 = myFloat2.doubleValue(); // doubleValue() => Convertir un type en Double

        Integer myInteger2 = myFloat2.intValue(); // intValue() => Convertir un type en Integer

        //_________________Convertir Number en String__________________________________

        String myString = myInteger.toString(); // toString() => Convertir un type en String

        //________________Convertir un String en primitif_______________________________

        int age = Integer.parseInt("37"); // Integer.parseInt() => Convertir un String en int

        System.out.printf("Votre age sera dans 15 ans de : %d %n", age + 15 );

        // int userInput = Integer.parseInt(args[0]); // si on récupére des string depuis un formulaire depuis une user interface voire le cour
    }
}

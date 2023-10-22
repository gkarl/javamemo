package section8OOP.records129;

import java.time.LocalDate;

/**
 *  Section 8 More OOP - 129 Records
 *
 *  Class de type Records => version abrégée d'une classe (deriere le rideau il crée les fields, le constructeur, getter et setter, eaquals() et hashCode()
 *  Existe que depuis la version Java 14
 *
 *  -Les class record ne peuvent rien extends
 * - Cette class est final elle ne peut pas extended une autre class
 * - Vous ne pouvez déclarer aucune autre instance, field ou variable d'instance sur Record autre que ces Fileds que vous définissez dans le constructeur lui-même.
 * - Vous pouvez définir des fields static sur un enregistrement
 * - Les class records ne peuvent pas etre abstract car la seule chose qu'on peut faire avec une class abstract est de l'extended sur une autre class
 * - Peut implementer des interfaces (il sourit sur le fait que les Records ne peuvent extends car interface est une option tres proche)
 * - Les class Records peuvent etre Nested dans une autre class
 *
 *
 * concept appelé mutabilité => Fondamentalement, le plus souvent, c’est une excellente idée de conserver autant de données immuables que possible
 *
 * @param lastName
 * @param firstName
 * @param dob
 */
record Weirdo(String lastName, String firstName, LocalDate dob) implements Apple { // La création d'une class de type record ce rapproche d'un constructeur | Les Records ne peuvent extends aucune classe. Cependant, ils peuvent implémenter une interface

    public Weirdo(String lastName, String firstName) { //on peut crée des constructeur alternatif | ex un constructeur avec firstName et lastName mais sans dob (date de naissance)
        this(lastName,firstName, null);
    }

    public String sayHello() { // On peut ajouter nos propre methodes** dans une class de type Records
        return "Hello World";
    }
}

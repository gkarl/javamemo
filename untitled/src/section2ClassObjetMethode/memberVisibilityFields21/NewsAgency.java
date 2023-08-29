package section2ClassObjetMethode.memberVisibilityFields21;

import java.time.LocalDate;

class NewsAgency {

    public  void accessMethod() {
        Person person4 = new Person();
        person4.getFirstName(); // On à pas accés directement aux field private dans une autre class du meme package
        String lastName = person4.lastName;  // on a acces aux field public depuis n'importe ou (c'est une tres mauvaise idée)
        LocalDate dob = person4.dob; // on a acces au field protected si on est dans le meme package
    }
}

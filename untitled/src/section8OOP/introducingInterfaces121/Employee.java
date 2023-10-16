package section8OOP.introducingInterfaces121;

public interface Employee {  //** Une interface est comme un template (modéle) de méthodes, il n'y a que des signatures de methode dessus

    //** Pas besoin du mot clé public sur la methode car toutes les méthodes sont par défaut public sur une interface
    int getSalary();  //** Toutes les class qui implémente cette interface doive implémenter les méthodes présentent dans l'interface en respectant la signature des méthodes
}

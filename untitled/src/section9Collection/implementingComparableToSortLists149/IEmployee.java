package section9Collection.implementingComparableToSortLists149;

/**
 * On était pas obligé d'utiliser l'interface IEmployee on aurait pu garder le type Employee (return de createEmployee et dans le Main)
 * implenter interface Comparable directement sur la class Employee
 * c'était juste pour nous montrer qq concepte en plus
 * comme la Lambda qui ne peut etre utilisé que si on a une interface avec une seul méthode avec la meme signature que la Lambda
 */
//_______________________Methode 2 + 3________________________________
//Etape 2 ______________________
interface IEmployee extends Comparable<IEmployee>{  // List employees qu'on essaye de trié est de type IEmployee => extends interface Comparable (pas implemente car IEmployee est une interface)
    int getSalary();
}

package section9Collection.usingMapImplementations156;

interface IEmployee  extends Comparable<IEmployee>{  // List employees qu'on essaye de trié est de type IEmployee => extends interface Comparable (pas implemente car IEmployee est une interface)
    int getSalary();
}

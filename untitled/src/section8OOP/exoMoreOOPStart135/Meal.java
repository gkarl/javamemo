package section8OOP.exoMoreOOPStart135;

enum Meal {
    potRoast(1),
    spaghetti(2),
    tacos(3),
    chicken(4),
    meatloaf(5),
    hamburgers(6),
    pizza(7);

    private int value;

    Meal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

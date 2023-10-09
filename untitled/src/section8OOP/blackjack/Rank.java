package section8OOP.blackjack;

enum Rank {
    AS(1),
    DEUX(2),
    TROIS(3),
    QUATRE(4),
    CINQ(5),
    SIX(6),
    SEPT(7),
    HUITE(8),
    NEUF(9),
    DIX(10),
    VALET(10),
    DAME(10),
    ROI(10);

    private int value;

    Rank(int value) {
        this.value = value;
    }

    /*public int getValue() {
        return switch (this) {
            case VALET, DAME, ROI -> 10;
            default -> ordinal() + 1;
        };
    }*/

    public int getValue() {
        return value;
    }

}

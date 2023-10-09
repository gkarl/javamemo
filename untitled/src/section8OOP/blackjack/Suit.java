package section8OOP.blackjack;

enum Suit {
    COEUR('\u2665'),
    TREFFLE('\u2663'),
    PIC('\u2660'),
    CARREAU('\u2666');

    private char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}

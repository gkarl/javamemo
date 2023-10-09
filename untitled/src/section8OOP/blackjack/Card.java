package section8OOP.blackjack;

class Card {

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(String rank, String suit) {
        this.rank = Rank.valueOf(rank.toUpperCase()); // convertit String input en Enum
        this.suit = Suit.valueOf(suit.toUpperCase());
    }


    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public static void main(String[] args) {
        Card card1 = new Card(Rank.VALET, Suit.COEUR);
        Card card2 = new Card(Rank.DEUX, Suit.PIC);
        Card card3 = new Card("roi", "carreau");

        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);


    }

    /*public int getValue() {
        return switch (this.rank) {
            case VALET, DAME, ROI -> 10;
            default -> this.rank.ordinal() + 1;
        };
    }*/
    public int getValue() {
        return this.rank.getValue();
    }

    //return this.rank == Rank.ROI ? 10 : this.rank.ordinal() + 1;


    @Override
    public String toString() {
        return this.rank.toString().concat(" ").concat(this.suit.toString());
    }
}

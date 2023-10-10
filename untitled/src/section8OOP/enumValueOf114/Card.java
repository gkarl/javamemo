package section8OOP.enumValueOf114;

/**
 * Section 8 More OOP - 114 Enum ValueOf
 *
 * Il veut print symbol et la valeur de la carte =>
 *
 * Il veut la possibilité de créer des cartes différement en entrant des string en arg => nell constructeur
 */
class Card {
    private Rank rank; // Pour changer rapidement tous le type de cette attribut en type Enum clic D sur type / Rafactor/ Type Migration ou Ctrl Shift F6

    private Suit suit;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(String suit, String rank) {  //** met les arg du constructor en type String | l'ordre est important il doit matcher avec instantiation
        this.suit = Suit.valueOf(suit.toUpperCase());  //** Suit.valueOf() => parse le type String des arg du constructor en type Suit type du field
        this.rank = Rank.valueOf(rank.toUpperCase());  //** idem
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
        Card card4 = new Card(Suit.CLUBS,Rank.KING);
        Card card5 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card6 = new Card("heart", "queen"); //** Il veux la possibilité de créer des cartes différement en entrant des string en arg => rajoute un constructeur pour que ce soit possible

        System.out.println(card4); //** print les carte instancié
        System.out.println(card5);
        System.out.println(card6);

    }


    /*public int getValue() {
        return switch (this.rank) {  //
            case JACK, QUEEN, KING -> 10;
            default -> this.rank.ordinal() + 1;
        };
    }*/

    public int getValue() {
        return this.rank.getValue();  //  ici, nous déléguons simplement l'appel getValue() a un niveau inférieur la class Enum Rank
    }

    @Override
    public String toString() {
        return this.rank.toString().concat(" ") + this.suit.toString(); //** il veux un print ex JACK (symbole COEUR)
    }
}

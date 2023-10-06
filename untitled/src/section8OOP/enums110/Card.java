package section8OOP.enums110;

import section8OOP.enums110.Rank;
import section8OOP.enums110.Suit;

/** Section 8 More OOP - 110 Enums
 *
 * Généralement, lorsque nous avons une situation où vous pouvez avoir une propriété qui peut être définie sur un ensemble fini de valeurs qui ne changerons jamais on utilise un Enum
 *
 */
class Card {

        private Rank rank; // Pour changer rapidement tous le type de cette attribut en type Enum clic D sur type / Rafactor/ Type Migration ou Ctrl Shift F6

        private Suit suit;

        public Card(Suit suit, Rank rank) {
            this.rank = rank;
            this.suit = suit;
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
        Card card1 = new Card(Suit.CLUBS,Rank.KING); // On crée un Enum Suit (couleur de la carte) et Rank (valeur de la carte) pour qu'a l'instanciation de la carte il ne soit pas possible de se tromper sur les valeurs à entrer = Type Safe
        Card card2 = new Card(Suit.DIAMONDS, Rank.TEN);
    }
}

import java.util.Random;
import java.util.Arrays;

/**
 * deck class
 *
 * @author Sarah Worley
 */
public class Deck {

    /**  Totalnumber of cards*/
    public static final int CARDS_IN_DECK = 52;
    /** index */
    private int index;
    /** seed */
    private int seed;
    /** Creates a deck of cards  */
    Card [] cards = new Card [CARDS_IN_DECK];


    /** Creates a deck with the card class
    @param seed from user
    */
    public Deck(int seed) {
        if(seed == -1) {
            Random rand = new Random();
        } else {
            Random rand = new Random(seed);
        }
        int k = 0;
        char [] suits = {Card.CLUBS, Card.DIAMONDS, Card.HEARTS, Card.SPADES};

        for (int j = 0;  j < suits.length; j++) {
            for( int i = Card.LOWEST_VALUE; i <= Card.HIGHEST_VALUE; i++ ) {
                Card card = new Card(i, suits[j]);
                cards[k] = card;
                k++;

            }
        }
        this.seed = seed;

    }


    /** Shuffles the deck */
    public void shuffle() {
        Random rand = new Random(seed);
        for (int i = CARDS_IN_DECK - 1; i >= 1; i--) {
            int j = rand.nextInt(i + 1);
            Card card = cards[i];
            cards[i] = cards[j];
            cards[j] = card;

        }

    }

    /**
     * next index
     * of the card.
     * @return next index
     */
    public Card nextCard() {
        return cards[index++];

    }

    /**
     * Derterms if decks are equal
     * Returns true or false
     * @param o card decks to comapare
     * @return if decks are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Deck ) {
            Deck other = (Deck) o;

            return  (Arrays.equals(this.cards, other.cards)
                && this.seed == other.seed
                && this.index == other.index);
        } else {
            return false;
        }
    }

    /**
     * Returns a String representation deck
     * @return String containing card suit and value
     */
    public String toString() {
        String ret = "";
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            ret += "card " + (i) + ": " + cards[i].toString() + "\n";
        }
        return ret;
    }

}

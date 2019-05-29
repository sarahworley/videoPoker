
/**
 * card class
 *
 * @author Sarah Worley
 */
public class Card implements Comparable<Card> {

    /** Clubs suit */
    public static final char CLUBS = 'c';
    /** diamonds suit */
    public static final char DIAMONDS = 'd';
    /**  Hearts suit*/
    public static final char HEARTS = 'h';
    /**  spades suit*/
    public static final char SPADES = 's';
    /** lowest card value  */
    public static final int LOWEST_VALUE = 2;
    /** highest card value  */
    public static final int HIGHEST_VALUE = 14;
    /** value private */
    private int value;
    /** suit private */
    private char suit;


    /**
   * This method is used for sorting the cards in a player's hand in a game of
   * Poker. Cards are sorted first by value, then by suit.
   *
   * @param other
   *            The Card object to which this Card is being compared.
   * @return negative value if this Card should be before the other Card,
   *         positive value if this Card should be after the other Card.
   */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }


    /**
     * Constructs and initializes a card  object.

     * @param value of Cards
     * @param suit of card
     * @throws IllegalArgumentException card value is invalid
     * @throws IllegalArgumentException if card suit is invalid
     */
    public Card(int value, char suit) {
        if (value > HIGHEST_VALUE || value < LOWEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (!(suit == CLUBS || suit == DIAMONDS || suit == HEARTS || suit == SPADES)) {
            throw new IllegalArgumentException("Invalid suit");
        }

        this.value = value;
        this.suit = suit;

    }

    /**
     * Returns the card value
     * @return the card value
     */

    public int getValue() {
        return value;

    }

    /**
     * Returns the card suit
     * @return the card suit
     */

    public char getSuit() {
        return suit;

    }

    /**
     * Derterms if cards are equal
     * Returns the card value
     * @param o card object to compare
     * @return card value and suit arr equal
     */

    public boolean equals(Object o) {
        if ( o instanceof Card) {
            Card that = (Card) o;
            return this.suit == that.getSuit()
                && this.value == that.getValue();
        } else {
            return false;
        }

    }

    /**
     * Returns a String representation of the card object
     * @return String containing card suit and value
     */
    public String toString() {
        return suit + "" + value;
    }
}

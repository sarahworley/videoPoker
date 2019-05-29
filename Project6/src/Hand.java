import java.util.*;
import java.util.Arrays;

/**
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Sarah Worley
 */
public class Hand {

    /** Contains cards in hand */
    private Card[] hand;
    /**  Totalnumber of cards*/
    public static final int CARDS_IN_HAND = 5;
    /**  Max value  of cards*/
    public static final int MAX_VALUE = 14;
    /**  Acts as an incrementor and checks for cards matches */
    public static final int THREE = 3;
    /**  Started for royal flush  */
    public static final int TEN = 10;



    /** Creates a hand with the card class
    @param hand makes hand
    */
    public Hand(Card[] hand) {
        if (hand == null ) {
            throw new NullPointerException ("Null array");
        }
        if (hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException ("Invalid array length");
        }
        for (int i = 0; i < CARDS_IN_HAND; i ++) {
            if(hand[i] == null) {
                throw new NullPointerException ("Null element");
            }
        }
        this.hand = hand;

    }

    /**
     * Returns card of index specified
     * @param index of card to be returned
     * @return card
     */
    public Card getCard(int index) {
        if((index < 0) || (index >= CARDS_IN_HAND)) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }

    /**
     * Replaces card at index with the card passed into the method
     * @param index of card to Replaces
     * @param card to replace it with
     * 
     */
    public void replace(int index, Card card) {
        if((index < 0) || (index >= CARDS_IN_HAND)) {
            throw new IllegalArgumentException("Invalid index");
        }
        if(card == null){
            throw new NullPointerException("Null card");
        }
        hand[index] = card;

    }

    /**
     * Returns a String representation hand
     * @return String containing card suit and value of hand
     */
    public String toString() {
        String s = "[";
        for(int i = 0; i < CARDS_IN_HAND; i ++) {
            if ( i == (CARDS_IN_HAND - 1)) {
                s += hand[i].toString();
            } else {
                s += hand[i].toString() + ", ";
            }
        }
        s += "]";
        return s;
    }
    /**
     * Derterms if hands are equal
     * Returns true or false
     * @param o other hand to compare
     * @return if hands are equal
     */
    public boolean equals(Object o) {
        Card [] sorted = getSortedHand();
        if (o instanceof Hand ) {
            Hand other = (Hand) o;
            Card [] osorted = other.getSortedHand();
            return Arrays.equals(sorted, osorted);
        } else {
            return false;
        }
    }

    /**
     * Returns if hand has a flush
     * @return if hand contains a flush
     */
    public boolean isFlush() {
        char a = hand[0].getSuit();
        int b = 0;
        for (int i = 1; i < CARDS_IN_HAND; i++ ) {
            if (hand[i].getSuit() == a ) {
                b++;
            }
        }
        return ( b == CARDS_IN_HAND - 1 );
    }

    /**
     * Returns if hand has a straight
     * @return if hand contains a Straight
     */
    public boolean isStraight() {
        Card [] sorted = getSortedHand();
        int a = sorted[0].getValue();
        int b = 0;
        for (int i = 1; i < CARDS_IN_HAND; i++) {
            if (sorted[i].getValue() == ( a + i ) ) {
                b++;
            }
        }
        return (b == CARDS_IN_HAND - 1);
    }
    /**
     * Returns if hand has a straight flush
     * @return if hand contains a Straight flush
     */
    public boolean isStraightFlush() {
        return ( isFlush() && isStraight() );
    }

    /**
     * Returns if hand has a Royal flush
     * @return if hand contains a Royal flush
     */
    public boolean isRoyalFlush() {
        Card [] sorted = getSortedHand();
        return ( isFlush()
            && sorted[0].getValue() == (TEN)
            && sorted[1].getValue() == (MAX_VALUE - THREE)
            && sorted[2].getValue() == (MAX_VALUE - 2)
            && sorted[THREE].getValue() == (MAX_VALUE - 1)
            && sorted[CARDS_IN_HAND - 1].getValue() == MAX_VALUE );

    }

    /**
     * Returns if hand has four of a kind
     * @return if hand contains four of a kind
     */
    public boolean hasFourOfAKind() {

        for (int i = 0; i < CARDS_IN_HAND; i ++) {
            int a = hand[i].getValue();
            int b = 0;
            for (int j = 0; j < CARDS_IN_HAND; j ++) {
                if (hand[j].getValue() == a) {
                    b++;
                }
            }
            if (b >= CARDS_IN_HAND - 1 ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if hand has three of a kind
     * @return if hand contains three of a kind
     */
    public boolean hasThreeOfAKind() {

        for (int i = 0; i < CARDS_IN_HAND; i ++) {
            int a = hand[i].getValue();
            int b = 0;
            for (int j = 0; j < CARDS_IN_HAND; j ++) {
                if (hand[j].getValue() == a) {
                    b++;
                }
            }
            if (b >= THREE ) {
                return true;
            }
        }
        return false;

    }
    /**
     * Returns if hand has two pairs
     * @return if hand contains two pairs
     */
    public boolean hasTwoPairs() {
        int b = 0;
        int [] count = getCounts();
        for(int i = 0; i < count.length; i ++) {
            if(count[i] == 2) {
                b++;
            }
            if(count[i] > 2) {
                b += count[i] / 2;
            }
        }
        return (b == 2);
    }

    /**
     * Returns if hand has one pair
     * @return if hand contains one pair
     */
    public boolean hasOnePair() {
        int b = 0;
        int [] count = getCounts();
        for(int i = 0; i < count.length; i ++) {
            if(count[i] == 2) {
                b++;
            }
            if(count[i] > 2) {
                b += count[i] / 2;
            }
        }
        return (b == 1);
    }

    /**
     * Returns if hand has a full house
     * @return if hand contains a full house
     */
    public boolean isFullHouse() {
        int a = 0;
        int b = 0;
        int [] count = getCounts();
        for(int i = 0; i < count.length; i ++) {
            if(count[i] == 2) {
                b++;
            }
        }
        for(int i = 0; i < count.length; i ++) {
            if(count[i] == THREE) {
                a++;
            }
        }
        return (b == 1 && a == 1);
    }

    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }

}

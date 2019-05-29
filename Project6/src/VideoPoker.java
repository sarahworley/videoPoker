
/**
 * video poker Interface
 *
 * @author Sarah Worley
 */

public class VideoPoker {

    /** random game */
    public static final int RANDOM_GAME = -1;
    /** number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    /** number of points that the player has when the game begins */
    public static final int STARTING_POINTS = 100;
    /**  number of points needed to play a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;
    /** Royal Flush */
    public static final int ROYAL_FLUSH = 100;
    /** Straight Flush */
    public static final int STRAIGHT_FLUSH = 60;
    /** Four of a Kind */
    public static final int FOUR_OF_A_KIND = 50;
    /** Full House */
    public static final int FULL_HOUSE = 40;
    /** Flush */
    public static final int FLUSH = 30;
    /** Straight */
    public static final int STRAIGHT = 25;
    /** Three of a Kind */
    public static final int THREE_OF_A_KIND = 15;
    /** Two Pairs */
    public static final int TWO_PAIRS = 10;
    /** One Pair */
    public static final int ONE_PAIR = 7;


    /** Deck of cards for the game */
    private Deck deck;
    /** Hand of Cards for the game */
    private Hand hand;
    /** current number of points */
    private int points;


    /** Takes starting seed
    * @param seed from user
    */
    public VideoPoker(int seed){
        points = STARTING_POINTS;
        deck = new Deck(seed);
    }
    /** gets points
    * @return points
    */
    public int getPoints() {
        return points;
    }
    /** gets the cards images
    * @param index index of card
    * @return string of file name
    */
    public String getCardFileName(int index){
        String s = "cards/" ;
        s += hand.getCard(index).toString();
        s += ".gif";
        return s;

    }
    /** Gets card based on index
    * @param index index of card
    @return cards from specified index
    */
    public Card getCard(int index) {
        return hand.getCard(index);

    }
    /** Starts a new game
    */
    public void newGame() {
        points = points - POINTS_FOR_NEW_GAME;
        deck.shuffle();
        Card [] arr = new Card [CARDS_IN_HAND];
        for (int i = 0; i < CARDS_IN_HAND; i ++) {
            arr[i] = deck.nextCard();
        }
        hand = new Hand(arr);

    }
    /** replaces card
    * * @param index index of card
    */
    public void replaceCard(int index) {
        hand.replace(index, deck.nextCard());

    }
    /** gets the score of the hand with a string of the matches w/in hand
    @return a string of hand
    */
    public String scoreHand() {
        String s = "";
        if(hand.isRoyalFlush()) {
            points += ROYAL_FLUSH;
            s = "Royal Flush";
        } else if(hand.isStraightFlush()) {
            points += STRAIGHT_FLUSH;
            s = "Straight Flush";
        } else if(hand.hasFourOfAKind()) {
            points += FOUR_OF_A_KIND;
            s = "Four of a Kind";
        } else if(hand.isFullHouse()) {
            points += FULL_HOUSE;
            s = "Full House";
        } else if(hand.isFlush()) {
            points += FLUSH;
            s = "Flush";
        } else if(hand.isStraight()) {
            points += STRAIGHT;
            s = "Straight";
        } else if(hand.hasThreeOfAKind()) {
            points += THREE_OF_A_KIND;
            s = "Three of a Kind";
        } else if(hand.hasTwoPairs()) {
            points += TWO_PAIRS;
            s = "Two Pairs";
        } else if(hand.hasOnePair()) {
            points += ONE_PAIR;
            s = "One Pair";
        } else {
            s = "No Pair";
        }
        return s;
    }
}

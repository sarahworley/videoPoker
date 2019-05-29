import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author
 */
public class CardTest extends TestCase {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    /** card two of hearts for testing */
    private Card twoOfClubs;


    /**
     * Create cards for testing
     */
    @Before
    public void setUp() {
        twoOfHearts = new Card(2, 'h');
        twoOfClubs = new Card(2, 'c');
    }

    @Test
    public void testConstants() {
        // The following tests test that constants are defined as specified
        assertEquals("CLUBS", 'c', Card.CLUBS);
        assertEquals("DIAMONDS", 'd', Card.DIAMONDS);
        assertEquals("SPADES", 's', Card.SPADES);
        assertEquals("HEARTS", 'h', Card.HEARTS);
        assertEquals("LOWEST_VALUE", 2, Card.LOWEST_VALUE);
        assertEquals("HIGHEST_VALUE]", 14, Card.HIGHEST_VALUE);
    }


    @Test
    public void testConstructorPreConditions() {
        try {
            new Card(1, 'h');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card(15, 's');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card(5, 'x');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }

        try {
            new Card(8, 'D');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }
    }

    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals("twoOfHearts value", 2, twoOfHearts.getValue());
    }

    @Test
    public void testGetValueTwoOfClubs() {
        assertEquals("twoOfClubs value", 2, twoOfClubs.getValue());
    }
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals("twoOfHearts suit", 'h', twoOfHearts.getSuit());
    }
    @Test
    public void testGetSuitTwoOfClubs() {
        assertEquals("twoOfClubs suit", 'c', twoOfClubs.getSuit());
    }
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("twoOfHearts toString", "h2", twoOfHearts.toString());
    }
    @Test
    public void testToStringTwoOfClubs() {
        assertEquals("twoOfClubs toString", "c2", twoOfClubs.toString());
    }
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue("twoOfHearts equals with same instance", twoOfHearts.equals(twoOfHearts));
        assertTrue("twoOfHearts equals with different instances",
                   twoOfHearts.equals(new Card(2, 'h')));
        assertFalse("twoOfHearts with different value", twoOfHearts.equals(new Card(4, 'h')));
        assertFalse("twoOfHearts with different suit", twoOfHearts.equals(new Card(2, 's')));
        assertFalse("twoOfHearts with different value and suit",
                    twoOfHearts.equals(new Card(5, 'c')));
        assertFalse("twoOfHearts compared to null object", twoOfHearts.equals(null));
        assertFalse("twoOfHearts compared to String", twoOfHearts.equals("twoOfHearts"));
    }
    @Test
    public void testEqualsTwoOfClubs() {
        assertTrue("twoOfClubs equals with same instance", twoOfClubs.equals(twoOfClubs));
        assertTrue("twoOfClubs equals with different instances",
                   twoOfClubs.equals(new Card(2, 'c')));
        assertFalse("twoOfClubs with different value", twoOfClubs.equals(new Card(4, 'c')));
        assertFalse("twoOfClubs with different suit", twoOfClubs.equals(new Card(2, 's')));
        assertFalse("twoOfClubs with different value and suit",
                    twoOfClubs.equals(new Card(5, 'h')));
        assertFalse("twoOfClubs compared to null object", twoOfClubs.equals(null));
        assertFalse("twoOfClubs compared to String", twoOfClubs.equals("twoOfClubs"));
    }

}

package card;

import utils.Constants;

import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * This class test the creation of a Card as well as the getRank and getSuit method
 * @author Yang Xia
 * 10/10/2018
 */
public class CardImplTest {

    /**
     * Test getRank method by iterating through all the rank of Club suit
     */
    @org.junit.Test
    public void getRank() {
        String suit = "club";
        Suit testSuit = new SuitImpl(suit);
        Map<String, Integer> rankMap = Constants.getRankMap();
        rankMap.keySet().forEach(rank -> {
            Card testCard = new CardImpl(new RankImpl(rank), testSuit);
            assertEquals(rank, testCard.getRank().getName());
            assertEquals((long) rankMap.get(rank), testCard.getRank().getPips());
        });

    }

    /**
     * Test getSuit method by iterating through all the Suit of Rank "Two"
     */
    @org.junit.Test
    public void getSuit() {
        String rank = "Two";
        Rank testRank = new RankImpl(rank);
        Map<String, Character> suitMap = Constants.getSuitMap();
        suitMap.keySet().forEach(suit -> {
            Card testCard = new CardImpl(testRank, new SuitImpl(suit));
            assertEquals(suit, testCard.getSuit().getName());
            assertEquals((char) suitMap.get(suit), testCard.getSuit().getSymbol());
        });

    }

    /**
     * Test the creation of a Card by iterating through 52 two cards
     */
    @org.junit.Test
    public void testCreateCard(){
        Map<String, Character> suitMap = Constants.getSuitMap();
        Map<String, Integer> rankMap = Constants.getRankMap();
        for (Iterator<String> iterator = suitMap.keySet().iterator(); iterator.hasNext(); ) {
            String suit = iterator.next();
            Suit testSuit = new SuitImpl(suit);
            for (Iterator<String> iterator1 = rankMap.keySet().iterator(); iterator1.hasNext(); ) {
                String rank = iterator1.next();
                Rank testRank = new RankImpl(rank);
                Card testCard = new CardImpl(testRank, testSuit);

                assertEquals(rank, testCard.getRank().getName());
                assertEquals((long) rankMap.get(rank), testCard.getRank().getPips());
                assertEquals(suit, testCard.getSuit().getName());
                assertEquals((char) suitMap.get(suit), testCard.getSuit().getSymbol());
            }
        }
    }
}
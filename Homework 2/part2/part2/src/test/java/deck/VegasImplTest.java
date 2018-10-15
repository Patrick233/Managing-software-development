package deck;

import card.Card;
import org.junit.Test;
import utils.Constants;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * This class test A Vegas Deck has the right cards in it as well as its override methods
 * @author Yang Xia
 * 10/10/2018
 */
public class VegasImplTest {

    private static final String DECKNUM = "deckNum";
    /**
     * A Euchre Deck has the right cards in it
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testDeck() throws NoSuchFieldException, IllegalAccessException{
        final Deck deck = new VegasImpl();

        final Field field = deck.getClass().getSuperclass().getDeclaredField("cards");
        final Field privateField = deck.getClass().getDeclaredField(DECKNUM);

        field.setAccessible(true);
        privateField.setAccessible(true);
        int numberOfDeck = (int) privateField.get(deck);
        List<Card> cards = (List<Card>) field.get(deck);

        Map<String, Integer> countMap = new HashMap<>();
        Set<String> rankSet = Constants.getEuchreRank();
        for(Card c: cards){
            if(rankSet.contains(c.getRank().getName())){
                String combinedKey = c.getRank().getName()+c.getSuit().getName();
                countMap.put(combinedKey, countMap.getOrDefault(combinedKey, 0)+1);
            }
        }

        for(int count: countMap.values()){
            assertEquals(numberOfDeck, count);
        }
        assertEquals((long) Constants.VEGASDECK_NUM*6, cards.size());
    }


    /**
     * Test if officalSize returns the correct value
     */
    @Test
    public void officialSize() throws NoSuchFieldException, IllegalAccessException{
        final Deck deck = new VegasImpl(8);

        final Field privateField = deck.getClass().getDeclaredField(DECKNUM);
        privateField.setAccessible(true);
        int numberOfDeck = (int) privateField.get(deck);

        assertEquals( (long) numberOfDeck*Constants.VEGASDECK_NUM, deck.officialSize());

        final Field privateField2 = VegasImpl.class.getDeclaredField(DECKNUM);
        privateField2.setAccessible(true);
        int numberOfDeck2 = (int) privateField.get(deck);

        assertEquals( (long) numberOfDeck2*Constants.VEGASDECK_NUM, deck.officialSize());
    }

}
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
 * This class test A Pinochle Deck has the right cards in it as well as its override methods
 * @author Yang Xia
 * 10/10/2018
 */
public class PinochleImplTest {

    /**
     * A Euchre Deck has the right cards in it
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testDeck() throws NoSuchFieldException, IllegalAccessException{
        final Deck deck = new PinochleImpl();

        final Field field = deck.getClass().getSuperclass().getDeclaredField("cards");

        field.setAccessible(true);
        List<Card> cards = (List<Card>) field.get(deck);

        Map<String, Integer> countMap = new HashMap<>();
        Set<String> rankSet = Constants.getPinochleRank();
        for(Card c: cards){
            if(rankSet.contains(c.getRank().getName())){
                String combinedKey = c.getRank().getName()+c.getSuit().getName();
                countMap.put(combinedKey, countMap.getOrDefault(combinedKey, 0)+1);
            }
        }

        for(int count: countMap.values()){
            assertEquals(2, count);
        }
        assertEquals(48, cards.size());
    }

    /**
     * Test if officalSize returns the correct vaule
     */
    @Test
    public void officialSize() {
        final Deck deck = new PinochleImpl();
        assertEquals(Constants.PINOCHLEDECK_NUM, deck.officialSize());
    }
}
package deck;

import card.*;
import org.junit.Before;
import org.junit.Test;
import utils.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class test ANY Deck can shuffle, sort, and cut correctly
 * @author Yang Xia
 * 10/10/2018
 */
public class AbstractDeckTest {

    private static final String CARD = "cards";

    private List<Deck> deckList = new ArrayList<>();

    /**
     * Instantiate a deckList so the following test can iterate through and test each cases
     */
    @Before
    public void setUp() {
        deckList.add(new PinochleImpl());
        deckList.add(new EuchreImpl());
        deckList.add(new StandardImpl());
        deckList.add(new VegasImpl());
        deckList.add(new VegasImpl(8));
    }

    /**
     * Use Reflection to test shuffle method, after shuffle, the order should be different
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void shuffle() throws NoSuchFieldException, IllegalAccessException {

        for (Deck deck : deckList) {
            final Field field = deck.getClass().getSuperclass().getDeclaredField(CARD);

            field.setAccessible(true);
            List<Card> cards = (List<Card>) field.get(deck);
            List<Card> copy = new ArrayList<>(cards);
            assertEquals(copy, cards);

            deck.shuffle();

            assertNotEquals(copy, cards);
            assertEquals(copy.size(), cards.size());
        }

    }

    /**
     * Use Reflection to test sort method, after sort, the latter card should be "Bigger" than the previous one
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void sort() throws NoSuchFieldException, IllegalAccessException {
        for (Deck deck : deckList) {

            final Field field = deck.getClass().getSuperclass().getDeclaredField(CARD);

            field.setAccessible(true);
            List<Card> sortCards = (List<Card>) field.get(deck);

            deck.sort("Rank");
            assertTrue(Utils.isSorted(sortCards, "Rank"));

            deck.sort("Suit");
            assertTrue(Utils.isSorted(sortCards, "Suit"));

            deck.sort("Both");
            assertTrue(Utils.isSorted(sortCards, "Both"));
        }
    }

    /**
     * Use Reflection to test cut method, after cut,the point in the deck is selected and the first half of the deck
     * is placed at the end in ordere
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void cut() throws NoSuchFieldException, IllegalAccessException {

        for (Deck deck : deckList) {
            final Field field = deck.getClass().getSuperclass().getDeclaredField(CARD);

            field.setAccessible(true);
            List<Card> cards = (List<Card>) field.get(deck);

            for (int i = -1; i <= cards.size(); i++) {
                List<Card> copy = new ArrayList<>(cards);
                deck.cut(i);
                if (i <= 0 || i >= cards.size()) {
                    assertEquals(cards, copy);
                    continue;
                }
                assertEquals(copy.get(i).getRank().getName(), cards.get(0).getRank().getName());
                assertEquals(copy.get(i).getSuit().getName(), cards.get(0).getSuit().getName());
                assertEquals(copy.get(i - 1).getRank().getName(), cards.get(cards.size() - 1).getRank().getName());
                assertEquals(copy.get(i - 1).getSuit().getName(), cards.get(cards.size() - 1).getSuit().getName());
            }

        }
    }

    /**
     * Use Reflection to test pill method, pull should return the first card on deck
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void pullCard() throws NoSuchFieldException, IllegalAccessException {

        for (Deck deck : deckList) {
            final Field field = deck.getClass().getSuperclass().getDeclaredField(CARD);

            field.setAccessible(true);
            List<Card> cards = (List<Card>) field.get(deck);
            List<Card> copy = new ArrayList<>(cards);
            int count = 0;
            while(count <= cards.size()+1){
                Card pulledCard = deck.pullCard();
                if (count >= copy.size()) {
                    assertEquals(null, pulledCard);
                    continue;
                }
                assertEquals(copy.get(count).getRank().getName(), pulledCard.getRank().getName());
                assertEquals(copy.get(count).getSuit().getName(), pulledCard.getSuit().getName());
                assertEquals((long) copy.size()-count-1, cards.size());
                count++;
            }

        }
    }

    /**
     * Use Reflection to test pill method
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void emptyDeck() throws NoSuchFieldException, IllegalAccessException {
        for(Deck deck:deckList){
            final Field field = deck.getClass().getSuperclass().getDeclaredField(CARD);

            field.setAccessible(true);
            List<Card> cards = new ArrayList<>();
            field.set(deck, cards);

            assertEquals(true, deck.emptyDeck());
            cards.add(new CardImpl(new RankImpl("Ten"), new SuitImpl("club")));

            assertEquals(false, deck.emptyDeck());
        }

    }

}
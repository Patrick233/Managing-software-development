package hand;

import card.Card;
import card.CardImpl;
import card.RankImpl;
import card.SuitImpl;
import org.junit.Test;
import utils.Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class test if a Hand is properly implemented
 *
 * @author Yang Xia
 * 10/10/2018
 */
public class HandImplTest {
    private static final String CARD = "cards";


    /**
     * Use Reflection to test if showCards return the correct list
     */
    @Test
    public void showCards() throws NoSuchFieldException, IllegalAccessException {
        final Hand hand = new HandImpl();

        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = new ArrayList<>();
        field.set(hand, cards);

        Card firstCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("club"));
        cards.add(firstCard);
        cards.add(secCard);

        List<Card> copyCards = new ArrayList<>(cards);

        assertEquals(hand.showCards(), cards);


        copyCards.remove(firstCard);
        assertNotEquals(hand.showCards(), copyCards);
    }

    /**
     * Use Reflection to test if showCards return the correct list
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void accept() throws NoSuchFieldException, IllegalAccessException{
        final Hand hand = new HandImpl();

        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = new ArrayList<>();
        field.set(hand, cards);

        Card firstCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("club"));

        hand.accept(firstCard);
        assertTrue(Utils.cardsEqual(firstCard, cards.get(0)));

        hand.accept(secCard);
        assertTrue(Utils.cardsEqual(secCard, cards.get(1)));

        hand.accept(firstCard);
        assertTrue(Utils.cardsEqual(firstCard, cards.get(2)));
    }

    /**
     * Use Reflection to test if pullCard return the correct Card
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void pullCard() throws NoSuchFieldException, IllegalAccessException {
        final Hand hand = new HandImpl();

        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = new ArrayList<>();
        field.set(hand, cards);

        Card firstCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("club"));
        cards.add(firstCard);
        cards.add(secCard);

        Card pulledCard = hand.pullCard();
        assertEquals(firstCard.getRank().getName(), pulledCard.getRank().getName());
        assertEquals(firstCard.getSuit().getName(), pulledCard.getSuit().getName());
        assertEquals(1, cards.size());

        pulledCard = hand.pullCard();
        assertEquals(secCard.getRank().getName(), pulledCard.getRank().getName());
        assertEquals(secCard.getSuit().getName(), pulledCard.getSuit().getName());
        assertEquals(0, cards.size());

        pulledCard = hand.pullCard();
        assertEquals(null, pulledCard);
    }

    /**
     * Use Reflection to test if hasCard is implemented correctly, meaning return true if hand has card and vice verse
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void hasCard() throws NoSuchFieldException, IllegalAccessException {
        final Hand hand = new HandImpl();

        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = new ArrayList<>();
        field.set(hand, cards);

        Card firstCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("club"));
        cards.add(firstCard);

        assertTrue(hand.hasCard(firstCard));
        assertFalse(hand.hasCard(secCard));
    }

    /**
     * Use Reflection to test if hasCard is implemented correctly, meaning return true if hand has card and vice verse
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void sort() throws NoSuchFieldException, IllegalAccessException {
        final Hand hand = new HandImpl();

        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = new ArrayList<>();
        field.set(hand, cards);

        Card firstCard = new CardImpl(new RankImpl("Eight"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("spade"));
        Card thirdCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("diamond"));
        cards.add(firstCard);
        cards.add(secCard);
        cards.add(thirdCard);

        assertFalse(Utils.isSorted(cards, "Rank"));
        hand.sort("Rank");
        assertTrue(Utils.isSorted(cards, "Rank"));

        assertFalse(Utils.isSorted(cards, "Suit"));
        hand.sort("Suit");
        assertTrue(Utils.isSorted(cards, "Suit"));

        assertFalse(Utils.isSorted(cards, "Both"));
        hand.sort("Both");
        assertTrue(Utils.isSorted(cards, "Both"));

    }

    /**
     * Use Reflection to test if shuffle, meaning the cards should have different order after shuffle
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void shuffle() throws NoSuchFieldException, IllegalAccessException{
        final Hand hand = new HandImpl();
        final Field field = hand.getClass().getDeclaredField(CARD);

        field.setAccessible(true);
        List<Card> cards = (List<Card>) field.get(hand);
        Card firstCard = new CardImpl(new RankImpl("Eight"), new SuitImpl("club"));
        Card secCard = new CardImpl(new RankImpl("Ten"), new SuitImpl("spade"));
        Card thirdCard = new CardImpl(new RankImpl("Nine"), new SuitImpl("diamond"));
        cards.add(firstCard);
        cards.add(secCard);
        cards.add(thirdCard);
        List<Card> copy = new ArrayList<>(cards);
        assertEquals(copy, cards);

        hand.shuffle();

        assertNotEquals(copy, cards);
        assertEquals(copy.size(), cards.size());
    }
}
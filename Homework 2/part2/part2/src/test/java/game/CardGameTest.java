package game;

import deck.*;
import hand.Hand;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class CardGameTest {

    private static final String DECK = "deck";
    private static final String HANDS = "hands";
    private static final int HANDNUM = 5;

    /**
     * Test the creation of standard deck game by checking: if the deck is instance of the corresponding decks and the hand number
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testStandardDeckGame() throws NoSuchFieldException, IllegalAccessException {
        for(int i=-1; i<=HANDNUM; i++){

            CardGame cardGame = new StandardDeckGame();
            Game standardGame = cardGame.createGame(i);

            if(i < 0){
                assertEquals(null, standardGame);
                continue;
            }

            final Field field = standardGame.getClass().getDeclaredField(DECK);
            final Field handsField = standardGame.getClass().getDeclaredField(HANDS);

            field.setAccessible(true);
            Deck deck = (Deck) field.get(standardGame);
            assertTrue(deck instanceof StandardImpl);

            handsField.setAccessible(true);
            Hand[] hands = (Hand[]) handsField.get(standardGame);
            assertEquals(i, hands.length);
        }


    }

    /**
     * Test the creation of standard deck game by checking: if the deck is instance of the corresponding decks and the hand number
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testPinochleDeckGame() throws NoSuchFieldException, IllegalAccessException {
        for(int i= -1; i<HANDNUM; i++){
            CardGame cardGame = new PinochleGame();
            Game pinochleGame = cardGame.createGame(HANDNUM);

            if(i<0){
                assertNull(pinochleGame);
            }
            final Field field = pinochleGame.getClass().getDeclaredField(DECK);
            final Field handsField = pinochleGame.getClass().getDeclaredField(HANDS);

            field.setAccessible(true);
            Deck deck = (Deck) field.get(pinochleGame);
            assertTrue(deck instanceof PinochleImpl);

            handsField.setAccessible(true);
            Hand[] hands = (Hand[]) handsField.get(pinochleGame);
            assertEquals(HANDNUM, hands.length);
        }

    }

    /**
     * Test the creation of vegas deck game by checking: if the deck is instance of the corresponding decks and the hand number
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testVegasDeckGame() throws NoSuchFieldException, IllegalAccessException {
        for(int i= -1; i<HANDNUM; i++) {
            CardGame cardGame = new VegasDeckGame();
            Game vegasGame = cardGame.createGame(HANDNUM);

            if(i<0){
                assertNull(vegasGame);
            }
            final Field field = vegasGame.getClass().getDeclaredField(DECK);
            final Field handsField = vegasGame.getClass().getDeclaredField(HANDS);

            field.setAccessible(true);
            Deck deck = (Deck) field.get(vegasGame);
            assertTrue(deck instanceof VegasImpl);

            handsField.setAccessible(true);
            Hand[] hands = (Hand[]) handsField.get(vegasGame);
            assertEquals(HANDNUM, hands.length);
        }
    }

    /**
     * Test the creation of standard deck game by checking: if the deck is instance of the corresponding decks and the hand number
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testEuchreDeckGame() throws NoSuchFieldException, IllegalAccessException {
        for(int i= -1; i<HANDNUM; i++) {
            CardGame cardGame = new EuchreGame();
            Game euchreGame = cardGame.createGame(HANDNUM);

            if(i<0){
                assertNull(euchreGame);
            }
            final Field field = euchreGame.getClass().getDeclaredField(DECK);
            final Field handsField = euchreGame.getClass().getDeclaredField(HANDS);

            field.setAccessible(true);
            Deck deck = (Deck) field.get(euchreGame);
            assertTrue(deck instanceof EuchreImpl);

            handsField.setAccessible(true);
            Hand[] hands = (Hand[]) handsField.get(euchreGame);
            assertEquals(HANDNUM, hands.length);
        }
    }

}
package game;

import card.Card;
import deck.*;
import hand.Hand;
import org.junit.Test;
import utils.Constants;
import utils.Utils;


import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.List;


import static org.junit.Assert.*;

/**
 * This class test the Game implementation, check if the deck and hands are appropriate
 */
public class GameImplTest {
    private static final String DECK = "deck";
    private String[] deckTypesFake = new String[]{Constants.STANDARD, Constants.EUCHRE, Constants.PINOCHLE, Constants.VEGAS, "Something"};
    private String[] deckTypesReal = new String[]{Constants.STANDARD, Constants.EUCHRE, Constants.PINOCHLE, Constants.VEGAS};

    /**
     * Test the creation of decks by checking: if the deck is instance of the corresponding decks
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void createDeck() throws NoSuchFieldException, IllegalAccessException {
        for (String s : deckTypesFake) {
            Game game = new GameImpl();
            final Field field = game.getClass().getDeclaredField(DECK);

            field.setAccessible(true);
            game.createDeck(s);
            Deck deck = (Deck) field.get(game);

            switch (s) {
                case Constants.STANDARD:
                    assertTrue(deck instanceof StandardImpl);
                    break;
                case Constants.EUCHRE:
                    assertTrue(deck instanceof EuchreImpl);
                    break;
                case Constants.PINOCHLE:
                    assertTrue(deck instanceof PinochleImpl);
                    break;
                case Constants.VEGAS:
                    assertTrue(deck instanceof VegasImpl);
                    break;
                default:
                    assertEquals(null, deck);
                    return;
            }
        }
    }

    /**
     * Test the creation of non-standard vegas deck by checking: 1. If the deck is instance of VegasImp; 2. Number of decks
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void createDeck1() throws NoSuchFieldException, IllegalAccessException {
        Game game = new GameImpl();
        final Field field = game.getClass().getDeclaredField(DECK);

        field.setAccessible(true);
        game.createDeck(Constants.VEGAS, 8);
        Deck deck = (Deck) field.get(game);
        assertFalse(deck instanceof PinochleImpl);
        assertTrue(deck instanceof VegasImpl);

        final Field privateField = deck.getClass().getDeclaredField("deckNum");

        privateField.setAccessible(true);
        int numberOfDeck = (int) privateField.get(deck);
        assertEquals(8, numberOfDeck);
    }

    /**
     * Test the number of hands is set correctly
     */
    @Test
    public void setNumberOfHands() {
        final Game game = new GameImpl();

        game.setNumberOfHands(5);
        assertEquals(5, ((GameImpl) game).getHands().length);
    }

    /**
     * Test deal function by trying different deckType
     */
    @Test
    public void deal() throws NoSuchFieldException, IllegalAccessException{
        for (String s : deckTypesReal) {
            Game game = new GameImpl();
            final Field field = game.getClass().getDeclaredField(DECK);

            field.setAccessible(true);
            game.createDeck(s);
            Deck deck = (Deck) field.get(game);

            game.setNumberOfHands(5);
            Hand[] hands = ((GameImpl) game).getHands();

            final Field cardFiled = deck.getClass().getSuperclass().getDeclaredField("cards");
            cardFiled.setAccessible(true);
            List<Card> cardList = (List<Card>) cardFiled.get(deck);
            List<Card> copy = new ArrayList<>(cardList);

            for(int j=0; j<4; j++){
                game.deal();
                for(int i=0; i<5; i++){
                    assertTrue(Utils.cardsEqual(hands[i].pullCard(), copy.get(j*5+i)));
                }
            }

        }
    }
}
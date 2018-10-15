package game;

import deck.Deck;
import hand.Hand;

/**
 * This interface serves as a factory, any specific game can be created by overriding the methods
 * @author Yang Xia
 * 10/10/2018
 */
public interface CardGame {

    /**
     * Create a specific deck for the game
     * @return A Deck that is going to be used to play the game
     */
    Deck createDeck();

    /**
     * Create a certain number of hands in order to play the game
     * @param numberOfHand the size of the Hand array
     * @return
     */
    Hand[] createHands(int numberOfHand);

    /**
     * @param numberOfHand the size of the Hand array
     * @return the a concrete game to be played
     */
    Game createGame(int numberOfHand);
}

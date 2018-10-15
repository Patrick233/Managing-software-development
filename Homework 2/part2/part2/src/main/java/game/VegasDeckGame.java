package game;

import deck.Deck;
import deck.VegasImpl;

/**
 * This class creates a Vegas deck game
 * @author Yang Xia
 * 10/11/2018
 */
public class VegasDeckGame extends AbstractCardGame {
    /**
     * Create a Pinochle deck for the game
     * @return A Pinochle Deck that is going to be used to play the game
     */
    @Override
    public Deck createDeck() {
        return new VegasImpl();
    }

}

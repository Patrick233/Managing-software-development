package game;

import deck.Deck;
import deck.EuchreImpl;

/**
 * This class creates a 5 hands Euchre game
 * @author Yang Xia
 * 10/11/2018
 */
public class EuchreGame extends AbstractCardGame {

    /**
     * Create a Euchre deck for the game
     * @return A Euchre Deck that is going to be used to play the game
     */
    @Override
    public Deck createDeck() {
        return new EuchreImpl();
    }

}

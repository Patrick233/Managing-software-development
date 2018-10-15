package game;

import deck.Deck;
import hand.Hand;
import hand.HandImpl;

import java.util.logging.Logger;

/**
 * This abstract class implement the createHands method to avoid duplications
 * @author Yang Xia
 * 10/11/2018
 */
public abstract class AbstractCardGame implements CardGame{

    private static final Logger logger = Logger.getLogger(CardGame.class.getName());
    /**
     * Create a certain number of hands in order to play the game
     * @param numberOfHand the size of the Hand array
     * @return
     */
    @Override
    public Hand[] createHands(int numberOfHand) {
        try{
            Hand[] hands = new Hand[numberOfHand];
            for(int i = 0; i<numberOfHand; i++){
                hands[i] = new HandImpl();
            }
            return hands;
        }
        catch (Exception e){
            logger.info(e.getMessage());
            throw e;
        }

    }

    /**
     * @param numberOfHand the size of the Hand array
     * @return the a concrete game to be played
     */
    @Override
    public Game createGame(int numberOfHand) {
        try{
            Deck deck = createDeck();
            Hand[] hands = createHands(numberOfHand);
            return new GameImpl(deck, hands);
        }
        catch (Exception e){
            logger.info(e.getMessage());
            return null;
        }

    }

}

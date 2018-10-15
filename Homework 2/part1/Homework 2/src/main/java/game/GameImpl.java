package game;

import card.Card;
import deck.*;
import hand.Hand;
import hand.HandImpl;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * This class gives a concrete implementation of Game interface
 *
 * @author Yang Xia
 * 10/10/2018
 */
public class GameImpl implements Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());
    private Hand[] hands;
    private Deck deck;

    /**
     * Default constructor
     */
    public GameImpl() {
        // Both fields are set by the methods below
    }

    /**
     * Create one of the following deck: Standard, Pinochle, Euchre, 6 decks Vegas
     *
     * @param deckType
     */
    public void createDeck(String deckType) {
        Deck newdeck;
        switch (deckType) {
            case "Standard":
                newdeck = new StandardImpl();
                break;
            case "Euchre":
                newdeck = new EuchreImpl();
                break;
            case "Pinochle":
                newdeck = new PinochleImpl();
                break;
            case "Vegas":
                newdeck = new VegasImpl();
                break;
            default:

                logger.info("Cannot recognize deckType, please double check it is one of the following:" +
                        "Standard, Euchre, Pinochle, Vegas.");
                return;
        }

        this.deck = newdeck;
    }


    /**
     * Create a Vegas Deck with the given number of standard decks
     *
     * @param deckType
     * @param numberOfDecks an integer that signifies the number of decks that are in Vegas
     */
    public void createDeck(String deckType, int numberOfDecks) {
        if (!deckType.equals("Vegas")) {
            logger.info("Cannot recognize deckType, you can only specify the deck number of Vegas.");
        } else {
            this.deck = new VegasImpl(numberOfDecks);
        }

    }

    /**
     * Set the number of hands in this game
     * @param numberOfHands an integer that signifies the number of hands
     */
    public void setNumberOfHands(int numberOfHands) {
        this.hands = new Hand[numberOfHands];
        for(int i=0; i<numberOfHands; i++){
            hands[i] = new HandImpl();
        }
    }

    /**
     * Pull NumberOfHands Cards from deck and give it to every Hand
     */
    public void deal() {
        try{
            for (Hand hand : hands) {
                if (!deck.emptyDeck()) {
                    Card card = deck.pullCard();
                    hand.accept(card);
                } else {
                    logger.info("Remaining cards is not enough for hands.");
                }
            }
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }

    }

    /**
     * Return a copy of hand array for testing purpose
     * @return
     */
    public Hand[] getHands() {
        return Arrays.copyOfRange(hands, 0, hands.length);
    }
}

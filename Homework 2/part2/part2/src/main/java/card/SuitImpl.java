package card;

import utils.Constants;

import java.util.logging.Logger;

/**
 * This class implement Suit interface and includes the basic methods that are related to a card's suit.
 * @author Yang Xia
 * 09/24/2018
 */
public class SuitImpl implements Suit {

    private static final Logger logger = Logger.getLogger(Suit.class.getName());
    private String name;
    private char symbol;

    /**
     * Construct a SuitImpl class given a valid suit name
     * @param name: a valid suit name
     */
    public SuitImpl(String name){
        this.name = name;
        try{
            this.symbol = Constants.getSuitMap().get(name);
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }

    }

    /**
     * Return the name of the card.Suit, i.e, club, diamond, heart, spade
     * @return a String that denotes the name of the suit
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the symbol of the card.Suit, i.e, ♣, ♦, ♥, and, ♠
     * @return a char that denotes the symbol of the suit
     */
    public char getSymbol() {
        return symbol;
    }
}

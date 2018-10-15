package card;

import utils.Constants;

import java.util.logging.Logger;

/**
 * This class implement rank interface and provides basic methods that are related to a card's rank.
 * @author Yang Xia
 * 09/24/2018
 */

public class RankImpl implements Rank {
    private static final Logger logger = Logger.getLogger(Rank.class.getName());
    private String name;
    private int pips;

    /**
     * Construct a RankImpl class given a valid rank name
     * @param name: a valid rank name
     */
    public RankImpl (String name){
        this.name = name;
        try{
            this.pips = Constants.getRankMap().get(name);
        }
        catch (Exception e){
            logger.info(e.getMessage());
        }

    }

    /**
     * Return the name of the rank, e.g One, Two, Three
     * @return a string that represent the rank of the card
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the pips of the rank
     * @return an integer that denotes the pips of the rank
     */
    public int getPips() {
        return pips;
    }
}

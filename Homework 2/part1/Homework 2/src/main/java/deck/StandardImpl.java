package deck;

import card.*;
import utils.Constants;

import java.util.ArrayList;

/**
 * This class extends AbstractDeck and creates a Standard Deck
 * @author Yang Xia
 * 10/06/2018
 */
public class StandardImpl extends AbstractDeck {

    /**
     * Construct a Standard Deck by putting all cards of four suits in it
     */
    public StandardImpl() {
        super.cards = new ArrayList<Card>();
        for (String rankName : Constants.getRankMap().keySet()) {
            Rank rank = new RankImpl(rankName);
            for (String suitName : Constants.getSuitMap().keySet()) {
                Suit suit = new SuitImpl(suitName);
                Card card = new CardImpl(rank, suit);
                super.cards.add(card);
            }
        }

    }

    /**
     *Return the number of cards a deck "should" have
     * @return an int represent a fixed number given by the game
     */
    public int officialSize() {
        return Constants.STANDARDDECK_NUM;
    }
}

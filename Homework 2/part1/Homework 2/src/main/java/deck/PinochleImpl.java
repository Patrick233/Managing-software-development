package deck;

import card.*;
import utils.Constants;

import java.util.*;

/**
 * This class extends AbstractDeck and creates a Pinochle Deck
 * @author Yang Xia
 * 10/06/2018
 */
public class PinochleImpl extends AbstractDeck {

    /**
     * Construct a Pinochle Deck by putting 9, 10, J, Q, K and A of four suits and two copies in it
     */
    public PinochleImpl() {
        super.cards = new ArrayList<Card>();
        Set<String> pinochleSet = Constants.getPinochleRank();
        for (String rankName : Constants.getRankMap().keySet()) {
            if (pinochleSet.contains(rankName)) {
                Rank rank = new RankImpl(rankName);
                for (String suitName : Constants.getSuitMap().keySet()) {
                    Suit suit = new SuitImpl(suitName);
                    Card card = new CardImpl(rank, suit);
                    super.cards.add(card);
                    super.cards.add(card);
                }
            }
        }

    }

    /**
     *Return the number of cards a deck "should" have
     * @return an int represent a fixed number given by the game
     */
    public int officialSize() {
        return Constants.PINOCHLEDECK_NUM;
    }
}

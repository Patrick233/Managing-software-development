package deck;

import card.*;
import utils.Constants;

import java.util.ArrayList;
import java.util.Set;

/**
 * This class extends AbstractDeck and creates a Euchre Deck
 * @author Yang Xia
 * 10/06/2018
 */
public class EuchreImpl extends AbstractDeck {

    /**
     * Construct a Euchre Deck by putting 9, 10, J, Q, K and A of four suits
     */
    public EuchreImpl() {
        super.cards = new ArrayList<Card>();
        Set<String> getEuchreCard = Constants.getEuchreRank();
        for (String rankName : Constants.getRankMap().keySet()) {
            if (getEuchreCard.contains(rankName)) {
                Rank rank = new RankImpl(rankName);
                for (String suitName : Constants.getSuitMap().keySet()) {
                    Suit suit = new SuitImpl(suitName);
                    Card card = new CardImpl(rank, suit);
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
        return Constants.EUCHREDECK_NUM;
    }
}

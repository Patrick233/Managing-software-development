package deck;

import card.*;
import utils.Constants;

import java.util.ArrayList;

/**
 * This class extends AbstractDeck and creates a Vegas Deck
 * @author Yang Xia
 * 10/06/2018
 */
public class VegasImpl extends AbstractDeck {

    private int deckNum;

    /**
     * Construct a Vegas Deck given the number of standard decks in it
     * @param deckNum the number of standard decks given by user
     */
    public VegasImpl(int deckNum) {
        this.deckNum = deckNum;
        super.cards = new ArrayList<Card>();
        for(int i=1; i<= deckNum; i++){
            for (String rankName : Constants.getRankMap().keySet()) {
                Rank rank = new RankImpl(rankName);
                for (String suitName : Constants.getSuitMap().keySet()) {
                    Suit suit = new SuitImpl(suitName);
                    Card card = new CardImpl(rank, suit);
                    cards.add(card);
                }
            }
        }
    }

    /**
     * Construct a Vegas Deck by 6(by default) standard decks in it
     */
    public VegasImpl(){
        super.cards = new ArrayList<Card>();
        deckNum = 6;
        for(int i=1; i<= deckNum; i++){
            for (String rankName : Constants.getRankMap().keySet()) {
                Rank rank = new RankImpl(rankName);
                for (String suitName : Constants.getSuitMap().keySet()) {
                    Suit suit = new SuitImpl(suitName);
                    Card card = new CardImpl(rank, suit);
                    cards.add(card);
                }
            }
        }
    }

    /**
     *Return the number of cards a deck "should" have
     * @return an int represent a fixed number given by the game
     */
    public int officialSize() {
        return deckNum*Constants.VEGASDECK_NUM;
    }
}

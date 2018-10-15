package hand;

import card.Card;
import card.CardCompare;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class gives a concrete implementation of Hand interface
 * @author Yang Xia
 * 10/10/2018
 */
public class HandImpl implements Hand{
    private static final Logger logger = Logger.getLogger(Hand.class.getName());
    private List<Card> cards;

    /**
     * Default constructor
     */
    public HandImpl(){
        cards = new ArrayList<>();
    }

    /**
     * @return The cards in a hand
     */
    public List<Card> showCards() {
        return cards;
    }

    /**
     * Takes in a Card and put it in Hand, order doesn't matter
     * @param card the card to be added
     */

    public void accept(Card card) {
        try{
            cards.add(card);
        }
        catch (NullPointerException e){
            logger.info(e.getMessage());
        }
    }

    /**
     * @return the top Card in hand
     */
    public Card pullCard() {
        try{
            Card firstCard = cards.get(0);
            cards.remove(0);
            return firstCard;
        }
        catch (Exception e){
            logger.info("Cannot pull. " + e.getMessage());
            return null;
        }

    }

    /**
     * Check if this Hand has the given Card
     * @param card the Card to be checked
     * @return True if hand has the card, false otherwise
     */
    public Boolean hasCard(Card card) {
        for(Card c: cards){
            if(Utils.cardsEqual(card, c)){
                return true;
            }
        }
        return false;
    }

    /**
     * Sort the hand based on the given Type
     * @param bySuitRankBoth one of the following: Rank, Suit, Both
     */
    public void sort(String bySuitRankBoth) {
        switch (bySuitRankBoth) {
            case "Rank":
                cards.sort(CardCompare.getCompareByRank());
                break;
            case "Suit":
                cards.sort(CardCompare.getCompareBySuit());
                break;
            case "Both":
                cards.sort(CardCompare.getCompareByBoth());
                break;
            default:
                logger.info("Cannot recognize sort type. Please make sure the input String is Rank, Suit, or Both");
                break;
        }
    }

    /**
     * After shuffle, the cards in hand should have different order
     */
    public void shuffle() {
        if(cards.size() <=1){
            return;
        }
        List<Card> copy = new ArrayList<>(cards);
        while(copy.equals(cards)){
            Collections.shuffle(cards);
        }
    }
}

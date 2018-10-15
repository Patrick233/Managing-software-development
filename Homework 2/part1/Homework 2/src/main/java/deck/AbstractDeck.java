package deck;

import card.*;

import java.util.*;
import java.util.logging.Logger;

/**
 * This Abstract class implements Deck Interface and gives implementations on common methods like cut and sort
 * @author Yang Xia
 * 10/06/2018
 */
public abstract class AbstractDeck implements Deck{

    private static final Logger logger = Logger.getLogger(Deck.class.getName());
    protected List<Card> cards;

    /**
     * Shuffle the cards in the deck, meaning teh cards within the deck are randomly ordered.
     */
    public void shuffle() {
        List<Card> copy = new ArrayList<>(cards);
        if(cards.size() != 1) {
            while(cards.equals(copy)) {
                Collections.shuffle(cards);
            }
        }
    }

    /**
     * Sort the deck on rank, suit, or both
     * @param type a String that indicates whether sort by rank, suit or both.
     */
    public void sort(String type) {

        switch (type) {
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
     * Cut the deck, meaning the point in the deck is selected and the first half of the deck is placed at the end in order.
     * @param cutPoint the position where the deck is cut
     */
    public void cut(int cutPoint){
        if(cutPoint<0 || cutPoint> cards.size()){
            logger.info("Card point invalid, please check");
            return;
        }
        for(int i= 0; i< cutPoint; i++){
            Card firstCard = cards.get(0);
            cards.add(firstCard);
            cards.remove(firstCard);
        }
    }

    /**
     * Pull put the first card from the deck
     * @return the card on top of the deck
     */
    public Card pullCard() {
        try{
            Card firstCard = cards.get(0);
            cards.remove(0);
            return firstCard;
        }
        catch (Exception e){
            logger.info("Can't pull because deck is empty. " + e.getMessage());
            return null;
        }
    }

    /**
     * Check if the deck is empty
     * @return true if the deck is empty
     */
    public Boolean emptyDeck() {
        try{
            return cards.isEmpty();
        }
        catch (NullPointerException e){
            logger.info("Cards haven't been instantiated. " + e.getMessage());
            return true;
        }
    }


}

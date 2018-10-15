package deck;

import card.Card;

/**
 * deck interface includes the basic methods that are related to a deck.
 * @author Yang Xia
 * 09/27/2018
 */
public interface Deck {

    /**
     * Shuffle the cards in the deck, meaning teh cards within the deck are randomly ordered.
     */
    void shuffle();

    /**
     * Sort the deck on rank, suit, or both
     * @param type a String that indicates whether sort by rank, suit or both.
     */
    void sort(String type);

    /**
     * Cut the deck, meaning the point in the deck is selected and the first half of the deck is placed at the end in order.
     * @param cutPoint the position where the deck is cut
     */
    void cut(int cutPoint);

    /**
     * Pull put the first card from the deck
     * @return the card on top of the deck
     */
    Card pullCard(); // from top of deck

    /**
     * Check if the deck is empty
     * @return true if the deck is empty
     */
    Boolean emptyDeck();

    /**
     *Return the number of cards a deck "should" have
     * @return an int represent a fixed number given by the game
     */
    int officialSize();

}

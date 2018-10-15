package card;

/**
 * card.Rank interface includes the basic methods that are related to a card's rank.
 * @author Yang Xia
 * 09/24/2018
 */
public interface Rank {

    /**
     * Return the name of the rank, e.g One, Two, Three
     * @return a string that represent the rank of the card
     */
    String getName();

    /**
     * Returns the pips of the rank
     * @return an integer that denotes the pips of the rank
     */
    int getPips();
}

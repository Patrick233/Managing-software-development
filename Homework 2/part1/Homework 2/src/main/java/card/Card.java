package card;

/**
 * card.Card interface includes the basic methods that are related to a card.
 * @author Yang Xia
 * 09/27/2018
 */
public interface Card {

    /**
     * Return a Rank class of a specific card
     * @return Rank that contains name and pips
     */
    Rank getRank();

    /**
     * Return a Suit class of a specific card
     * @return Suit that contains name and symbol
     */
    Suit getSuit();
}

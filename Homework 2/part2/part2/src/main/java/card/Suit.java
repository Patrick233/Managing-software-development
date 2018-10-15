package card;

/**
 * card.Suit interface includes the basic methods that are related to a card's suit.
 * @author Yang Xia
 * 09/24/2018
 */
public interface Suit {

    /**
     * Return the name of the card.Suit, i.e, club, diamond, heart, spade
     * @return a String that denotes the name of the suit
     */
    String getName();

    /**
     * Returns the symbol of the card.Suit, i.e, ♣, ♦, ♥, and, ♠
     * @return a char that denotes the symbol of the suit
     */
    char getSymbol();
}

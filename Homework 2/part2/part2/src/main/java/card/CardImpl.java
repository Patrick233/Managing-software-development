package card;

/**
 * This class implements Card interface, it includes the basic methods that are related to a card.
 * @author Yang Xia
 * 09/27/2018
 */
public class CardImpl implements Card {

    private Rank cardRank;
    private Suit cardSuit;

    /**
     * CardImp class constructor
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public CardImpl (Rank rank, Suit suit){
        this.cardRank = rank;
        this.cardSuit = suit;
    }

    /**
     * Return a Rank class of a specific card
     * @return Rank that contains name and pips
     */
    public Rank getRank() {
        return cardRank;
    }

    /**
     * Return a Suit class of a specific card
     * @return Suit that contains name and symbol
     */
    public Suit getSuit() {
        return cardSuit;
    }

}

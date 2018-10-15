package hand;

import card.Card;

import java.util.List;

public interface Hand {

    /**
     * @return The cards in a hand
     */
    List<Card> showCards();

    /**
     * Takes in a Card and put it in Hand, order doesn't matter
     * @param card the card to be added
     */
    void accept(Card card);

    /**
     * @return the top Card in hand
     */
    Card pullCard();

    /**
     * Check if this Hand has the given Card
     * @param card the Card to be checked
     * @return True if hand has the card, false otherwise
     */
    Boolean hasCard(Card card);

    /**
     * Sort the hand based on the given Type
     * @param bySuitRankBoth one of the following: Rank, Suit, Both
     */
    void sort(String bySuitRankBoth);

    /**
     * After shuffle, the cards in hand should have different order
     */
    void shuffle();
}

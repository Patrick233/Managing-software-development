package utils;

import card.Card;
import card.CardCompare;

import java.util.List;
/**
 * This class provides some useful ult functions that are used across project
 * @author Yang Xia
 * 09/24/2018
 */
public class Utils {
    /**
     * Default constructor
     */
    private Utils() {
    }

    /**
     * Takes in 2 Cards and see if they are equal. Equal meaning they have the same rank and same suit.
     * @param c1 Card to be compared
     * @param c2 Card to be compared
     * @return true if they have the same Rank and Suit
     */
    public static boolean cardsEqual(Card c1, Card c2){
        return (c1.getRank().getName().equals(c2.getRank().getName()) &&
                c1.getRank().getPips() == c2.getRank().getPips() &&
                c1.getSuit().getName().equals(c2.getSuit().getName()) &&
                c1.getSuit().getSymbol() == c2.getSuit().getSymbol()
                );
    }

    /**
     * Check if the given card list is sorted, according to sort Type
     * @param cards The card list to be checked
     * @param type Either Rank, Suit, or Both
     * @return True if the list is sorted accordingly
     */
    public static boolean isSorted(List<Card> cards, String type) {
        if (cards.size() <= 1) return true;
        Card prev = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
            Card elem = cards.get(i);
            switch (type) {
                case "Rank":
                    if (CardCompare.getCompareByRank().compare(prev, elem) > 0) {
                        return false;
                    }
                    break;
                case "Suit":
                    if (CardCompare.getCompareBySuit().compare(prev, elem) > 0) {
                        return false;
                    }
                    break;
                case "Both":
                    if (CardCompare.getCompareByBoth().compare(prev, elem) > 0) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            prev = elem;
        }

        return true;
    }
}

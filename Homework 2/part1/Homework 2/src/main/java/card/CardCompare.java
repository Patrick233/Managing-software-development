package card;

import utils.Constants;

import java.util.Comparator;
import java.util.List;

/**
 * This class provides several Card comparators that I'll later use for sorting purpose
 * @author Yang Xia
 * 10/06/2018
 */
public class CardCompare {

    /**
     * Default Constructor
     */
    private CardCompare(){
    }

    /**
     * This class implement a Comparator that compares 2 Cards by Rank
     */
    public static class CompareByRank implements Comparator<Card>
    {
        List<String> rankOrder = Constants.getRankOrder();

        /**
         * Compare 2 cards by their Rank
         * @param a first card
         * @param b second card
         * @return 1 if a is greater than b, 0 if equal, -1 if b is greater than a
         */
        public int compare(Card a, Card b)
        {
            return rankOrder.indexOf(a.getRank().getName()) - rankOrder.indexOf(b.getRank().getName());
        }
    }

    /**
     * This class implement a Comparator that compares 2 Cards by Suit
     */
    public static class CompareBySuit implements Comparator<Card>
    {
        List<String> suitOrder = Constants.getSuitOrder();
        /**
         * Compare 2 cards by their Suit
         * @param a first card
         * @param b second card
         * @return 1 if a is greater than b, 0 if equal, -1 if b is greater than a
         */
        public int compare(Card a, Card b)
        {
            return suitOrder.indexOf(a.getSuit().getName()) - suitOrder.indexOf(b.getSuit().getName());
        }
    }

    /**
     * This class implement a Comparator that compares 2 Cards by both Rank and Suit
     */
    public static class CompareByBoth implements Comparator<Card>
    {
        List<String> rankOrder = Constants.getRankOrder();
        List<String> suitOrder = Constants.getSuitOrder();
        /**
         * Compare 2 cards by their Rank and Suit
         * @param a first card
         * @param b second card
         * @return 1 if a is greater than b, 0 if equal, -1 if b is greater than a
         */
        public int compare(Card a, Card b)
        {
            if(a.getRank().getName().equals(b.getRank().getName())){
                return suitOrder.indexOf(a.getSuit().getName()) - suitOrder.indexOf(b.getSuit().getName());
            }
            else {
                return rankOrder.indexOf(a.getRank().getName()) - rankOrder.indexOf(b.getRank().getName());
            }

        }
    }

    /**
     * @return a new CompareByRank Class
     */
    public static CompareByRank getCompareByRank(){
        return new CompareByRank();
    }

    /**
     * @return a new CompareBySuit Class
     */
    public static CompareBySuit getCompareBySuit(){
        return new CompareBySuit();
    }

    /**
     * @return a new CompareByBoth Class
     */
    public static CompareByBoth getCompareByBoth(){
        return new CompareByBoth();
    }

}

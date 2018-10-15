package utils;

import java.util.*;

/**
 * This class provides constants that are going to be used in the Card package.
 *
 * @author Yang Xia
 * 09/24/2018
 */
public class Constants {

    private Constants(){}

    public static final String STANDARD = "Standard";
    public static final String EUCHRE = "Euchre";
    public static final String PINOCHLE = "Pinochle";
    public static final String VEGAS = "Vegas";

    public static final int EUCHREDECK_NUM = 24;
    public static final int PINOCHLEDECK_NUM = 48;
    public static final int STANDARDDECK_NUM = 52;
    public static final int VEGASDECK_NUM = 52;
    private static final String QUEEN = "Queen";


    /**
     * Construct a mapping between the rank name and the rank pips
     *
     * @return a map that contains the relation between rank name and default pips
     */
    public static Map<String, Integer> getRankMap() {
        Map<String, Integer> rankMap = new HashMap<>();

        rankMap.put("Two", 2);
        rankMap.put("Three", 3);
        rankMap.put("Four", 4);
        rankMap.put("Five", 5);
        rankMap.put("Six", 6);
        rankMap.put("Seven", 7);
        rankMap.put("Eight", 8);
        rankMap.put("Nine", 9);
        rankMap.put("Ten", 10);
        rankMap.put("Jack", 0);
        rankMap.put(QUEEN, 0);
        rankMap.put("King", 0);
        rankMap.put("Ace", 1);

        return rankMap;
    }

    /**
     * Construct a mapping between the suit name and suit characters
     *
     * @return a map that contains the relation between suit name and their representation
     */
    public static Map<String, Character> getSuitMap() {
        Map<String, Character> suitMap = new HashMap<>();

        suitMap.put("club", '♣');
        suitMap.put("diamond", '♦');
        suitMap.put("heart", '♥');
        suitMap.put("spade", '♠');

        return suitMap;
    }

    /**
     * Construct a set that contains the valid Pinochle Rank name
     *
     * @return a set that contains the valid Pinochle Rank name
     */
    public static Set<String> getPinochleRank() {
        Set<String> pinochleSet = new HashSet<>();
        pinochleSet.add("Nine");
        pinochleSet.add("Ten");
        pinochleSet.add("Jack");
        pinochleSet.add(QUEEN);
        pinochleSet.add("King");
        pinochleSet.add("Ace");

        return pinochleSet;
    }

    /**
     * Construct a set that contains the valid Euchre Rank name
     *
     * @return a set that contains the valid Euchre Rank name
     */
    public static Set<String> getEuchreRank() {
        Set<String> euchreSet = new HashSet<>();
        euchreSet.add("Nine");
        euchreSet.add("Ten");
        euchreSet.add("Jack");
        euchreSet.add(QUEEN);
        euchreSet.add("King");
        euchreSet.add("Ace");

        return euchreSet;
    }

    /**
     * Construct a list that pertains the order of Rank
     *
     * @return a list that pertains the order of Rank
     */
    public static List<String> getRankOrder() {
        return new ArrayList<>(Arrays.asList(
                "Ace",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Jack",
                QUEEN,
                "King"));
    }

    /**
     * Construct a list that pertains the order of Suit
     *
     * @return a list that pertains the order of Suit
     */
    public static List<String> getSuitOrder() {
        return new ArrayList<>(Arrays.asList(
                "spade",
                "heart",
                "club",
                "diamond"
        ));
    }

}

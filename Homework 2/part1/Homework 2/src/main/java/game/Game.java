package game;

/**
 * Game interface includes the basic methods that are related to a Game.
 * @author Yang Xia
 * 09/27/2018
 */
public interface Game {

    /**
     * Create one of the following deck: Standard, Pinochle, Euchre, 6 decks Vegas
     * @param deckType
     */
    void createDeck(String deckType);

    /**
     * Create a Vegas Deck with the given number of standard decks
     * @param deckType
     * @param numberOfDecks an integer that signifies the number of decks that are in Vegas
     */
    void createDeck(String deckType, int numberOfDecks);

    /**
     * Set the number of hands in this game
     * @param numberOfHands an integer that signifies the number of hands
     */
    void setNumberOfHands(int numberOfHands);

    /**
     * Pull NumberOfHands Cards from deck and give it to every Hand
     */
    void deal();
}

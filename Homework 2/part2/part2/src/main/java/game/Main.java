package game;

/**
 * This main class actually create some games
 * @author Yang Xia
 * 10/11/2018
 */
public class Main {
    public static void main(String[] args){

        CardGame standardFiveHandGame = new StandardDeckGame();
        Game standardFive = standardFiveHandGame.createGame(5);
        standardFive.deal();

        CardGame euchreFiveHandGame = new EuchreGame();
        Game euchreGame = euchreFiveHandGame.createGame(5);
        euchreGame.deal();

        CardGame pinochleFiveHandGame = new PinochleGame();
        Game pinochleGame = pinochleFiveHandGame.createGame(5);
        pinochleGame.deal();

        CardGame vegasFiveGame = new VegasDeckGame();
        Game vegasGame = vegasFiveGame.createGame(5);
        vegasGame.deal();

    }
}

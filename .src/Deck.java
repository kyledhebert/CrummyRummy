import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kylehebert on 2/19/15.
 */

/**
 *This object represents a standard deck of playing cards.
 * The deck contains 52 cards. After the initial deal, the
 * deck will become the Stock.
 */

public class Deck {

    /**
     * An array of 52 cards.
     */
    private Card deck[];

    /**
     * Keeps tracks of cards dealt to players as well
     * cards drawn from deck, once deck becomes the Stock.
     */
    private int cardsUsed;

    /**
     * Constructs the deck. The cards are generated in order,
     * but will be shuffled later.
     */
    public Deck() {
        this.deck = new Card[52];
        int cardCount = 0; //tracks how many cards have been created
        for (int suit = 0; suit <=3; suit++) {
            for (int value = 1; value <= 13; value ++) {
                deck[cardCount] = new Card(suit, value);
                cardCount++;
            }
        }
        cardsUsed = 0;
    }

    /**
     * Shuffle all of the cards into the deck
     * in a random order.
     */
    public void Shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int randNum = (int)(Math.random()*(i +1));
            Card cardToShuffle = deck[i];
            deck[i] = deck[randNum];
            deck[randNum] = cardToShuffle;

        }
        cardsUsed = 0;
    }

    /**
     * deals the top card from the deck, this will
     * deal the initial hand to each player, as well
     * as be called when a player draws from stock
     */
    public Card dealCard() {
        cardsUsed++;
        return deck[cardsUsed-1];

    }
}

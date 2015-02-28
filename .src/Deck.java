import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 *Objects of this class represent a standard deck of playing cards.
 * The deck contains 52 cards. After the initial deal, the
 * deck will become the Stock.
 */

public class Deck {

    /**
     * An array of 52 cards.
     */
    private ArrayList<Card> deck = new ArrayList<Card>();

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
        this.deck = new ArrayList<Card>();
        int cardCount = 0; //tracks how many cards have been created
        for (int suit = 0; suit <=3; suit++) {
            for (int value = 1; value <= 13; value ++) {
                deck.add(cardCount,new Card(suit, value));
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
        Collections.shuffle(deck);
        cardsUsed = 0;

    }



    /**
     * deals the top card from the deck, this will
     * deal the initial hand to each player, as well
     * as be called when a player draws from stock
     */
    public Card dealCard() {
        cardsUsed++;
        return deck.get(cardsUsed-1);

    }

    public int getCardsLeft() {
        return deck.size();
    }
}



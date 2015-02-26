import java.util.ArrayList;
import java.util.Iterator;

/**
 * Objects of this class represent a hand of cards.
 * The hand is empty when created. Cards are
 * added via deal or draw. There is no limit
 * to the number of cards a hand can hold.
 */
public class Hand {

    private ArrayList<Card> hand;

    /**
     * create an empty hand
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }


    /**
     * returns the number of cards in the hand
     */
    public int getNumberOfCards() {
        return hand.size();
    }




    /**
     * add a card to the deck when the player or NPC
     * draws from discard or stock pile
     */
    public void addCard(Card c) {
            hand.add(c);
    }

    /**
     * discard a card
     */
    public void discardCard(Card c) {

    }


}

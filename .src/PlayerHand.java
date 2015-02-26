import java.util.ArrayList;
import java.util.Iterator;

/**
 * Objects of this class represent the player's Hand.
 * This class extends the Hand class.
 */
public class PlayerHand extends Hand {

    private ArrayList<Card> playerHand;

    /**
     * create an empty player hand
     */
    public PlayerHand() {
        playerHand = new ArrayList<Card>();
    }
    /**
     * displays the player hand
     */
    public void showCards()  {
        for (Card card: playerHand) {
            System.out.println((card.getCardAsString()));
        }


    }

}

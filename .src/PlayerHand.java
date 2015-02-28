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



}

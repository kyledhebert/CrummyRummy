import java.util.ArrayList;

/**
 * Objects of this class will represent runs or books
 * in the player's hands or that have been played to the table.
 */
public class Meld {

    private ArrayList<Hand> meld ;

    /**
     * create an empty meld
     */
    public Meld() {
        meld = new ArrayList<Hand>();
    }

    /**
     * method for adding hands to a meld
     */

    public void addHand(Hand h) {
        meld.add(h);
    }
}

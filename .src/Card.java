/**
 * Created by kylehebert on 2/19/15.
 */
public class Card {

    static final char Hearts = '\u2665';
    static final char Diamonds = '\u2666';
    static final char Clubs = '\u2663';
    static final char Spades = '\u2660';

    static final int Ace = 1;
    static final int Jack = 11;
    static final int Queen = 12;
    static final int King = 13;

    private int value;
    private int suit;

    //Constructor


    public Card(int cardValue, int cardSuit) {
        this.value = cardValue;
        this.suit = cardSuit;
    }
}

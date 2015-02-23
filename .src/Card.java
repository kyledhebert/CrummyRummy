/**
 * Object of this class represent a single card from
 * a standard deck of playing cards. Each card has a suit and 1
 * of 13 possible values Ace, 1, 2 ... Jack, Queen, King.
 */
public class Card {

    public static final int Hearts = 0;
    public static final int Diamonds = 1;
    public static final int Clubs = 2;
    public static final int Spades =4;

    public static final int Ace = 1;
    public static final int Jack = 11;
    public static final int Queen = 12;
    public static final int King = 13;

    //a single card's value
    private int value;

    //a single card's suit
    private int suit;

    //creates a card with a suit and value
    public Card(int cardValue, int cardSuit) {
        this.value = cardValue;
        this.suit = cardSuit;
    }

    //returns the suit of the card
    public int getSuit() {
        return suit;
    }

    //returns the value of the card
    public int getValue() {
        return value;
    }

    /**
     * returns the card's suit as a unicode char
     * useful for displaying cards in the hand,
     * or top of the discard pile
     */
    public char getSuitAsChar() {
        switch(suit) {
            case Hearts: return '\u2665';
            case Diamonds: return '\u2666';
            case Clubs: return '\u2663';
            default: return '\u2660';
        }

    }

    /**
     * returns the value of the card as a String
     * @return Ace, "2", "3", ... "10", "Jack",
     * "Queen", "King".
     */
    public String getValueAsString() {
        switch (value) {
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            default: return "King";
        }

    }

    /**
     * returns the entire card as a string
     * examples: "Ace of Spades", "Queen of Hearts"
     */
    public String getCardAsString() {
        return getValueAsString() + " of " + getSuitAsChar();
    }


}

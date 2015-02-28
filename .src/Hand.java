import java.util.ArrayList;
import java.util.Collections;


/**
 * Objects of this class represent a hand of cards.
 * The hand is empty when created. Cards are
 * added via deal or draw. There is no limit
 * to the number of cards a hand can hold.
 */
public  class Hand {

    private ArrayList<Card> hand; //the cards in the hand

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
     * displays the cards currently held in hand
     */
    public void displayHand() {
        System.out.println("Your current hand:");
        for (Card card : hand) {
            System.out.println(card.getCardAsString());
        }
    }
    //TODO ADD METHODS FOR SORTING CARDS BY SUIT AND VALUE
    /**
     * sorts the cards in the hand by suit, and orders
     * them by value within each suit.
     */


    /**
     * adds a card drawn from stock or discard
     * to the hand
     */
    public void addCard(Card c) {
        hand.add(c);
    }

    /**
     * get a card from the hand
     */
    public Card getCard(int i) {
        return (Card) hand.get(i);

    }

    /**
     * discard a card
     */
    public void discardCard(Card c) {

    }

    /**
     * In order to check for available plays, the hand will
     * first be sorted by value in ascending order. Cards with
     * the same value will be sorted by suit. This will also be
     * available to the player as a way of displaying their sorted hand.
     */
    public void sortHandByValue() {
        ArrayList<Card> valueSortedHand = new ArrayList<Card>();
        while (hand.size() > 0) {
            int lowestPosition = 0;
            Card card = hand.get(0);
            for (int i = 1; i < hand.size(); i++) {
                Card card1 = hand.get(i);
                if (card1.getValue() < card.getValue() || (card1.getValue() == card.getValue() && card1.getSuit() < card.getSuit())) {
                    lowestPosition = i;
                    card = card1;
                }
            }
            hand.remove(lowestPosition);
            valueSortedHand.add(card);
        }
        hand = valueSortedHand;
    }


    /**
     * ranks the plays available in the current hand.
     * Rank will determine which play the NPC will make.
     * Ranks are:
     * Run of four or more = 4
     * Four of a Kind = 3
     * Run of three = 2
     * Three of a Kind = 1
     * No Play = 0
     */
    public void rankAvailablePlays(Hand hand) {
        Meld availablePlays = new Meld();
        int rank = 0;

        //check for four of a kind
        for (int i = 0; i < hand.getNumberOfCards() - 4; i++) {
            if (hand.getCard(i).getValue() == hand.getCard(i + 1).getValue() &&
                    hand.getCard(i + 1).getValue() == hand.getCard(i + 2).getValue() &&
                    hand.getCard(i + 2).getValue() == hand.getCard(i + 3).getValue()) {
                Hand fourOfAKind = new Hand();
                fourOfAKind.addCard(hand.getCard(i));
                fourOfAKind.addCard(hand.getCard(i + 1));
                fourOfAKind.addCard(hand.getCard(i + 2));
                fourOfAKind.addCard(hand.getCard(i + 3));
                rank = 3;
                availablePlays.addHand(fourOfAKind);
            }
        }
        //check for three of a kind
        for (int i = 0; i < hand.getNumberOfCards() - 3; i++) {
            if (hand.getCard(i).getValue() == hand.getCard(i + 1).getValue() &&
                    hand.getCard(i + 1).getValue() == hand.getCard(i + 2).getValue()) {
                Hand threeOfAKind = new Hand();
                threeOfAKind.addCard(hand.getCard(i));
                threeOfAKind.addCard(hand.getCard(i + 1));
                threeOfAKind.addCard(hand.getCard(i + 2));
                rank = 1;
                availablePlays.addHand(threeOfAKind);
            }
        }
        //check for run of three
        for (int i = 0; i < hand.getNumberOfCards() - 3; i++) {
            if (hand.getCard(i).getValue() - hand.getCard(i + 2).getValue() == 2 &&
                    hand.getCard(i).getSuit() == hand.getCard(i + 1).getSuit() &&
                    hand.getCard(i + 1).getSuit() == hand.getCard(i = 2).getSuit()) {
                        Hand runOfThree = new Hand();
                        runOfThree.addCard(hand.getCard(i));
                        runOfThree.addCard(hand.getCard(i + 1));
                        runOfThree.addCard(hand.getCard(i + 2));
                        rank = 2;
                        availablePlays.addHand(runOfThree);
            }
        }
        //check for run of four or more
        //start by checking for a run of four
        for (int i = 0; i < hand.getNumberOfCards() - 4; i++) {
            if (hand.getCard(i).getValue() - hand.getCard(i + 3).getValue() == 3 &&
                    hand.getCard(i).getSuit() == hand.getCard(i + 1).getSuit() &&
                    hand.getCard(i + 1).getSuit() == hand.getCard(i + 2).getSuit() &&
                    hand.getCard(i + 2).getSuit() == hand.getCard(i + 3).getSuit()) {
                        Hand runOfFour = new Hand();
                        runOfFour.addCard(hand.getCard(i));
                        runOfFour.addCard(hand.getCard(i + 1));
                        runOfFour.addCard(hand.getCard(i + 2));
                        runOfFour.addCard(hand.getCard(i + 3));
                        rank = 4;
                        //now check for additional cards to add to the run
                        boolean addToRun = true;
                        while(addToRun) {
                            //if the modulo of last card in runOfFour and next card in hand
                            //is 1, then add next card to runOfFour, keep going until
                            //the end of hand is reached
                            for (int x = i + 4; x < hand.getNumberOfCards(); x++) {
                                if (hand.getCard(x).getValue() %
                                    hand.getCard(x - 1).getValue() == 1
                                    && hand.getCard(x).getSuit() ==
                                    hand.getCard(x - 1).getSuit()) {
                                    runOfFour.addCard(hand.getCard(x));
                                }else {
                                    addToRun = false;
                                }
                            }
                        }
            }
        }
    }





}

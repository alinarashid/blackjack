package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    // A Card is dealt to the Hand, and the Hand is responsible
    // for storing the card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to find its value,
    // then adds up all the values
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            card.flip(); // Turn the card over to see the value
            value += card.getPointValue();
            card.flip(); // Hide the card again
        }
        return value;
    }

    // Shows every card in the hand, like "K of Hearts, 5 of Spades"
    public String displayHand() {
        String result = "";
        for (Card card : cards) {
            card.flip();                                          // Turn it face up
            result += card.getValue() + " of " + card.getSuit() + ", ";
            card.flip();                                          // Hide it again
        }
        return result;
    }
}
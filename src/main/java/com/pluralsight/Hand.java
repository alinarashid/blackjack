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
        int aces = 0;
        for (Card card : cards) {
            // Turn the card over to see the value
            card.flip();
            int points = card.getPointValue();
            value += points;
            if (points == 11) {
                aces++;
            }
            // Hide the card again
            card.flip();
        }
        // Turn Aces from 11 into 1 while the hand is over 21
        while(value > 21 && aces >0 ){
            value-=10;
            aces--;
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
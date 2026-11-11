package com.pluralsight;

import java.util.Scanner;

public class BlackjackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ask for names and create the players
        System.out.print("Enter Player 1's name: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Enter Player 2's name: ");
        Player player2 = new Player(scanner.nextLine());

        // 2. Create the deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();

        // 3. Deal 2 cards to each player
        for (int i = 0; i < 2; i++) {
            player1.getHand().deal(deck.deal());
            player2.getHand().deal(deck.deal());
        }

        // 4. Show each player's hand value
        int score1 = player1.getHand().getValue();
        int score2 = player2.getHand().getValue();

        System.out.println(player1.getName() + ": " + player1.getHand().displayHand() + "→ " + score1);
        System.out.println(player2.getName() + ": " + player2.getHand().displayHand() + "→ " + score2);
        // 5. Pick the winner → Part B
    }
}
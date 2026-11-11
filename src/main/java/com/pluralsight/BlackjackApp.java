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

        // 4. Show each player's cards and score
        int score1 = player1.getHand().getValue();
        int score2 = player2.getHand().getValue();

        System.out.println(player1.getName() + ": " + player1.getHand().displayHand() + "→ " + score1);
        System.out.println(player2.getName() + ": " + player2.getHand().displayHand() + "→ " + score2);

        // 5. Pick the winner (closest to 21 without going over)
        boolean bust1 = score1 > 21;
        boolean bust2 = score2 > 21;

        if (bust1 && bust2) {
            System.out.println("Both players bust! No winner.");
        } else if (bust1) {
            System.out.println(player2.getName() + " wins!");
        } else if (bust2) {
            System.out.println(player1.getName() + " wins!");
        } else if (score1 > score2) {
            System.out.println(player1.getName() + " wins!");
        } else if (score2 > score1) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

    }
}
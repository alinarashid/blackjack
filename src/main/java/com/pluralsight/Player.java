package com.pluralsight;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();   // Every player starts with an empty hand
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}
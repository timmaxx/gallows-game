package com.timmax.game.gallows;

public class Game {
    private final String world;

    public Game(String world) {
        this.world = world;
    }

    public void gameLoop() {
        System.out.println("Game with word '" + world + "' is running.");
    }
}

package com.timmax.game.gallows;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private final String word;
    private final int maximumAttemptsNumber = 3;
    private static final Scanner scanner = new Scanner(System.in);

    public Game(String word) {
        this.word = word;
    }

    public void gameLoop() {
        int currentAttemptsNumber = maximumAttemptsNumber;
        Set<Character> openedLetters = new HashSet<>();

        while (currentAttemptsNumber > 0) {
            StringBuilder currentWord = new StringBuilder();
            //  Цикл по слову
            for (int i = 0; i < word.length(); i++) {
                if (openedLetters.contains(word.charAt(i))) {
                    currentWord.append(word.charAt(i));
                } else {
                    currentWord.append('*');
                }
            }

            System.out.println("Entered letters: " + openedLetters);
            System.out.println("Current word: " + currentWord);
            if(!currentWord.toString().contains(String.valueOf('*'))) {
                break;
            }

            System.out.println("You have " + currentAttemptsNumber + " attempts.");
            System.out.println("Enter one letter");
            char letter = scanner.nextLine().charAt(0);
            if(!word.contains(String.valueOf(letter)) && !openedLetters.contains(letter)) {
                currentAttemptsNumber--;
            }
            openedLetters.add(letter);
        }
        if (currentAttemptsNumber == 0) {
            System.out.println("You have not any attempts!");
            System.out.println("You lost!");
        } else {
            System.out.println("You win!");
        }
    }
}

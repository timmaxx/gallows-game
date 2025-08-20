package com.timmax.game.gallows;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MAXIMUM_ATTEMPTS_NUMBER = 3;

    public void gameLoop() {
        String word;
        int currentAttemptsNumber;
        Set<Character> openedLetters;

        while (true) {
            word = "asdf";
            currentAttemptsNumber = MAXIMUM_ATTEMPTS_NUMBER;
            openedLetters = new HashSet<>();
            System.out.println("New round");

            while (currentAttemptsNumber > 0) {
                StringBuilder currentWord = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    if (openedLetters.contains(word.charAt(i))) {
                        currentWord.append(word.charAt(i));
                    } else {
                        currentWord.append('*');
                    }
                }

                System.out.println("Entered letters: " + openedLetters);
                System.out.println("Current word: " + currentWord);
                if (!currentWord.toString().contains(String.valueOf('*'))) {
                    break;
                }

                System.out.println("You have " + currentAttemptsNumber + " attempts.");
                System.out.println("Enter one letter");
                char letter = scanner.nextLine().charAt(0);
                if (!word.contains(String.valueOf(letter)) && !openedLetters.contains(letter)) {
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

            System.out.println("If you want to exit game, enter Q. Else you will begin next round.");

            String answer = scanner.nextLine();
            if (answer.equals("Q")) {
                break;
            }
        }
    }
}

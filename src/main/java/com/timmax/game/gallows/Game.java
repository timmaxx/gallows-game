package com.timmax.game.gallows;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);

    private static final int MAXIMUM_ATTEMPTS_NUMBER = 6;

    private String word;
    private StringBuilder currentWord;
    private int currentAttempt;
    private Set<Character> openedLetters;

    public void gameLoop() {
        while (true) {
            word = "asdf";  //  It needs to get a word from the dictionary
            currentAttempt = 0;
            openedLetters = new HashSet<>();
            System.out.println("==========");
            System.out.println("New round");

            while (currentAttempt < MAXIMUM_ATTEMPTS_NUMBER) {
                //  print message about one letter, scan it and check error
                System.out.println("Enter one letter and press key Enter");
                String line = scanner.nextLine();
                if (line.length() != 1) {
                    System.out.println("Invalid input: You entered not one character.");
                    continue;
                }
                char letter = line.charAt(0);
                if (letter < 'a' || letter > 'z') {
                    System.out.println("Invalid input: You entered not a letter.");
                    continue;
                }

                //  analyze an entered letter
                if (!word.contains(String.valueOf(letter)) && !openedLetters.contains(letter)) {
                    currentAttempt++;
                }
                openedLetters.add(letter);

                //  prepare and print current result
                currentWord = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    if (openedLetters.contains(word.charAt(i))) {
                        currentWord.append(word.charAt(i));
                    } else {
                        currentWord.append('*');
                    }
                }
                printGallows(currentAttempt);
                if (!currentWord.toString().contains(String.valueOf('*'))) {
                    break;
                }
                System.out.println("You have " + (MAXIMUM_ATTEMPTS_NUMBER - currentAttempt) + " attempts.");
            }

            //  print summary result
            if (currentAttempt >= MAXIMUM_ATTEMPTS_NUMBER) {
                System.out.println("You lost!");
            } else {
                System.out.println("You win!");
            }
            System.out.println("Target word is '" + word + "'");

            //  print exit condition and analyze it
            System.out.println("If you want to exit the game, enter 'Q'. Else you will begin a next round.");
            String answer = scanner.nextLine();
            if (answer.equals("Q")) {
                break;
            }
        }
    }

    void printGallows(int countOfError) {
        System.out.println("Current word: " + currentWord);
        System.out.println("Entered letters: " + openedLetters);
        System.out.println("" +
                "+---+\n" +
                "|   |\n" +
                "|   " + (countOfError > 0 ? "o" : " ") + "\n" +
                "|  " + (countOfError > 2 ? "/" : " ") + (countOfError > 1 ? "|" : " ") + (countOfError > 3 ? "\\" : " ") + "\n" +
                "|  " + (countOfError > 4 ? "/" : " ") + " " + (countOfError > 5 ? "\\" : " ") + "\n" +
                "|\n" +
                "-------");
    }
}

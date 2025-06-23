package service;

import model.*;
import java.util.Scanner;

public class WordleFinder {
    public static void main(String[] args) {
        //setup
        boolean quit = false;
        Trie root = new Trie();
        WordList.readFromFile(root, "ConsoleWordleFinder\\src\\data\\valid-wordle-words.txt");

        System.out.println("Welcome to Console Wordle Finder!");
        System.out.println("=================================");

        while (!quit) {
            printUI();

        }

    }

    public static void printUI() {
        System.out.println("Input Guess: 0");
        System.out.println("View Statistics: 1");
        System.out.println("Quit: 2\n");
        System.out.println("Correct Letters: ");
        System.out.println("Misplaced Letters: ");
        System.out.println("Incorrect Letters: ");
        System.out.println("=================================");
    }

    public static void userInput() {
        Scanner read = new Scanner(System.in);
        System.out.println("Input: ");
        String input = read.nextLine();

        switch (input) {
          case "0":
            //
            break;
          case "1":
            //
            break;
          case "2":
            //
            break;
          default:
            System.out.println();
            System.out.println("Invalid Input. Try Again");
            userInput();
            break;
        }
    }

}

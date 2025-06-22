package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;


public class WordList {
    //Implement a data structure to hold the list of words
    //Data structure should be loaded with valid-wordle-words.txt

    public static boolean isValid(String word, char [] correct, char [] misplaced, ArrayList<Character> incorrect) {
        //Check for correct placements
        for (int i = 0; i < correct.length; i++) {
            if (correct[i] != '\u0000' && word.charAt(i) != correct[i]) {
                return false;
            }
        }
        //Check for misplaced placements
        for (int i = 0; i < misplaced.length; i++) {
            if (misplaced[i] != '\u0000') {
                CharSequence c = String.valueOf(misplaced[i]);
                if (!word.contains(c)) {
                    return false;
                }
            }
        }

        //Check for any incorrect placements
        for (int i = 0; i < incorrect.size(); i++) {
            if (incorrect.get(i) != '\u0000') {
                CharSequence c = String.valueOf(incorrect.get(i));
                if (word.contains(c)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void readFromFile(Trie root, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim().toLowerCase();
                root.insertWord(word); //Inserting Word into Trie.
            }
        } catch (IOException e) {
            System.err.println("Error when reading file: " + e.getMessage());
        }
    }

}

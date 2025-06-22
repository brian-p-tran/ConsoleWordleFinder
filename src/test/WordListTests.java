package test;

import model.*;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordListTests {

    @Test
    public void readFromFileTest() {
        Trie root = new Trie();

        WordList.readFromFile(root, "ConsoleWordleFinder\\src\\data\\valid-wordle-words.txt");
        assertTrue(root.findWord("aalii"));
        assertFalse(root.findWord("meat"));
        assertTrue(root.isPrefix("meat"));

        assertFalse(root.findWord("qwert"));

    }

    @Test
    public void isValidTests() {
        char[] correct = new char[5];
        char[] misplaced = new char[5];
        ArrayList<Character> incorrect = new ArrayList<Character>();
        correct[0] = 'h';
        misplaced[2] = 'o';

        assertTrue(WordList.isValid("hello", correct, misplaced, incorrect));
        
        incorrect.add('o');

        assertFalse(WordList.isValid("hello", correct, misplaced, incorrect));

        misplaced[2] = 'i';

        assertFalse(WordList.isValid("hello", correct, misplaced, incorrect));
    }
}

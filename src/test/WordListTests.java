package test;

import model.*;
import data.*;

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
}

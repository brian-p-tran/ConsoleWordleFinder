package test;

import model.Trie;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrieTests {

    @Test
    public void trieBasicTests() {
        Trie root = new Trie();
        root.insertWord("bear");
        root.insertWord("bean");
        root.insertWord("bears");

        assertTrue(root.findWord("bear"));
        assertTrue(root.findWord("bean"));
        assertTrue(root.findWord("bears"));

        assertFalse(root.findWord("b"));
        assertFalse(root.findWord("be"));
        assertFalse(root.findWord("bea"));

        assertTrue(root.isPrefix("be"));
    }


}

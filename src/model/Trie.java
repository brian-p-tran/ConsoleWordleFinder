package model;

public class Trie {
    private Trie[] children;
    private boolean isWord;
    private int numOfChildren;
    private int rank;

    public Trie() {
        children = new Trie[26];
        isWord = false;
        numOfChildren = 1;
        rank = 0;
    }

    // O(n) length of String
    public void insertWord(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (curr.getChild(currentChar - 'a') == null) {
                this.numOfChildren += 1;
                curr.setChild(currentChar);
            }
            curr = curr.getChild(currentChar - 'a');
        }

        curr.setIsWord(true);
    }

    // O(n) length of String
    public boolean findWord(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (curr.getChild(currentChar - 'a') == null) return false;
            curr = curr.getChild(currentChar - 'a');
        }

        return curr.getIsWord();
    }

    // O(n) length of String
    public boolean isPrefix(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (curr.getChild(currentChar - 'a') == null) return false;
            curr = curr.getChild(currentChar - 'a');
        }

        return true;
    }

    public Trie getChild(int i) {
        return this.children[i];
    }

    public void setChild(char c) {
        Trie newTrie = new Trie();
        this.children[c - 'a'] = newTrie;
    }

    public boolean getIsWord() {
        return this.isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

}

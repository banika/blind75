package blind.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anindita Banik on 8/5/22.
 */
class Trienode{
    boolean word = false;
    Map<Character, Trienode> children = new HashMap<>();
    public Trienode() {}
}

class WordDictionary {

    Trienode root;
    public WordDictionary() {
        root = new Trienode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trienode node = root;
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c))
                node.children.put(c, new Trienode());
            node = node.children.get(c);
        }
        node.word = true;
    }

    /** Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, Trienode node) {
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.children.containsKey(c)){
                // if the current character is '.'
                // check all possible nodes at this level
                if(c=='.'){
                    for(char ch:node.children.keySet()){
                        Trienode child = node.children.get(ch);
                        if(searchInNode(word.substring(i+1), child))
                            return true;
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else{
                node = node.children.get(c);
            }
        }
        return node.word;
    }
}

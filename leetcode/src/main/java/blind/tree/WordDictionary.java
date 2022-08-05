package blind.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anindita Banik on 8/5/22.
 */
class Trienode{
    String word = "";
    Map<Integer, Trienode> children = new HashMap<>();
}
public class WordDictionary {

    Trienode root;

    public WordDictionary() {
        root = new Trienode();
    }

    public void addWord(String word) {
        Trienode node = root;
        for(Character c: word.toCharArray()){
            if(!node.children.containsKey(c-'a'))
                node.children.put(c-'a', new Trienode());
            node = node.children.get(c-'a');
        }
        node.word = word;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    /** Returns if the word is in the node. */
    public boolean searchInNode(String word, Trienode node) {
        for(int i=0;i<word.length();i++){
            int ch = word.charAt(i)-'a';
            if(!node.children.containsKey(ch)){
                if(ch=='.'){
                    for(Integer c: node.children.keySet()){
                        Trienode child = node.children.get(c);
                        if(searchInNode(word.substring(i+1), child))
                            return true;
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else{
                node = node.children.get(ch);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        System.out.println("Searching pad:"+dictionary.search("pad"));
        System.out.println("Searching bad:"+dictionary.search("bad"));
//        System.out.println("Searching pad:"+dictionary.search(".ad"));
//        System.out.println("Searching pad:"+dictionary.search("b.."));
    }
}

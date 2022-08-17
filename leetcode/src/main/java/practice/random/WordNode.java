package practice.random;

import java.util.LinkedList;

/**
 * Created by Anindita Banik on 8/14/22.
 */
public class WordNode {
    String word;
    LinkedList<String> path;

    public WordNode(String word){
        this.word = word;
        this.path = new LinkedList<>();
        this.path.add(word);
    }

    public WordNode(String word, LinkedList<String> paths){
        this.word = word;
        this.path = new LinkedList<>();
        this.path.addAll(paths);
        this.path.add(word);
    }
}

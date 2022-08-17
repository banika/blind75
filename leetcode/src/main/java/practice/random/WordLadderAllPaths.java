package practice.random;

import java.util.*;

/**
 * Created by Anindita Banik on 8/14/22.
 */
public class WordLadderAllPaths {

    Set<String> dictionary;
    Queue<WordNode> queue;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        dictionary = new HashSet<>(wordList);
        if(!dictionary.contains(endWord)) return result;

        queue = new LinkedList<>();
        queue.add(new WordNode(beginWord));

        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> removeSet = new HashSet<>();

            for(int i =0;i<size;i++){
                WordNode word = queue.poll();
                if(word.word.equals(endWord)){
                    result.add(word.path);
                } else {
                    List<String> neighbours = getNeighbours(word.word);
                    for(String n: neighbours){
                        queue.add(new WordNode(n, word.path));
                        removeSet.add(n);
                    }
                }
            }
            dictionary.removeAll(removeSet);
        }

        return result;
    }

    private List<String> getNeighbours(String word) {
        List<String> neighbours = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(int i=0;i<word.length();i++){
            char temp = word.charAt(i);
            for(int k='a';k<='z';k++){
                arr[i]=(char)k;
                String str = new String(arr);
                if(dictionary.contains(str))
                    neighbours.add(str);
            }
            arr[i] = temp;
        }
        return neighbours;
    }

    public static void main(String[] args) {
        WordLadderAllPaths wl = new WordLadderAllPaths();
        List<List<String>> result = wl.findLadders("hit","cog",
                Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(result.toString());
    }
}

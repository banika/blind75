package practice.random;

import java.util.*;

/**
 * Created by Anindita Banik on 8/14/22.
 */
public class WordLadder2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        set.add(beginWord);

        int changes =1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word =queue.poll();
                if(word.equals(endWord)) return changes;

                for(int j=0;j<word.length();j++)
                    for(int k='a';k<='z';k++){
                        char[] arr = word.toCharArray();
                        arr[j] = (char)k;
                        String str = new String(arr);
                        if(set.contains(str) && !visited.contains(str)){
                            queue.add(str);
                            visited.add(str);
                        }
                    }
            }
            changes++;
        }

        return 0;
    }
    public List<String> ladderPath(String beginWord, String endWord, List<String> wordList) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return list;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Map<String, String> visited = new HashMap<>();
        visited.put(beginWord, beginWord);

        int changes =1;
        boolean found = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word =queue.poll();
                if(word.equals(endWord)){
                    found = true;
                    break;
                }

                for(int j=0;j<word.length();j++)
                    for(int k='a';k<='z';k++){
                        char[] arr = word.toCharArray();
                        arr[j] = (char)k;
                        String str = new String(arr);
                        if(set.contains(str) && !visited.containsKey(str)){
                            queue.add(str);
                            visited.put(str, word);
                        }
                    }
            }
            if(found) break;
        }

        String key = endWord;
        String value = visited.get(key);
        list.add(0, key);
        while (!key.equalsIgnoreCase(value)) {
            key = value;
            value = visited.get(key);
            list.add(0, key);
        }
        return list;
    }

    public static void main(String[] args) {
        WordLadder2 wl = new WordLadder2();
        List<String> result = wl.ladderPath("hit","cog",
                        Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(result.toString());
    }
}

package blind.graph;

import java.util.*;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        String result ="";

        //1. init map
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> topoMap = new HashMap<>();

        // 2. Build map
        for(String word: words){
            for(Character c: word.toCharArray()){
                topoMap.put(c, new HashSet<Character>());
                indegree.put(c, 0);
            }
        }

        for(int i=0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];
            if(next.length()<curr.length() && curr.startsWith(next))
                return result;
            int length = Math.min(curr.length(), next.length());

            for(int j=0;j<length;j++){
                Character c1 = curr.charAt(j);
                Character c2 = next.charAt(j);

                if(c1!=c2){
                    if(!topoMap.get(c1).contains(c2)){
                        topoMap.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        //3. put the item in q which has indegree 0;
        for(Character i:indegree.keySet()){
            if(indegree.get(i)==0)
                queue.add(i);
        }

        // 4. iterate over the queue
        while(!queue.isEmpty()){
            Character c = queue.remove();
            result+=c;

            if(topoMap.containsKey(c)){
                for(Character c1: topoMap.get(c)){
                    indegree.put(c1, indegree.getOrDefault(c1,0)-1);
                    if(indegree.get(c1)==0)
                        queue.add(c1);
                }
            }
        }

        if(result.length()!=indegree.size())
            return "";
        return result;

    }
}

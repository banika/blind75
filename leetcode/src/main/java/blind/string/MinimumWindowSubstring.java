package blind.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anindita Banik on 7/31/22.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        int start =0, end=0, minStart=0, counter =t.length(), minLength = Integer.MAX_VALUE;
        while(end<s.length()){
            char c1 = s.charAt(end);
            if(map.getOrDefault(c1,0)>0)
                counter--;
            end++;
            map.put(c1, map.getOrDefault(c1,0)-1);

            while(counter == 0){
                if(minLength>end-start){
                    minLength = end-start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map.put(c2, map.getOrDefault(c2,0)+1);
                if(map.getOrDefault(c2,0) >0 ){
                    counter++;
                }
                start++;
            }
        }

        return minLength==Integer.MAX_VALUE ? "":s.substring(minStart, minStart+minLength);
    }
}

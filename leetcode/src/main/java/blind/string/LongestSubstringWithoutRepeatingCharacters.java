package blind.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 7/31/22.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://www.youtube.com/watch?v=4i6-9IzQHwo&t=550s
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int i=0, j=0, max =0;
        Set<Character> set = new HashSet<>();

        while(i<s.length()){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }
}

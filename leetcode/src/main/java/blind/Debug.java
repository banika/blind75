package blind;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 7/31/22.
 */
public class Debug {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0, max=0;
        Set<Character> set = new HashSet<>();
        while(i<s.length()){
//            if(!set.contains(s.charAt(i))){
//                set.add(s.charAt(i));
//            }
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Debug debug = new Debug();
        int result = debug.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}

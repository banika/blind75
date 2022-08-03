package blind.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        for(int num:nums){
            if(!set.contains(num-1)){
                int length =0;
                while(set.contains(num+length)){
                    length+=1;
                    longest = Math.max(longest, length);
                }
            }
        }
        return longest;
    }
}

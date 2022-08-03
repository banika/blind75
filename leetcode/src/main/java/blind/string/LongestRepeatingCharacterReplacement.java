package blind.string;

/**
 * Created by Anindita Banik on 7/31/22.
 * https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O(n)-sliding-window-solution-with-explanation
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int mostFrequent = 0;
        int[] freq = new int[26];
        int start =0, end =0;
        for(end=0;end<s.length();end++){
            freq[s.charAt(end)-'A']++;
            mostFrequent = Math.max(mostFrequent, freq[s.charAt(end)-'A']);
            while(end-start+1-mostFrequent > k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}

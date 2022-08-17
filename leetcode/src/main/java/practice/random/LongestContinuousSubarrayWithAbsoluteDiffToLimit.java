package practice.random;

import java.util.TreeMap;

/**
 * Created by Anindita Banik on 8/16/22.
 */
public class LongestContinuousSubarrayWithAbsoluteDiffToLimit {
    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffToLimit lcs = new LongestContinuousSubarrayWithAbsoluteDiffToLimit();
        int length = lcs.longestSubarray(new int[]{8,2,4,7}, 4);
        System.out.println(length);
    }
}

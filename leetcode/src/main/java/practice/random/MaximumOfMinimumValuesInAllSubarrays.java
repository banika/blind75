package practice.random;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Anindita Banik on 8/16/22.
 */
public class MaximumOfMinimumValuesInAllSubarrays {
    public int[] findMaximums(int[] n) {
        int[] res = new int[n.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n.length; ++i) {
            while (!s.empty() && (i == n.length || n[s.peek()] >= n[i])) {
                int j = s.pop(), k = i - 1;
                if (!s.empty())
                    k -= s.peek() + 1;
                res[k] = Math.max(res[k], n[j]);
            }
            s.push(i);
        }
        for (int i = res.length - 1; i > 0; --i)
            res[i - 1] = Math.max(res[i - 1], res[i]);
        return res;
    }

    public static void main(String[] args) {
        MaximumOfMinimumValuesInAllSubarrays mom = new MaximumOfMinimumValuesInAllSubarrays();
        int[] a = mom.findMaximums(new int[]{10,20,50,10});
        Arrays.stream(a).forEach(System.out::println);
    }
}

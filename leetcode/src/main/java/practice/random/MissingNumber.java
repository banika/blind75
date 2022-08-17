package practice.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 8/12/22.
 */
public class MissingNumber {
    public int solution(int[] A) {
        // write your code in Java SE 11
        Arrays.sort(A);
        Set<Integer> set = new HashSet<>();
        for(int i:A)
            set.add(i);
        int number = A[0];
        int index=0, missing = A[0];

        while(set.contains(missing)){
            index++;
            missing = number+index;
        }
        if(missing >0)
            return missing;
        return -1;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int result = mn.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(result);
    }
}

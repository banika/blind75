package practice.random;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anindita Banik on 8/5/22.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println("Is it a happy number?"+hn.isHappy(4));
    }
}

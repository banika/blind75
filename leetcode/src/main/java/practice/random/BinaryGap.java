package practice.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anindita Banik on 8/10/22.
 */
public class BinaryGap {
    int longestDistance = 0;
    public int binaryGap(int n) {
        if(n==0)
            return longestDistance;

        List<Integer> list = new ArrayList<>();
        String bin = Integer.toBinaryString(n);
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1')
                list.add(i);
        }

        if(list.size()<2)
            return longestDistance;

        for(int i=0; i<list.size()-1;i++){
            longestDistance = Integer.max(list.get(i+1)-list.get(i), longestDistance);
        }

        return longestDistance;
    }
}

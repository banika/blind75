package practice.random;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Anindita Banik on 8/11/22.
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        int i =0;

        for(int n:arr1){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(int n:arr2){
            for(int j=0;j<map.get(n);j++)
                arr1[i++]=n;
            map.remove(n);
        }

        for(int n:map.keySet())
            for(int j=0;j<map.get(n);j++)
                arr1[i++]=n;

        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray rsa = new RelativeSortArray();
        int[] result= rsa.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
        Arrays.stream(result).forEach( s-> System.out.print(s+","));
    }
}

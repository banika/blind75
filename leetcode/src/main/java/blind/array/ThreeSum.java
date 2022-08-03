package blind.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anindita Banik on 7/19/22.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(num);

        for(int i=0;i<num.length-2;i++){
            if(i==0 || (i>0 && num[i]!=num[i-1])){
                int sum = 0-num[i]; int lo = i+1, hi=num.length-1;
                while(lo<hi){
                    if(num[lo]+num[hi]==sum){
                        list.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while(lo<hi && num[lo]==num[lo+1])lo++;
                        while(lo<hi && num[hi]==num[hi-1])hi--;
                        lo++; hi--;
                    }
                    else if(num[lo]+num[hi]<sum) lo++;
                    else hi--;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(nums));
    }
}

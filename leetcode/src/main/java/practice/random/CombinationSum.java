package practice.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anindita Banik on 8/23/22.
 */
public class CombinationSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0)
            return false;
        List<List<Integer>> list = combinationSum(nums, sum/2);
        if(list.size()>1)
            return true;
        return false;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), 0, candidates, target);
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> tempList, int start,
                   int[] nums, int remain){
        if(remain<0) return;
        else if(remain==0)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i=start;i<nums.length;i++ ){
                tempList.add(nums[i]);
                backtrack(list, tempList, i+1, nums, remain-nums[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        boolean result = cs.canPartition(new int[]{1,1,1,1});
        System.out.println(result);
//        List<List<Integer>> list = cs.combinationSum(new int[]{1,1,1,1},2);
//        System.out.println(list);
    }
}

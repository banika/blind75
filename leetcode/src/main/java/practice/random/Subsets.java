package practice.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anindita Banik on 8/21/22.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),0,nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int start, int[] nums) {
        list.add(new ArrayList<Integer>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, i+1, nums);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets ss = new Subsets();
        List<List<Integer>> list = ss.subsets(new int[]{1,2,3});
        System.out.println(list);
    }
}

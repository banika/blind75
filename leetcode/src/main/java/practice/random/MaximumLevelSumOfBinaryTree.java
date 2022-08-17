package practice.random;

import java.util.*;

/**
 * Created by Anindita Banik on 8/16/22.
 */
public class MaximumLevelSumOfBinaryTree {
    Map<Integer, Integer> levelSum = new HashMap<>();
    List<List<Integer>> levels = new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
                (a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer> keyValue:levelSum.entrySet()){
            heap.add(keyValue);
        }

        return heap.poll().getKey();
    }

    void helper(TreeNode root, int level){
        if(levels.size()==level)
            levels.add(new ArrayList<>());

        levels.get(level).add(root.val);
        levelSum.put(level, levelSum.getOrDefault(level,0)+root.val);

        if(root.left!=null) helper(root.left, level+1);
        if(root.right!=null) helper(root.right, level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        root.right.left = null;
        root.right.right = null;

        MaximumLevelSumOfBinaryTree bt = new MaximumLevelSumOfBinaryTree();
        int result = bt.maxLevelSum(root);
        System.out.println(result);
    }
}

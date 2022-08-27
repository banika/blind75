package practice.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anindita Banik on 8/21/22.
 */
public class AverageLevelsInBinaryTree {
    List<List<Integer>> levels = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> valueList = new ArrayList<>();
        levelOrder(root, 0);
        for(List<Integer> levelList: levels){
            double sum = 0.00;
            for(Integer i:levelList){
                sum+=i;
            }
            double avg = sum/levelList.size();
            valueList.add(avg);
        }
        return valueList;
    }

    void levelOrder(TreeNode node, int level){
        if(levels.size()==level)
            levels.add(new ArrayList<>());
        levels.get(level).add(node.val);
        if(node.left!=null)
            levelOrder(node.left, level+1);
        if(node.right!=null)
            levelOrder(node.right, level+1);
    }

    public static void main(String[] args) {
        AverageLevelsInBinaryTree albt = new AverageLevelsInBinaryTree();
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = null;

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> result = albt.averageOfLevels(root);
        System.out.println(result);
    }
}

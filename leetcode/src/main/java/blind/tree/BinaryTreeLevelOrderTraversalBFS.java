package blind.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Anindita Banik on 7/17/22.
 */
public class BinaryTreeLevelOrderTraversalBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root==null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level =0;

        while(!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int levelsLength = queue.size();

            for(int i=0;i<levelsLength;i++){
                TreeNode v = queue.remove();
                levels.get(level).add(v.val);

                if(v.left!=null) queue.add(v.left);
                if(v.right!=null) queue.add(v.right);
            }
            level++;
        }
        return levels;
    }
}

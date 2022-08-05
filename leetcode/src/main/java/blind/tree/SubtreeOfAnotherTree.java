package blind.tree;

/**
 * Created by Anindita Banik on 8/5/22.
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return subRoot==null;
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot)
                || isSameTree(root, subRoot);
    }

    boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;
        return root.val==subRoot.val
                && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }
}

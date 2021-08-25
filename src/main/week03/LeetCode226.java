package week03;

import common.TreeNode;

public class LeetCode226 {

    public TreeNode foo(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        foo(root.left);
        foo(root.right);

        return root;
    }
}

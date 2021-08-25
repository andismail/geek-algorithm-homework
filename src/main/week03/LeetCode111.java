package week03;

import common.TreeNode;

public class LeetCode111 {

    public int foo(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int l = foo(root.left);
        int r = foo(root.right);
        if (root.left == null || root.right == null) {
            return l + r + 1;
        }

        return Math.min(l, r) + 1;
    }
}

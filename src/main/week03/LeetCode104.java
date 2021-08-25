package week03;

import common.TreeNode;

public class LeetCode104 {

    public int foo(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int x = 0;
        if (root.left != null) {
            x = foo(root.left);
        }

        int y = 0;
        if (root.right != null) {
            y = foo(root.right);
        }

        return Math.max(x, y) + 1;
    }

    public int fooo(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = fooo(root.left);
        int r = fooo(root.right);

        return Math.max(l, r) + 1;
    }
}

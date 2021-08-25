package week03;

import common.TreeNode;

public class Repeat03 {

    Integer pre;

    public boolean _98(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (!_98(root.left)) {
            return false;
        }

        if (pre != null) {
            if (pre >= root.val) {
                return false;
            }
        }
        pre = root.val;

        return _98(root.right);
    }

    public int _104(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = _104(root.left);
        int n = _104(root.right);

        return Math.max(l, n) + 1;
    }

    public int _111(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int l = _111(root.left);
        int r = _111(root.right);
        if (root.left == null || root.right == null) {
            return l + r + 1;
        }

        return Math.min(l, r) + 1;
    }

    public TreeNode _226(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        _226(root.left);
        _226(root.right);

        return root;
    }
}
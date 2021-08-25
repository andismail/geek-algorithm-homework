package week03;

import common.TreeNode;

import java.util.List;

public class LeetCode98 {

    public boolean foo(TreeNode node) {
        if (node.left != null) {
            if (node.val <= node.left.val) {
                return false;
            }

            foo(node.left);
        }

        if (node.right != null) {
            if (node.val >= node.right.val) {
                return false;
            }
            foo(node.right);
        }

        return true;
    }

    Integer pre;
    private boolean fooo(TreeNode node, List<Integer> res) {
        if (node == null) {
            return true;
        }

        if (!fooo(node.left, res)) {
            return false;
        }
        if (pre != null) {
            if (pre > node.val) {
                return false;
            }
        }
        pre = node.val;

        if (!fooo(node.right, res)) {
            return false;
        }

        return true;
    }
}

package week02;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(root, res);
        return res;
    }

    private void foo(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        foo(node.left, res);
        res.add(node.val);
        foo(node.right, res);
    }
}

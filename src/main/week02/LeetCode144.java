package week02;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class LeetCode144 {

    public List<Integer> tr(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(root, res);

        return res;
    }

    private void foo(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        foo(root.left, res);
        foo(root.right, res);
    }
}

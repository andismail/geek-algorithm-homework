package week03;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode297 {

    public String ser(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(root, res);

        return null;
    }

    private void foo(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);

        foo(node.left, res);
        if (node.left == null) {
            res.add(null);
        }

        foo(node.right, res);
        if (node.right == null) {
            res.add(null);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LeetCode297 bean = new LeetCode297();
        bean.ser(root);
    }
}

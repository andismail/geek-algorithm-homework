package week03;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode297 {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> res = new ArrayList<>();
        f(root, res);

        StringBuilder b = new StringBuilder();
        for (String s : res) {
            b.append(s).append(",");
        }

        return b.toString();
    }

    private void f(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("None");
            return;
        }

        res.add(node.val + "");
        f(node.left, res);
        f(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> linkedList = new LinkedList<>(Arrays.asList(split));
        return ff(linkedList);
    }

    private TreeNode ff(List<String> linkedList) {
        String str = linkedList.get(0);
        if ("None".equals(str) || "".equals(str)) {
            linkedList.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(str));
        linkedList.remove(0);
        node.left = ff(linkedList);
        node.right = ff(linkedList);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        LeetCode297 bean = new LeetCode297();
        bean.serialize(root);
    }
}

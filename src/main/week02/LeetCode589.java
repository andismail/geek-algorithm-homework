package week02;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树前序遍历
 */
public class LeetCode589 {

    public List<Integer> foo(Node root) {
        List<Integer> res = new ArrayList<>();
        boo(root, res);
        return res;
    }

    private void boo(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);

        if (node.children != null) {
            for (Node child : node.children) {
                boo(child, res);
            }
        }
    }
}

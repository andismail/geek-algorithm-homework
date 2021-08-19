package week02;

import common.NTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树后序遍历：子节点->根结点
 */
public class LeetCode590 {

    public List<Integer> foo(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        boo(root, res);
        return res;
    }

    private void boo(NTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (NTreeNode child : root.children) {
                boo(child, res);
            }
        }

        res.add(root.val);
    }

}

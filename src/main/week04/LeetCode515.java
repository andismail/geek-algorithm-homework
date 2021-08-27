package week04;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            Integer max = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = max == null ? node.val : Math.max(max, node.val);

                TreeNode l = node.left, r = node.right;
                if (l != null) {
                    q.add(l);
                }
                if (r != null) {
                    q.add(r);
                }
            }
            res.add(max);
        }
        return res;
    }
}

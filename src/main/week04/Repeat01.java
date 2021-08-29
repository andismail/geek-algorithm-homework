package week04;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Repeat01 {

    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                path.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    q.add(left);
                }
                if (right != null) {
                    q.add(right);
                }
            }
            res.add(path);
        }
        return res;
    }

}

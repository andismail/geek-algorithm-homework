package week04;

import common.TreeNode;

import java.util.*;

public class Repeat02 {

    public int _122(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }

    public int _455(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0, count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                count++;
                start++;
            }
        }
        return count;
    }

    public List<List<Integer>> _102(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> path = new ArrayDeque<>();
        path.add(root);
        while (!path.isEmpty()) {
            int size = path.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = path.poll();
                list.add(node.val);

                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    path.add(left);
                }
                if (right != null) {
                    path.add(right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

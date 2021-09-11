package week04;

import common.TreeNode;

import java.util.*;

public class LeetCode103 {

    public List<List<Integer>> foo(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = false;
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (order) {
                    queue.addLast(node.val);
                } else {
                    queue.addFirst(node.val);
                }
                TreeNode left = node.left, right = node.right;
                if (right != null) {
                    q.add(right);
                }
                if (left != null) {
                    q.add(left);
                }
            }
            order = !order;
            res.add(new ArrayList<>(queue));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(0, 5);
        System.out.println(list);
    }
}

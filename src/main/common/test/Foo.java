package common.test;

import common.TreeNode;

import java.util.*;

public class Foo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> bfs = bfs(root);
        for (List<Integer> bf : bfs) {
            for (Integer each : bf) {
                System.out.print(each + "\t");
            }

            System.out.println();
        }

    }

    private static List<List<Integer>> bfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (flag) {
                    node = q.pollLast();
                } else {
                    node = q.pollFirst();
                }

                list.add(node.val);

                TreeNode n1 = node.left;
                TreeNode n2 = node.right;
                if (flag) {
                    n1 = node.right;
                    n2 = node.left;
                }
                if (n1 != null) {
                    q.add(n1);
                }
                if (n2 != null) {
                    q.add(n2);
                }
            }
            flag = !flag;
            res.add(list);
        }

        return res;
    }

}



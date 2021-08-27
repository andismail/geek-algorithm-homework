package week02;

import common.Node;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 242.有效的字母异位词
 * 49.异位词分组
 * 94.二叉树的中序遍历
 * 144.二叉树的前序遍历
 * 589.N叉树的前序遍历
 * 590.N叉树的后序遍历
 * N叉树的层序遍历
 */
public class Repeat03 {
    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] charArray = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charArray[s1.charAt(i) - 'a']++;
            charArray[s2.charAt(i) - 'a']--;
        }
        for (int i : charArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> _49(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();
        for (String str : strs) {
            double key = calcKey(str);
            List<String> strings = map.computeIfAbsent(key, v -> new ArrayList<>());
            strings.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (Double key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private double calcKey(String str) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        double y = 1d;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        return y;
    }

    public List<Integer> _94(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(root, res);
        return res;
    }

    private void foo(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        foo(node.left, res);
        res.add(node.val);
        foo(node.right, res);
    }

    public List<Integer> _144(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo1(root, res);
        return res;
    }

    private void foo1(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        foo1(node.left, res);
        foo1(node.right, res);
    }

    public List<Integer> _589(Node root) {
        List<Integer> res = new ArrayList<>();
        foo2(root, res);
        return res;
    }

    private void foo2(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        if (node.children != null) {
            for (Node childNode : node.children) {
                foo2(childNode, res);
            }
        }
    }

    public List<Integer> _590(Node root) {
        List<Integer> res = new ArrayList<>();
        foo3(root, res);
        return res;
    }

    private void foo3(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node childNode : node.children) {
                foo2(childNode, res);
            }
        }
        res.add(node.val);
    }

}
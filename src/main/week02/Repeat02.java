package week02;

import common.Node;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repeat02 {

    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }

        for (int count : chars) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> _49(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();
        for (String str : strs) {
            double key = calculate(str);
            List<String> list = map.computeIfAbsent(key, v -> new ArrayList<>());
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Double key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private double calculate(String str) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        double y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        System.out.println(y);
        return y;
    }

    public List<Integer> _94(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo(root, res);
        return res;
    }

    private void foo(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        foo(root.left, res);
        res.add(root.val);
        foo(root.right, res);
    }

    public List<Integer> _144(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo1(root, res);
        return res;
    }

    private void foo1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        foo1(root.left, res);
        foo1(root.right, res);
    }

    public List<Integer> _590(Node root) {
        List<Integer> res = new ArrayList<>();
        bo(root, res);
        return res;
    }

    private void bo(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child : root.children) {
                bo(child, res);
            }
        }
        res.add(root.val);
    }
}

package week03;

import common.TreeNode;

import java.util.*;

/**
 * 70.爬楼梯
 * 22.括号生成
 * 98.验证二叉搜索树
 * 104.二叉树的最大深度
 * 111.二叉树的最小深度
 * 226.翻转二叉树
 * 297.二叉树的序列化与反序列化
 * 105.从前序与中序遍历序列构造二叉树
 * 50.Pow(x, n)（分治）
 * 78.子集
 * 169.多数元素
 * 17.电话号码的字母组合
 * 51.N皇后
 * 46.全排列
 * 47.全排列II
 */
public class Repeat04 {

    Map<Integer, Integer> sMap = new HashMap<>();

    public int _70(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (sMap.get(n) != null) {
            return sMap.get(n);
        }

        int res = _70(n - 1) + _70(n - 2);
        sMap.put(n, res);
        return res;
    }

    public List<String> _22(int n) {
        List<String> res = new ArrayList<>();

        _22_dfs1(0, 0, n, "", res);

        return res;
    }

    private void _22_dfs1(int lc, int rc, int len, String curStr, List<String> res) {
        if (curStr.length() == len * 2) {
            res.add(curStr);
            return;
        }

        if (lc < rc) {
            return;
        }

        if (lc < len) {
            _22_dfs1(lc + 1, rc, len, curStr + "(", res);
        }

        if (rc < len) {
            _22_dfs1(lc, rc + 1, len, curStr + ")", res);
        }
    }

    private void _22_dfs2(int lc, int rc, int len, String curStr, List<String> res) {
        if (curStr.length() == 2 * len) {
            res.add(curStr);
        }

        if (lc > rc) {
            return;
        }

        if (lc > 0) {
            _22_dfs2(lc - 1, rc, len, curStr + "(", res);
        }

        if (rc > 0) {
            _22_dfs2(lc, rc - 1, len, curStr + ")", res);
        }
    }

    Integer pre;

    public boolean _98(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!_98(node.left)) {
            return false;
        }
        if (pre != null && pre >= node.val) {
            return false;
        }
        pre = node.val;

        return _98(node.right);
    }

    public int _104(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDeep = _104(root.left);
        int rDeep = _104(root.right);

        return Math.max(lDeep, rDeep) + 1;
    }

    public int _111(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int lc = _111(root.left);
        int rc = _111(root.right);
        if (root.left == null || root.right == null) {
            return lc + rc + 1;
        }

        return Math.min(lc, rc) + 1;
    }

    public TreeNode _226(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        _226(root.left);
        _226(root.right);

        return root;
    }

    public double _50_1(int x, int n) {
        double res;
        if (n < 0) {
            res = xy(x, -n);
        } else {
            res = xy(x, n);
        }

        return n >= 0 ? res : 1 / res;
    }

    private double xy(int x, int n) {
        if (n == 0) {
            return 1;
        }

        double y = _50_1(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    public List<List<Integer>> _78(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            Deque<Integer> path = new ArrayDeque<>();
            foo(nums, i, 0, path, res);
        }

        return res;
    }

    private void foo(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            foo(nums, len, begin + 1, path, res);
            path.removeLast();
        }
    }

    public int _169_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public List<List<Integer>> _46(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int num : nums) {
            Deque<Integer> path = new ArrayDeque<>();
            path.add(num);
            f0(nums, path, res);
        }

        return res;
    }

    private void f0(int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }

            path.add(num);
            f0(nums, path, res);
        }
    }

    public List<List<Integer>> _47(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        fooo(nums,  used, path, res);
        return res;
    }

    private void fooo(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                continue;
            }
            if (i > 0 && used[i] == used[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            fooo(nums,  used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
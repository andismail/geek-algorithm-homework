package repeat;

import common.TreeNode;

import java.util.*;

public class Repeat04 {

    /**
     * 70.爬楼梯
     */
    Map<Integer, Integer> sMap = new HashMap<>();

    public int _70(int n) {
        if (n == 0) {
            return 0;
        }
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

    /**
     * 22.括号生成
     */
    public List<String> _22(int a) {
        List<String> res = new ArrayList<>();

        f_22(a, 0, 0, "", res);

        return res;
    }

    private void f_22(int len, int lc, int rc, String curStr, List<String> res) {
        if (curStr.length() == len * 2) {
            res.add(curStr);
            return;
        }

        if (lc < rc) {
            return;
        }

        if (lc <= len) {
            f_22(len, lc + 1, rc, curStr + "(", res);
        }

        if (rc <= len) {
            f_22(len, lc, rc + 1, curStr + ")", res);
        }
    }

    /**
     * 98.验证二叉搜索树
     */
    Integer pre;

    public boolean _98(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (!_98(root.left)) {
            return false;
        }

        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;

        return _98(root.right);
    }

    /**
     * 104.二叉树的最大深度
     */
    public int _104(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lc = _104(root.left) + 1;
        int rc = _104(root.right) + 1;

        return Math.max(lc, rc);
    }

    /**
     * 111.二叉树的最小深度
     */
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

    /**
     * 226.翻转二叉树
     */
    public TreeNode _226(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            _226(root.left);
        }

        if (root.right != null) {
            _226(root.right);
        }

        return root;
    }


    /**
     * 297.二叉树的序列化与反序列化
     * 105.从前序与中序遍历序列构造二叉树
     */

    /**
     * 50.Pow(x, n)（分治）
     */
    public int _50(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        int y = n < 0 ? f_50(x, -n) : f_50(x, n);

        return n < 0 ? 1 / y : y;
    }

    private int f_50(int x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        int y = f_50(x, n / 2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 78.子集
     */
    public List<List<Integer>> _78(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Deque<Integer> path = new ArrayDeque<>();

        for (int i = 1; i <= nums.length; i++) {
            f_78(nums, i, 0, path, res);
        }

        return res;
    }

    private void f_78(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (len == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            f_78(nums, len, i + 1, path, res);
            path.removeLast();
        }
    }


    /**
     * 169.多数元素
     */
    public int _169(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 17.电话号码的字母组合
     * 51.N皇后
     */

    /**
     * 46.全排列
     */
    public List<List<Integer>> _46(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        f_46(nums, path, res);
        return res;
    }

    private void f_46(int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            f_46(nums, path, res);
            path.removeLast();
        }
    }

    /**
     * 47.全排列II
     */
    public List<List<Integer>> _47(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        f_47(nums, used, path, res);
        return res;
    }

    private void f_47(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            f_47(nums, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }
}











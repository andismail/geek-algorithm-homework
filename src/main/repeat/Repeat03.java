package repeat;

import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

/**
 * 2021-08-27
 */
public class Repeat03 {

    /**
     * 26.删除排序数组中的重复项
     */
    public int _26(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p == 1) {
                    p++;
                    q++;
                    continue;
                }
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }

        return p + 1;
    }

    /**
     * 189.旋转数组
     */
    public void _189(int[] nums, int k) {
        k %= nums.length;
        f_189(nums, 0, nums.length - 1);
        f_189(nums, 0, k - 1);
        f_189(nums, k, nums.length - 1);
    }

    private void f_189(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    /**
     * 21.合并两个有序链表（升序）
     */
    public ListNode _21(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = _21(l1.next, l2);
            return l1;
        }
        l2.next = _21(l1, l2.next);
        return l2;
    }

    /**
     * 88.合并两个有序数组（非递减顺序）
     */
    public void _88_1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void _88_2(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int curr;
        int p1 = 0, p2 = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            sort[p1 + p2 - 1] = curr;
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
    }

    public void _88_3(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int curr;
        int p1 = m - 1, p2 = n - 1;
        while (p1 > -1 || p2 > -1) {
            if (p1 == -1) {
                curr = nums2[p2--];
            } else if (p2 == -1) {
                curr = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums1[p1--];
            } else {
                curr = nums2[p2--];
            }
            nums1[tail--] = curr;
        }
    }

    /**
     * 1.两数之和
     */
    public int[] _1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 283.移动零
     */
    public void _283(int[] nums) {
        int p = 0, q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[q] != 0) {
                if (q == p) {
                    p++;
                    q++;
                    continue;
                }
                nums[p] = nums[q];
                nums[q] = 0;
                p++;
            }
            q++;
        }
    }

    /**
     * 66.加一
     */
    public int[] _66(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 242.有效的字母异位词
     */
    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] map = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        for (char cnt : map) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 49.异位词分组
     */
    public List<List<String>> _49(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            double key = calc(str);
            List<String> list = map.computeIfAbsent(key, v -> new ArrayList<>());
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Double key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private double calc(String str) {
        int[] x = genX();
        double y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        return y;
    }

    private int[] genX() {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (i == 2 || i == 5 || i == 7) {
                list.add(i);
                continue;
            }

            if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                list.add(i);
            }
            if (list.size() == 26) {
                break;
            }
        }
        int[] res = new int[26];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 94.二叉树的中序遍历
     * 144.二叉树的前序遍历
     */
    public List<Integer> _94(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        f_94(node, res);
        return res;
    }

    private void f_94(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        f_94(node.left, res);
        res.add(node.val);
        f_94(node.right, res);

        /*res.add(node.val);
        f_94(node.left, res);
        f_94(node.right, res);*/
    }

    /**
     * 589.N叉树的前序遍历
     * 590.N叉树的后序遍历
     */
    public List<Integer> _589(Node node) {
        List<Integer> res = new ArrayList<>();
        f_589(node, res);
        return res;
    }

    private void f_589(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                f_589(child, res);
            }
        }
        //res.add(node.val);
    }

    /**
     * 40.最小的k个数
     */
    public int[] _40_1(int[] nums, int k) {
        int[] res = new int[k];
        Arrays.sort(nums);
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int[] _40_2(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    /**
     * 239.滑动窗口最大值
     */
    public int[] _239(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if (i - q.peekFirst() == k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    /**
     * 347.前K个高频元素
     */
    public int[] _347(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o2) - counter.get(o1));
        for (Integer cnt : counter.keySet()) {
            q.add(cnt);
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    /**
     * 77.组合
     */
    public List<List<Integer>> _77(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        f_77(n, k, 1, path, res);
        return res;
    }

    private void f_77(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            f_77(n, k, i + 1, path, res);
            path.removeLast();
        }
    }

    /**
     * 70.爬楼梯
     */
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

    /**
     * 22.括号生成
     */
    public List<String> _22(int n) {
        List<String> res = new ArrayList<>();
        f_22(n, 0, 0, "", res);
        return res;
    }

    private void f_22(int n, int lc, int rc, String curStr, List<String> res) {
        if (curStr.length() == n * 2) {
            res.add(curStr);
            return;
        }

        if (lc < rc) {
            return;
        }

        if (lc < n) {
            f_22(n, lc + 1, rc, curStr + "(", res);
        }

        if (rc < n) {
            f_22(n, lc, rc + 1, curStr + ")", res);
        }
    }

    /**
     * 98.验证二叉搜索树
     */
    Integer pre;

    public boolean _98(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!_98(node.left)) {
            return false;
        }
        if (pre != null && node.val <= pre) {
            return false;
        }
        pre = node.val;

        return _98(node.right);
    }

    /**
     * 104.二叉树的最大深度
     */
    public int _104(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lc = _104(node.left);
        int rc = _104(node.right);

        return Math.max(lc, rc) + 1;
    }

    /**
     * 111.二叉树的最小深度
     */
    public int _111(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }

        int lc = _111(node.left);
        int rc = _111(node.right);
        if (node.left == null || node.right == null) {
            return lc + rc + 1;
        }

        return Math.min(lc, rc) + 1;
    }

    /**
     * 226.翻转二叉树
     */
    public TreeNode _226(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            _226(node.left);
        }

        if (node.right != null) {
            _226(node.right);
        }

        return node;
    }

    /**
     * 297.二叉树的序列化与反序列化
     * 105.从前序与中序遍历序列构造二叉树
     * 17.电话号码的字母组合
     * 51.N皇后
     */

    /**
     * 50.Pow(x, n)（分治）
     */
    public double _50(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1d;
        }

        double res;
        if (n < 0) {
            res = f_50(x, -n);
        } else {
            res = f_50(x, n);
        }

        return n < 0 ? 1 / res : res;
    }

    private double f_50(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double y = f_50(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 78.子集
     */
    public List<List<Integer>> _78(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            Deque<Integer> path = new ArrayDeque<>();
            f_78(i, nums, 0, path, res);
        }
        return res;
    }

    private void f_78(int deep, int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (deep == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            f_78(deep, nums, i + 1, path, res);
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
     * 46.全排列
     */
    public List<List<Integer>> _46(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        f_46(nums, path, res);
        return res;
    }

    private void f_46(int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (nums.length == path.size()) {
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
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            f_47(nums, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
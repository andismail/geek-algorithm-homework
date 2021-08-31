package repeat;

import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

public class Repeat04 {

    /**
     * 26.删除排序数组中的重复项
     */
    public int _26(int[] nums) {
        int p1 = 0, p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] != nums[p2]) {
                if (p2 - p1 == 1) {
                    p1++;
                    p2++;
                    continue;
                }

                nums[p1 + 1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return nums.length == 0 ? 0 : p1 + 1;
    }

    /**
     * 189.旋转数组
     */
    public void _189(int[] nums, int k) {
        k = k % nums.length;
        f_189(nums, 0, nums.length - 1);
        f_189(nums, k, nums.length - 1);
        f_189(nums, 0, k - 1);
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
    public void _88(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int curr;
        int p = m - 1, q = n - 1;
        while (p > -1 || q > -1) {
            if (p == -1) {
                curr = nums2[q--];
            } else if (q == -1) {
                curr = nums1[p--];
            } else if (nums1[p] > nums2[q]) {
                curr = nums1[p--];
            } else {
                curr = nums2[q--];
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
        while (q < nums.length) {
            if (nums[q] != 0) {
                if (p == q) {
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

        int[] letterCnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letterCnt[s1.charAt(i) - 'a']++;
            letterCnt[s2.charAt(i) - 'a']--;
        }

        for (int cnt : letterCnt) {
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
        Map<Double, List<String>> map = new HashMap<>();
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
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 39, 41, 43, 47, 49, 51, 53, 57, 61, 67, 71, 73, 79, 83, 87, 89, 91, 97, 101, 103};

        double y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        return y;
    }

    /**
     * 94.二叉树的中序遍历
     */
    private void f_94(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        f_94(node.left, res);
        res.add(node.val);
        f_94(node.right, res);
    }

    /**
     * 144.二叉树的前序遍历
     */
    public List<Integer> _144(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        f_144(root, res);
        return res;
    }

    private void f_144(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        f_144(node.left, res);
        f_144(node.right, res);
    }

    /**
     * 589.N叉树的前序遍历
     */
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
    }

    /**
     * 590.N叉树的后序遍历
     */
    public List<Integer> _590(Node root) {
        List<Integer> res = new ArrayList<>();
        f_590(root, res);
        return res;
    }

    private void f_590(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                f_590(child, res);
            }
        }
        res.add(node.val);
    }

    /**
     * *40.最小的k个数
     */
    public int[] _40(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    /**
     * *239.滑动窗口最大值
     */
    public int[] _239(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);

            if (i - q.peekFirst() == k) {
                q.removeFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = q.peekFirst();
            }
        }
        return res;
    }

    /**
     * *347.前K个高频元素
     */
    public int[] _347(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o2) - counter.get(o1));
        for (Integer num : counter.keySet()) {
            q.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    /**
     * *77.组合
     */
    public List<List<Integer>> _77(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        f_77(n, k, 1, path, res);
        return res;
    }

    private void f_77(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
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

    /**
     * 102.二叉树的层序遍历
     */
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
                TreeNode left = node.left;
                if (left != null) {
                    path.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    path.add(right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 433.最小基因变化
     */

    /**
     * 515.在每个树行中找最大值
     */
    public List<Integer> _515(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> path = new ArrayDeque<>();
        path.add(root);
        while (!path.isEmpty()) {
            int size = path.size();
            Integer max = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = path.poll();
                max = max == null ? node.val : Math.max(max, node.val);
                TreeNode left = node.left;
                if (left != null) {
                    path.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    path.add(right);
                }
            }
            res.add(max);
        }
        return res;
    }

    /** 200.岛屿数量
     * 322.零钱兑换
     */

    /**
     * 455.饼干分发问题
     */
    public int _455(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, start = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                count++;
                start++;
            }
        }
        return count;
    }

    /**
     * 122.买卖股票的最佳时机II
     */
    public int _122(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /**
     * 55.跳跃游戏
     */
    public boolean _55(int[] nums) {

        return false;
    }

    /**
     * 69.x的平方根
     */
    public int _69_1(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public int _69_2(int x) {
        if (x == 1) return 1;
        int left = 1, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 33.搜索旋转排序数组
     */
    public int _33(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int root = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int realMid = (mid + root) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    public int search(int[] A, int target) {
        int n = A.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] > A[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rot = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (A[realmid] == target) return realmid;
            if (A[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    /**
     * 74.搜索二维矩阵
     */
    public boolean _74(int[][] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (target < nums[i][j]) {
                    break;
                }
                if (target > nums[i][j]) {
                    continue;
                }
                if (target == nums[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 153.寻找旋转排序数组中的最小值
     */
    public int _153(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}











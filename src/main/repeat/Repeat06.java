package repeat;

import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

/**
 * 中秋节
 */
public class Repeat06 {
    /**
     * 26.删除排序数组中的重复项
     */
    public int[] _26(int[] nums) {
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
        return nums;
    }

    /**
     * 189.旋转数组
     */
    public int[] _189(int[] nums, int k) {
        k %= k / nums.length;
        f_189(nums, 0, nums.length - 1);
        f_189(nums, 0, k - 1);
        f_189(nums, k, nums.length - 1);
        return nums;
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
        if (l1.val > l2.val) {
            l1.next = _21(l1.next, l2);
            return l1;
        }
        l2.next = _21(l1, l2.next);
        return l2;
    }

    /**
     * 88.合并两个有序数组（非递减顺序）
     */
    public int[] _88(int[] nums1, int[] nums2, int m, int n) {
        int tail = m + n;
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
            nums1[--tail] = curr;
        }
        return nums1;
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
    public int[] _283(int[] nums) {
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
        return nums;
    }

    /**
     * 66.加一
     */
    public int[] _66(int[] digit) {
        for (int i = digit.length - 1; i >= 0; i--) {
            digit[i] += 1;
            digit[i] %= 10;
            if (digit[i] != 0) {
                return digit;
            }
        }
        digit = new int[digit.length + 1];
        digit[0] = 1;
        return digit;
    }

    /**
     * 242.有效的字母异位词
     */
    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        char[] charArray = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            charArray[s1.charAt(i) - 'a']++;
            charArray[s2.charAt(i) - 'a']--;
        }
        for (char c : charArray) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 49.异位词分组
     */
    public List<List<String>> _49(String[] strs) {
        Map<Long, List<String>> counter = new HashMap<>();
        for (String str : strs) {
            long calcRes = calc(str);
            List<String> list = counter.computeIfAbsent(calcRes, v -> new ArrayList<>());
            list.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (Long cnt : counter.keySet()) {
            res.add(counter.get(cnt));
        }
        return res;
    }

    private long calc(String str) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        int y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        return y;
    }

    /**
     * 94.二叉树的中序遍历
     * 144.二叉树的前序遍历
     */
    public List<Integer> _94(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        f_94(root, res);
        return res;
    }

    private void f_94(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        f_94(node.left, res);
        res.add(node.val);
        f_94(node.right, res);
    }

    /**
     * 589.N叉树的前序遍历
     * 590.N叉树的后序遍历
     */
    public List<Integer> _589(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        f_589(root, res);
        return res;
    }

    private void f_589(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);

        List<Node> children = node.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                f_589(child, res);
            }
        }
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
        for (int i = 0; i < k; i++) {
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
            while (q.size() > 0 && nums[i] > nums[q.peekLast()]) {
                q.removeLast();
            }
            q.add(i);
            if (i - q.peekFirst() == k) {
                q.removeFirst();
            }

            if (i + 1 >= k) {
                res[i + 1 - k] = nums[q.peekFirst()];
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
            int cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, ++cnt);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o2) - counter.get(o1));
        for (Integer num : counter.keySet()) {
            q.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    /**
     * *77.组合
     */
    public List<List<Integer>> _77(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> path = new ArrayDeque<>();
        f_77(n, k, 1, path, res);
        return res;
    }

    private void f_77(int n, int k, int begin, Queue<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < n; i++) {
            path.add(n);
            f_77(n, k, i + 1, path, res);
            path.remove(i);
        }
    }

    /**
     * 70.爬楼梯
     */
    Map<Integer, Integer> cache = new HashMap<>();

    public int _70(int n) {
        if (n <= 2) {
            return n;
        }
        Integer res = cache.get(n);
        if (res != null) {
            return res;
        }

        res = _70(n - 1) + _70(n - 2);
        cache.put(n, res);

        return res;
    }

    /**
     * 22.括号生成
     */
    public List<String> _22(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        f_22(n, 0, 0, "", res);
        return res;
    }

    private void f_22(int n, int lc, int rc, String curStr, List<String> res) {
        if (curStr.length() == n * 2) {
            res.add(curStr);
            return;
        }

        if (rc > lc) {
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
    private Integer pre = null;

    public boolean _98(TreeNode root) {
        if (root == null) {
            return true;
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

        // 此处不能这样写，因为如果有一个为null则肯定是有一个值为0，上边已经加过1了，再做计算就不对了，应改成下边的写法
        int lc = _111(root.left) + 1;
        int rc = _111(root.right) + 1;
        if (root.left == null || root.right == null) {
            return lc + rc;
        }
        return Math.min(lc, rc);
        // 正确写法
        /*int lc = _111(root.left);
        int rc = _111(root.right);
        if (root.left == null || root.right == null) {
            return lc + rc + 1;
        }
        return Math.min(lc, rc) + 1;*/
    }

    /**
     * 226.翻转二叉树
     */
    public TreeNode _226(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        _226(root.left);
        _226(root.right);

        return root;
    }

    /**
     * 297.二叉树的序列化与反序列化
     */
    public List<Integer> _297_ser(TreeNode root) {
        // 前序遍历
        return null;
    }

    public TreeNode _297_de() {
        return null;
    }

    /**
     *105.从前序与中序遍历序列构造二叉树
     */

    /**
     * 50. Pow(x, n)（分治）
     */
    public double _50(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        return n > 0 ? f_50(x, n) : 1 / f_50(x, n);
    }

    private double f_50(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double y = f_50(x, n / 2);
        return n % 2 == 0 ? y * y : x * y * y;
    }

    /**
     * 78.子集
     */
    public List<List<Integer>> _78(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int len = 1; len <= nums.length; len++) {
            Deque<Integer> path = new ArrayDeque<>();
            f_78(nums, len, 0, path, res);
        }
        return res;
    }

    private void f_78(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
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
     *17.电话号码的字母组合
     *51.N皇后
     */

    /**
     * 46.全排列
     */
    public List<List<Integer>> _46(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
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
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
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
            path.removeLast();
            used[i] = false;
        }
    }

}

















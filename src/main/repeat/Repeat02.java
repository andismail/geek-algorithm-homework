package repeat;

import common.ListNode;
import common.NTreeNode;
import common.TreeNode;

import java.util.*;

public class Repeat02 {
    /*
    26.删除排序数组中的重复项
    189.旋转数组
    21.合并两个有序链表（升序）
    88.合并两个有序数组（非递减顺序）
    1.两数之和
    283.移动零
    66.加一
     */
    public int _26(int[] a) {
        int p = 0, q = 1;
        while (q < a.length) {
            if (a[p] != a[q]) {
                if (q - p == 1) {
                    p++;
                    q++;
                    continue;
                }

                a[p + 1] = a[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public void _189(int[] nums, int k) {
        k %= nums.length;
        re(nums, 0, nums.length - 1);
        re(nums, k, nums.length - 1);
        re(nums, 0, k - 1);
    }

    private void re(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

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

    public void _88_1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void _88_2(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int curr;
        int p = 0, q = 0;
        while (p < m || q < n) {
            if (p == m) {
                curr = nums2[q++];
            } else if (q == n) {
                curr = nums1[p++];
            } else if (nums1[p] < nums2[q]) {
                curr = nums1[p++];
            } else {
                curr = nums2[q++];
            }
            sort[p + q - 1] = curr;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
    }

    public void _88_3(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int curr;
        int p = m - 1, q = n - 1;
        while (p > -1 || q > -1) {
            if (p == -1) {
                curr = nums2[q--];
            } else if (q == -1) {
                curr = nums1[p--];
            } else if (nums1[p] < nums2[q]) {
                curr = nums1[p--];
            } else {
                curr = nums2[q--];
            }
            nums1[tail--] = curr;
        }
    }

    public int[] _01_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] _01_2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

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

    public int[] _66(int[] nums) {
        for (int i = nums.length - 1; i > -1; i--) {
            nums[i]++;
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }

    /*
    242.有效的字母异位词
    49.异位词分组
    94.二叉树的中序遍历
    144.二叉树的前序遍历
    589.N叉树的前序遍历
    590.N叉树的后序遍历
    *40.最小的k个数
    *239.滑动窗口最大值
    *347.前K个高频元素
    *77.组合
     */
    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i) - 'a']++;
            counter[s2.charAt(i) - 'a']--;
        }
        for (int cnt : counter) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> _49(String[] strs) {
        Map<Double, List<String>> counter = new HashMap<>();
        for (String str : strs) {
            double key = calc(str);
            List<String> list = counter.computeIfAbsent(key, v -> new ArrayList<>());
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Double key : counter.keySet()) {
            res.add(counter.get(key));
        }

        return res;
    }

    private double calc(String str) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i)];
        }
        return y;
    }

    public List<Integer> _94(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo1(root, res);
        return res;
    }

    private void foo1(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        foo1(node.left, res);
        res.add(node.val);
        foo1(node.right, res);
    }

    public List<Integer> _144(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        foo2(root, res);
        return res;
    }

    private void foo2(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        foo2(node.left, res);
        foo2(node.right, res);
    }

    public List<Integer> _589(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        boo1(root, res);
        return res;
    }

    private void boo1(NTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        if (root.children != null) {
            for (NTreeNode child : root.children) {
                boo1(child, res);
            }
        }
    }

    public List<Integer> _590(NTreeNode root) {
        List<Integer> res = new ArrayList<>();
        boo2(root, res);
        return res;
    }

    private void boo2(NTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (NTreeNode child : root.children) {
                boo2(child, res);
            }
        }
        res.add(root.val);
    }

    public int[] _40_1(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int[] _40_2(int[] nums, int k) {
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

            if (i - q.peekFirst() >= k) {
                q.pollFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public int[] _347_1(int[] nums, int k) {
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
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public int[] _347_2(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o1) - counter.get(o2));
        for (Integer cnt : counter.keySet()) {
            if (q.size() < k) {
                q.add(cnt);
                continue;
            }

            if (q.size() == k) {
                if (counter.get(cnt) <= counter.get(q.peek())) {
                    continue;
                }
                q.remove();
                q.add(cnt);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public List<List<Integer>> _77(int n, int k) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dsf(n, k, 1, path, res);

        return res;
    }

    private void dsf(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 剪枝前
        //for (int i = begin; i <= n; i++) {
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dsf(n, k, i + 1, path, res);
            path.pollLast();
        }
    }
}
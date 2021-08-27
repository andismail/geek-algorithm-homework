package repeat;

import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

/**
 * 2021-08-23
 */
public class Repeat01 {
    /*
     * 26.删除排序数组中的重复项
     * 189.旋转数组
     * 21.合并两个有序链表（升序）
     * 88.合并两个有序数组（非递减顺序）
     * 1.两数之和
     * 283.移动零
     * 66.加一
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

    public void _189(int[] nums, int k) {
        k %= nums.length;

        fo(nums, 0, nums.length - 1);
        fo(nums, k, nums.length - 1);
        fo(nums, 0, k - 1);
    }

    private void fo(int[] nums, int s, int e) {
        while (e > s) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public ListNode _21(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = _21(node1.next, node2);
            return node1;
        }

        node2.next = _21(node1, node2.next);
        return node2;
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
        for (int i = 0; i < sort.length; i++) {
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
            } else if (nums1[p] > nums2[q]) {
                curr = nums1[p--];
            } else {
                curr = nums2[q--];
            }

            nums1[tail--] = curr;
        }
    }

    public int[] _01_1(int[] nums, int target) {
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

    public int[] _01_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
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
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] += 1;
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
        Map<Double, List<String>> counter = new HashMap<>();
        for (String str : strs) {
            double key = calc(str);
            List<String> strings = counter.computeIfAbsent(key, v -> new ArrayList<>());
            strings.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (Double key : counter.keySet()) {
            res.add(counter.get(key));
        }
        return res;
    }

    private double calc(String str) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        double y = 1;
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
        f0(root, res);
        return res;
    }

    private void f0(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        f0(node.left, res);
        f0(node.right, res);
    }

    public List<Integer> _589(Node root) {
        List<Integer> res = new ArrayList<>();
        boo(root, res);
        return res;
    }

    private void boo(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);

        if (node.children != null) {
            for (Node child : node.children) {
                boo(child, res);
            }
        }
    }

    public List<Integer> _590(Node root) {
        List<Integer> res = new ArrayList<>();
        booo(root, res);
        return res;
    }

    private void booo(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                booo(child, res);
            }
        }

        res.add(node.val);
    }

    public int[] _40_1(int[] nums, int k) {
        Arrays.sort(nums);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
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
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }

        return res;
    }

    public int[] _239(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }

            q.addLast(i);

            if (i - q.peekFirst() + 1 > k) {
                q.pollFirst();
            }

            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return res;
    }

    public int[] _347(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>(nums.length);
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o1) - counter.get(o2));
        for (Integer num : counter.keySet()) {
            if (counter.get(num) < counter.get(q.peek()) && q.size() == k) {
                continue;
            }

            q.add(num);

            if (q.size() > k) {
                q.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }

        return res;
    }

    public List<List<Integer>> _77(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();

        coo(n, k, 1, path, res);

        return res;
    }

    private void coo(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            coo(n, k, i + 1, path, res);
            path.pollLast();
        }
    }

}
package repeat;

import common.ListNode;
import common.Node;
import common.TreeNode;

import java.util.*;

/**
 * 十一后
 */
public class Repeat07 {

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
        k = k % nums.length;
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

    public void _88(int[] nums1, int m, int[] nums2, int n) {
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

    public void _283(int[] nums) {
        int p = 0, q = 0;
        for (int i = 0; i < nums.length; i++) {
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
     * 242.有效的字母异位词
     * 49.异位词分组
     * 94.二叉树的中序遍历
     * 144.二叉树的前序遍历
     * 589.N叉树的前序遍历
     * 590.N叉树的后序遍历
     * *40.最小的k个数
     * *239.滑动窗口最大值
     * *347.前K个高频元素
     * *77.组合
     */

    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] chars = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (char c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> _49(String[] strs) {
        Map<Double, List<String>> map = new HashMap<>();
        for (String str : strs) {
            double y = calc(str);
            List<String> list = map.computeIfAbsent(y, v -> new ArrayList<>());
            list.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (Double key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private double calc(String str) {
        int[] x = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        double y = 1;
        for (int i = 0; i < str.length(); i++) {
            y *= x[str.charAt(i) - 'a'];
        }
        return y;
    }

    public List<Integer> _94(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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

    public List<Integer> _589(Node root) {
        List<Integer> res = new ArrayList<>();
        f_589(root, res);
        return res;
    }

    private void f_589(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                f_589(child, res);
            }
        }
    }

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

    public int[] _239(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (i - q.peekFirst() == k) {
                q.removeFirst();
            }
            if (i >= k - 1) {
                res[i + 1 - k] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public List<List<Integer>> _77(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        f_77(n, k, 1, path, res);

        return res;
    }

    private void f_77(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (res.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            f_77(n, k, begin + 1, path, res);
            path.removeLast();
        }
    }
}

package week04;

import common.TreeNode;

import java.util.*;

public class Repeat03 {

    // BFS
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
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    path.add(left);
                }
                if (right != null) {
                    path.add(right);
                }
            }
            res.add(list);
        }
        return res;
    }

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
                if (max == null) {
                    max = node.val;
                }
                max = Math.max(node.val, max);

                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    path.add(left);
                }
                if (right != null) {
                    path.add(right);
                }
            }
            res.add(max);
        }
        return res;
    }

    // greedy
    public int _455(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0, count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                count++;
                start++;
            }
        }
        return count;
    }

    public int _122(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res = res + prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public void _55(int[] nums) {

    }

    public int _69_1(int x) {
        long r = x;
        while (r * r < x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public int _69_2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 0, right = x, ans = -1;
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

    public int _33(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int root = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int realMid = (root + mid) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            }
            if (nums[realMid] > target) {
                right = realMid - 1;
            } else {
                left = realMid + 1;
            }
        }

        return -1;
    }
}
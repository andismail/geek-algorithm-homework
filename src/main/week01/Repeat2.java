package week01;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class Repeat2 {

    public int _26(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 有序数组相同元素肯定相邻
        // 比较相邻两个原素
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p + 1] = nums[q];
                }
                p++;
            }

            q++;
        }

        return p + 1;
    }

    public void _189(int[] nums, int k) {
        k = k % nums.length;
        revert(nums, 0, nums.length - 1);
        revert(nums, 0, k - 1);
        revert(nums, k - 1, nums.length - 1);
    }

    private void revert(int[] nums, int m, int n) {
        while (m < n) {
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
            m++;
            n--;
        }
    }

    public Node _21(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        // 升序返回
        if (n1.val < n2.val) {
            n1.next = _21(n1.next, n2);
            return n1;
        }

        n2.next = _21(n1, n2.next);
        return n2;
    }

    public void _88(int[] nums1, int m, int[] nums2, int n) {
        // 原两个数组为非递减有序
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

    public int[] _01(int[] nums, int target) {
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
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (p == i) {
                    p++;
                    continue;
                }

                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }

    public int[] _66(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i]++;
            nums[i] = nums[i] % 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }

}

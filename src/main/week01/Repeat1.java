package week01;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class Repeat1 {

    private void foo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i == j) {
                    j++;
                    continue;
                }

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }

    private int[] foo1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    private void foo2(int[] nums1, int m, int[] nums2, int n) {
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

    private Node foo3(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        if (n1.val < n2.val) {
            n1.next = foo3(n1.next, n2);
            return n1;
        }

        n2.next = foo3(n1, n2.next);
        return n2;
    }

    private void foo4(int[] nums, int m) {
        m = m % nums.length;
        this.revert(nums, 0, nums.length - 1);
        this.revert(nums, 0, m - 1);
        this.revert(nums, m, nums.length - 1);
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

    private int foo5(int[] nums) {
        int p = 0 , q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}

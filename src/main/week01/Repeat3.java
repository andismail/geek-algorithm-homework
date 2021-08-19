package week01;

import common.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Repeat3 {

    public int _26(int[] nums) {
        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p <= 1) {
                    p++;
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

        revert(nums, 0, nums.length - 1);
        revert(nums, k, nums.length - 1);
        revert(nums, 0, k - 1);
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

    public ListNode _26(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        if (n1.val < n2.val) {
            n1.next = _26(n1.next, n2);
            return n1;
        }

        n2.next = _26(n1, n2.next);
        return n2;
    }

    public void _88_1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
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

    public int[] _01(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
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
            if (nums[i] != 0) {
                if (p == q) {
                    p++;
                    continue;
                }
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;

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
}
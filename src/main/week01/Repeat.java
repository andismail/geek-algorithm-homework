package week01;

import common.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Repeat {

    private int foo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }

            q++;
        }

        return p + 1;
    }

    private void foo1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int p = 0, q = nums.length - 1;
        while (p < q) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }
    }

    private void foo2(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    private ListNode foo3(ListNode n1, ListNode n2) {
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

    private void foo4(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    private void foo5(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int p1 = 0, p2 = 0;
        int curr;
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

    private void foo6(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int curr;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
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

    private int[] foo7(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    private void foo8(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    private void foo9(int[] nums1, int m, int[] nums2, int n) {
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

    private void foo10(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int curr;
        int p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
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

    private int[] foo11(int[] nums1) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums1.length; j++) {
                if (nums1[i] == nums1[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private int foo12(int[] nums) {
        int p = 0, q = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }

        return p + 1;
    }

    private int[] _66(int[] nums) {
        // 10
        // 19
        for (int i = nums.length - 1; i > -1; i--) {
            nums[i]++;
            // 对10取余的值
            nums[i] %= 10;
            if (nums[i] != 0) {
                return nums;
            }
        }
        // 99
        nums = new int[nums.length + 1];
        nums[0] = 1;

        return nums;
    }

}

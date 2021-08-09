package week01;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        //foo(nums1, 3, nums2, 3);
        foo2(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + "\t");
        }


    }

    /**
     * 数组合并后排序
     */
    private static void foo(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    /**
     * 双指针，逐次把小的放到前边
     */
    private static void foo1(int[] nums1, int m, int[] nums2, int n) {
        // 合并后新数组
        int[] sort = new int[m + n];
        int p1 = 0, p2 = 0;
        int curr;
        while (p1 < m || p2 < n) {
            // 如果p1==m意味着nums1中的元素都处理完了，接下来要做的是把nums2中的元素都放到sort中
            if (p1 == m) {
                curr = nums2[p2++];
                // 如果p2==n意味着nums2中的元素都处理完了，接下来要做的是把nums1中的元素都放到sort中
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }

            sort[p1 + p2 - 1] = curr;
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sort[i];
        }
    }

    /**
     * 反向双指针，逐次把大的放到后边
     * 省空间
     */
    private static void foo2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int curr;
        while (p1 > 0 || p2 > 0) {
            if (p1 == -1) {
                curr = nums2[p2--];
            } else if (p2 == -1) {
                curr = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums1[p1--];
            } else {
                curr = nums2[p2--];
            }

            nums1[tail --] = curr;
        }
    }

}

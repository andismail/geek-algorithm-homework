package week01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class LeetCode189 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        foo(nums, 3);
        int[] nums1 = {1, 2};
        foo(nums1, 3);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();

        for (int i : nums1) {
            System.out.print(i + "\t");
        }
    }

    private static void foo(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}

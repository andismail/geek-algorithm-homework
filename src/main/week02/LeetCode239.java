package week02;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class LeetCode239 {

    /**
     * 超时O(n2)
     */
    public static int[] foo(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - k; i++) {
            int max = max(nums, i, i + k - 1);
            res[i] = max;
        }
        return res;
    }

    private static int max(int[] nums, int s, int e) {
        int max = nums[s];
        for (int i = s + 1; i <= e; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

}

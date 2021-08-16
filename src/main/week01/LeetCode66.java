package week01;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one/solution/hua-jie-suan-fa-66-jia-yi-by-guanpengchn/
 */
public class LeetCode66 {

    private static int[] foo(int[] nums) {
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

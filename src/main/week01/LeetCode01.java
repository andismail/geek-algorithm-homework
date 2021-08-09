package week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
 */
public class LeetCode01 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int target = 6;
        int[] foo = foo1(nums, target);
        for (int i : foo) {
            System.out.print(i + "\t");
        }
    }

    /**
     * 时间复杂度O(n2)
     */
    private static int[] foo(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    /**
     * 前题：你可以假设每种输入只会对应一个答案
     */
    private static int[] foo1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}

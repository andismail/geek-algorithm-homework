package week01;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 */
public class LeetCode26 {

    public static void main(String[] args) {

        System.out.println(foo(new int[]{1, 1, 2}));
        System.out.println(foo(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

    }

    private static int foo(int[] nums) {
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
}

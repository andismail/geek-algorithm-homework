package week04;

public class LeetCode55 {

    public static void main(String[] args) {
        int[] f = new int[]{2, 3, 1, 1, 4};
        foo(f);
    }

    public static boolean foo(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }



        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j <= nums[i]; j++) {
                if (i > 1 && !used[i + j - 1]) {
                    return false;
                }
                used[i + j] = true;
                if (used[nums.length - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * dfs时间复杂度为指数级
     * 贪心算法
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean foo0(int[] nums) {
        if (nums == null) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }

        return endReachable == 0;
    }
}

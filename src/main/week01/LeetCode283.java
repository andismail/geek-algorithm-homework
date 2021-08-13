package week01;

/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
 */
public class LeetCode283 {

    public static void main(String[] args) {

    }

    private static void foo(int[] nums) {
        if (nums == null) {
            return;
        }

        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    private static void foo1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果为0时指针j不变，指针i自增，此时指针j指向的值就是当前数组中第一个0的位置
            // 接下来就是交互两个元素
            // 此问题中的特殊情况是数组中都是0或没有0，没有0时指针j、i一直向前跑，都是0时j不变i向前跑
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
}

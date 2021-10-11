package week01;

/**
 * 插入排序
 * 由于「插入排序」在「几乎有序」的数组上表现良好，特别地，在「短数组」上的表现也很好。
 * 因为「短数组」的特点是：每个元素离它最终排定的位置都不会太远。为此，在小区间内执行排序任务的时候，可以转向使用「插入排序」。
 * O(n2)
 */
public class SortInsert {

    public static int[] foo(int[] nums) {
        // 不是从0开始遍历，是因为下边要使用后一个元素和前一个进行比较
        for (int i = 1; i < nums.length; i++) {
            // 循环不变量，第二层循环就是和这个值进行比较，这个值在当前外层循环中没有发生过变化
            int temp = nums[i];
            // 用于标记内层循环比较的开始位置
            int j = i;
            // 使用内层循环和外层这个循环不变量进行比较，
            while (j > 0 && nums[j - 1] > temp) {
                // 如果前其前一个元素小于循环不变量，则开始循环，把前一个元素后移
                nums[j] = nums[j - 1];
                // 重复此循环中内容
                j--;
            }
            // 内层循环退出时需要此操作
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 6, 2, 1, 5};
        foo(nums);
    }

}

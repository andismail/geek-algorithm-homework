package week07;

public class LeetCode912 {
    // O(n2)
    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] < temp) {
                nums[j - 1] = nums[j];
                j --;
            }
            nums[j] = temp;
        }
    }
    // 堆排序
}

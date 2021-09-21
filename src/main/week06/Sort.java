package week06;

import java.util.PriorityQueue;
import java.util.Queue;

public class Sort {

    /**
     * 选择排序
     * o(n2)
     */
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    /**
     * 插入排序
     */
    public static int[] sortArray2(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        sortArray2(nums);

    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            q.add(num);
        }
        int cnt = 0;
        Integer pre = null;
        while (!q.isEmpty()) {
            int val = q.poll();
            pre = pre == null ? val : pre;
            if (val != pre) {
                cnt++;
            }
            if (cnt == k) {
                return val;
            }
        }
        return -1;
    }
}

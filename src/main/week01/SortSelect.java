package week01;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 选择排序
 * O(n2)
 */
public class SortSelect {

    public int[] foo(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] foo1(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
        }
        int[] res = new int[nums.length];
        int i = 0;
        while (!q.isEmpty()) {
            res[i] = q.poll();
            i++;
        }
        return res;
    }
}

package week02;

import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class LeetCode239 {

    /**
     * 超时O(n2)
     */
    public int[] foo(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - k; i++) {
            int max = max(nums, i, i + k - 1);
            res[i] = max;
        }
        return res;
    }

    private int max(int[] nums, int s, int e) {
        int max = nums[s];
        for (int i = s + 1; i <= e; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    /**
     * 双端单调队列
     * 重点在于：
     * 1.双端队列
     * 2.单调队列
     * 3.存入队列的值为数据下标
     */
    public static int[] f00(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首是否该从窗口中移出
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

}
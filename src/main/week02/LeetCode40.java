package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 */
public class LeetCode40 {

    /**
     * 排序
     */
    public int[] foo(int[] arr, int k) {
        if (arr == null) {
            return null;
        }
        if (k <= 0) {
            return new int[]{};
        }

        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 小顶堆
     */
    public int[] foo1(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[]{};
        }
        if (k > arr.length) {
            return arr;
        }

        Queue<Integer> minQueue = new PriorityQueue<>(new ArrayList<>());
        for (int i : arr) {
            minQueue.add(i);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minQueue.poll();
        }

        return res;
    }

}

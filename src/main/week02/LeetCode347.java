package week02;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 前K个高频元素
 */
public class LeetCode347 {

    /**
     * 计数
     */
    public int[] topKFrequent1(int[] nums, int k) {
        return null;
    }

    /**
     * 小顶堆
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        // 意思是这个堆是由map中的值决定的？
        // 升序，小顶堆
        Queue<Integer> q = new PriorityQueue<>((k1, k2) -> counter.get(k1) - counter.get(k2));
        for (Integer key : counter.keySet()) {
            // 不写q.size() <= k是因为如果这么写会导致进到此分支最终导致queue中多了一个元素
            if (q.size() < k) {
                q.add(key);
                continue;
            }

            if (counter.get(key) > counter.get(q.peek())) {
                q.remove();
                q.add(key);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = q.poll();
        }
        return res;
    }

}

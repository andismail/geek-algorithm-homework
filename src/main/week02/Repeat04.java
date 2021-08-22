package week02;

import java.util.*;

/**
 * 40.最小的k个数
 * 347.前K个高频元素
 */
public class Repeat04 {

    public int[] _40_1(int[] nums, int k) {
        Arrays.sort(nums);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int[] _40_2(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }

    public int[] _347(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o1) - counter.get(o2));
        for (Integer num : counter.keySet()) {
            if (q.size() < k) {
                q.add(num);
                continue;
            }

            if (counter.get(num) > counter.get(q.peek())) {
                q.remove();
                q.add(num);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}

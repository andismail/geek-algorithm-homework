package week03;

import java.util.*;

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        for (Integer num : counter.keySet()) {
            Integer cnt = counter.get(num);
            if (cnt > nums.length / 2) {
                return num;
            }
        }

        throw new RuntimeException();
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            Integer cnt = counter.computeIfAbsent(num, v -> 0);
            counter.put(num, cnt + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> counter.get(o2) - counter.get(o1));
        for (int num : nums) {
            q.add(num);
        }

        return q.peek();
    }

    public int foo(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int cnt = counter.computeIfAbsent(num, v -> 0);
            if (cnt > nums.length / 2) {
                return num;
            }
            counter.put(num, cnt + 1);
        }

        throw new RuntimeException();
    }

    // 因为此题目中一定会有众数，所以排序后无论众数出现在前半段还是后半段，n/2都是那个众数
    public int foo1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

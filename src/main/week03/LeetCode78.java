package week03;

import java.util.*;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        // 集合中原素个数
        for (int i = 1; i <= nums.length; i++) {
            Deque<Integer> path = new ArrayDeque<>();

            foo(nums, i, 0, path, res);
        }

        return res;
    }

    private void foo(int[] nums, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // i <= n - (k - q.size) + 1

        for (int i = start; i < nums.length - (k - path.size()) + 1; i++) {
            path.add(nums[i]);
            foo(nums, k, i + 1, path, res);
            path.removeLast();
        }
    }
}

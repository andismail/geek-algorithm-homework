package week05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCodeM {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        foo(nums, 0, target, 0, path, res);
        return res;
    }

    private void foo(int[] nums, int begin, int target, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (4 == path.size() && sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (4 == path.size()) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[begin]);
            sum += nums[begin];
            foo(nums, i + 1, target, sum, path, res);
            path.removeLast();
            sum -= nums[begin];
        }
    }

}

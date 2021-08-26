package week03;

import java.util.*;

public class LeetCode47 {

    public static  List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(nums);

        foo(nums, used, path, res);
        return res;
    }

    private static void foo(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            foo(nums, used, path, res);

            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        permuteUnique(new int[]{1,1,2});

    }
}

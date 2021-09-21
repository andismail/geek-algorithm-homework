package common;

import java.util.*;

public class Foo2 {

    public static List<List<Integer>> foo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boo(nums, used, path, res);
        return res;
    }

    private static void boo(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

/*
            if (i > 0 && !used[i - 1]) {
                continue;
            }
*/

            path.add(nums[i]);
            used[i] = true;
            boo(nums, used, path, res);
            used[i] = false;
            path.remove();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,2};
        List<List<Integer>> res = foo(nums);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


}

package week02;

import java.util.HashMap;
import java.util.Map;

public class LeetCode01 {

    private int[] foo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

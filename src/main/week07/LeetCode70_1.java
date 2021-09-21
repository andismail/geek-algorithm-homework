package week07;

import java.util.HashMap;
import java.util.Map;

public class LeetCode70_1 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        Integer res = cache.get(n);
        if (res != null) {
            return res;
        }

        res = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, res);

        return res;
    }
}

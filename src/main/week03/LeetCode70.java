package week03;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 */
public class LeetCode70 {

    Map<Integer, Integer> cache = new HashMap<>();

    /**
     * 递归
     * f(n) = f(n -1) + f(n -2)
     */
    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (cache.get(n) != null) {
            return cache.get(n);
        }

        int res = f(n - 1) + f(n - 2);
        cache.put(n, res);
        return res;
    }

    /**
     * 动态规划
     */
}

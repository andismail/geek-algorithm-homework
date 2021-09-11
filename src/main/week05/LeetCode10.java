package week05;

import java.util.HashMap;
import java.util.Map;

public class LeetCode10 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        Integer n2 = cache.get(n - 2);
        if (n2 == null) {
            n2 = fib(n - 2);
            cache.put(n - 2, n2);
        }
        Integer n1 = cache.get(n - 1);
        if (n1 == null) {
            n1 = fib(n - 1);
        }

        return (n1 + n2) % 1000000007;
    }

    public int fib_2(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


}

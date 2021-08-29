package week04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode322 {

    public static void main(String[] args) {
        coinChange(new int[]{1, 2147483647}, 2);

    }

    public static int coinChange(int[] coins, int amount) {
        Deque<Double> path = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        f(coins, amount, 0, path, res);
        if (res.size() == 0) {
            return -1;
        }
        int min = res.get(0);
        for (Integer cnt : res) {
            min = Math.min(min, cnt);
        }
        return min;
    }

    private static void f(int[] coins, int amount, double y, Deque<Double> path, List<Integer> res) {
        if (y == amount) {
            res.add(path.size());
            return;
        }

        if (y > amount) {
            return;
        }

        for (int coin : coins) {
            y += coin;
            path.add(coin + 0D);
            f(coins, amount, y, path, res);
            path.removeLast();
            y -= coin;
        }
    }
}

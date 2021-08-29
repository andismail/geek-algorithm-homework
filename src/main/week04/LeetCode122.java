package week04;

public class LeetCode122 {

    public int foo(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        dfs(prices, 0, 0, 0);
        return res;
    }

    int res;

    private void dfs(int[] prices, int begin, int status, int profile) {
        if (begin == prices.length) {
            res = Math.max(profile, res);
            return;
        }

        for (int i = begin; i < prices.length; i++) {

            if (status == 0) {
                dfs(prices, i + 1, 1, prices[i] - profile);
            }

            if (status == 1) {
                dfs(prices, i + 1, 0, prices[i] + profile);
            }
        }

    }
}

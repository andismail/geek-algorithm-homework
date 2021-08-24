package week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class LeetCode22 {

    /**
     * 回溯
     */
    public static List<String> foo(int n) {
        List<String> res = new ArrayList<>();

        //dfs(n, n, "", res);
        dfs2(0, 0, n, "", res);

        return res;
    }

    /**
     * 减法
     */
    private void dfs(int left, int right, String curStr, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剩下的左括号大于右括号时说明右括号放多了，这种情况不对，需要剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, curStr + "(", res);
        }

        if (right > 0) {
            dfs(left, right - 1, curStr + ")", res);
        }
    }

    private static void dfs2(int left, int right, int n, String curStr, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs2(left + 1, right, n, curStr + "(", res);
        }

        if (right < n) {
            dfs2(left, right + 1, n, curStr + ")", res);
        }
    }

    public static void main(String[] args) {
        List<String> res = foo(2);
    }
}

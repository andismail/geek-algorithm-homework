package week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repeat01 {

    Map<Integer, Integer> map = new HashMap<>();

    public int _70(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (map.get(n) != null) {
            return map.get(n);
        }

        int res = _70(n - 1) + _70(n - 2);
        map.put(n, res);
        return res;
    }

    public List<String> _22(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);

        dfs2(n, 0, 0, "", res);

        return res;
    }

    private void dfs(int left, int right, String curStr, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left < right) {
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, curStr + "(", res);
        }
        if (right > 0) {
            dfs(left, right - 1, curStr + ")", res);
        }
    }

    private void dfs2(int n, int left, int right, String curStr, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            dfs2(n, left + 1, right, curStr + "(", res);
        }

        if (right < n) {
            dfs2(n, left, right + 1, curStr + ")", res);
        }
    }
}

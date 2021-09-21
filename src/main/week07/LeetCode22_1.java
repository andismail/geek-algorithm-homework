package week07;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22_1 {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        f_22(n, 0, 0, "", res);
        return res;
    }

    private void f_22(int n, int lc, int rc, String curStr, List<String> res) {
        if (curStr.length() == n * 2) {
            res.add(curStr);
            return;
        }

        if (rc > lc) {
            return;
        }

        if (lc < n) {
            f_22(n, lc + 1, rc, curStr + "(", res);
        }
        if (rc < n) {
            f_22(n, lc, rc + 1, curStr + ")", res);
        }
    }
}

package week04;

import java.util.Arrays;

public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int start = 0, count = 0;

        for (int i = 0; i < g.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }

        return count;
    }

}

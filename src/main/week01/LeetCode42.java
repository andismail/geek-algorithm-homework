package week01;

public class LeetCode42 {

    public int trap(int[] height) {
        int ans = 0;
        int maxLevel = maxLevel(height);

        for (int level = 1; level < maxLevel; level++) {
            boolean start = false;
            int save = 0;
            for (int wall : height) {
                if (!start && wall > level) {
                    start = true;
                    continue;
                }
                if (!start) {
                    continue;
                }

                if (wall < level) {
                    save++;
                } else {
                    ans += save;
                    save = 0;
                }
            }
        }
        return ans;
    }

    private int maxLevel(int[] height) {
        int max = 0;
        for (int num : height) {
            max = Math.max(num, max);
        }
        return max;
    }
}

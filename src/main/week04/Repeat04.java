package week04;

public class Repeat04 {

    public boolean _55(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {
                max = Math.max(i + nums[i], max);
            }
            if (max >= nums.length) {
                return true;
            }
        }
        return false;
    }

    public int _69_1(long x) {
        long r = x;
        while (r * r > x) {
            r = (r - x / r) / 2;
        }
        return (int) r;
    }

    public int _69_2(int x) {
        int left = 1, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int y = x / mid;
            if (mid == y) {
                return  mid;
            }
            if (mid < y) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Repeat04 r = new Repeat04();
        r.mySqrt(8);
    }
}

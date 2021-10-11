package week03;

public class LeetCode50 {

    // time out
    // O(n)
    public double foo0(double x, int n) {
        double y = 1d;
        if (n == 0) {
            return 1;
        }

        int loop = n > 0 ? n : n * -1;
        for (int i = 1; i <= loop; i++) {
            y *= x;
        }

        return n > 0 ? y : 1 / y;
    }

    // stack overflow
    public static double foo(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / (x * foo(x, -1 * n - 1));
        }

        return x * foo(x, n - 1);
    }

    // 分治 logn
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double y;
        if (n > 0) {
            y = boo(x, n);
        } else {
            y = 1 / boo(x, -n);
        }

        return y;
    }

    private double boo(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double y = boo(x, n / 2);
        return n % 2 == 0 ? y * y : x * y * y;
    }

    public static void main(String[] args) {
        LeetCode50 l = new LeetCode50();
        System.out.println(l.myPow(2, 32)/2);
        System.out.println(l.myPow(2, 31));
        System.out.println(Long.MAX_VALUE);
    }
}

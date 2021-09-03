package common.test;

public class TestClass {

    public static void main(String[] args) {
        //SubClass sub = new SubClass();
        System.out.println(foo(10));
        System.out.println(2 << 5);
        System.out.println(2 << 4);
        System.out.println(hash("AAAAAAAAAAA"));
        System.out.println(hash("AAAAAAAAAAA") & 15);

        System.out.println(185 % 16);
        System.out.println(185 / 16);
        System.out.println(16 * 11);
        System.out.println(185 & 15);
        System.out.println("***********");
        System.out.println(4 >> 2);
        System.out.println(4 >>> 2);
        System.out.println(-4 >> 2);
        System.out.println(-1151958793 >>> 2);

    }

    private static int foo(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}

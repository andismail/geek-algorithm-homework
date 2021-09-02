package week04;

import common.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串数字相加
 */
public class LeetCode415 {
    public static String foo(String n1, String n2) {
        if (n1 == null || n1.length() == 0) {
            return n2;
        }
        if (n2 == null || n2.length() == 0) {
            return n1;
        }

        List<Integer> list = new ArrayList<>();
        int up = 0, stay = 0;
        for (int i = n1.length() - 1, j = n2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            String s1 = i < 0 ? "0" : String.valueOf(n1.charAt(i));
            String s2 = j < 0 ? "0" : String.valueOf(n2.charAt(j));
            int num = Integer.parseInt(s1) + Integer.parseInt(s2) + up;
            stay = num % 10;
            list.add(stay);
            up = num / 10;
        }
        if (up > 0) {
            list.add(up);
        }

        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i));

        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(foo("99999999999", "0"));

        float f1 = 0.3f, f2 = 0.1f;
        System.out.println((f1 - f2 + ""));
        System.out.println((f1 - f2 + "").length());
        double d1 = 0.3d, d2 = 0.1d;
        System.out.println((d1 - d2 + ""));
        System.out.println((d1 - d2 + "").length());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("1".equals(s)) {
                list.remove(s);
            }
        }
    }
}

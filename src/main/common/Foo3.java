package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Foo3 {

    public static void main(String[] args) {
        // '1b' + '2x' = '48'
        // 47

        System.out.println(sum("1b", "1b"));
    }

    private static int sum(String s1, String s2) {
        int res1 = foo(s1.toCharArray());
        int res2 = foo(s2.toCharArray());
        return res1 + res2;
    }

    private static int foo(char[] charArray) {
        Map<Character, Integer> digit = new HashMap<>();
        digit.put('1', 1);
        Map<Character, Integer> letter = new HashMap<>();
        letter.put('a', 10);
        letter.put('b', 11);

        int res = 0;
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (digit.containsKey(c)) {
                res += digit.get(c) * Math.pow(36, len - i - 1);
            }
            if (letter.containsKey(c)) {
                int num = letter.get(c);
                res += num * Math.pow(36, len - i - 1);
            }
        }

        return res;
    }
}

package week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repeat01 {

    public boolean _242(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i) - 'a']++;
            counter[s2.charAt(i) - 'a']--;
        }

        for (int cnt : counter) {
            if (cnt != 0) {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> _49(List<String> strs) {
        int[] x = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {

            long y = 1L;
            for (int i = 0; i < str.length(); i++) {
                y = y * x[str.charAt(i) - 'a'];
            }

            List<String> list = map.computeIfAbsent(y, k -> new ArrayList<>());
            list.add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Long key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}

package week02;

import java.util.*;

/**
 * 字母异位词分组
 */
public class LeetCode49 {

    public List<List<String>> foo(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }

                if (isFoo(strs[i], strs[j])) {
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }

        return res;
    }

    private boolean isFoo(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] s = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s[s1.charAt(i) - 'a']++;
            s[s2.charAt(i) - 'a']--;
        }
        for (int i : s) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> foo1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
                continue;
            }
            List<String> value = new ArrayList<>();
            value.add(strs[i]);
            map.put(key, value);
        }

        List<List<String>> restList = new ArrayList<>();
        for (String key : map.keySet()) {
            restList.add(map.get(key));
        }

        return restList;
    }

}
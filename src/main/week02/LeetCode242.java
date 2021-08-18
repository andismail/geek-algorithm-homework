package week02;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
 */
public class LeetCode242 {

    public boolean foo(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i) - 'a']++;
            counter[s2.charAt(i) - 97]--;
        }

        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean foo1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            counter.put(s1.charAt(i), counter.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            counter.put(s2.charAt(i), counter.getOrDefault(s2.charAt(i), 0) - 1);

            if (counter.get(s2.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}

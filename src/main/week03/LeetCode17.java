package week03;

import java.util.*;

public class LeetCode17 {

    static Map<Character, List<String>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }


    public List<String> letterCombinations(String digits) {
        if (Objects.equals("", digits)) {
            return new ArrayList<>();
        }

        int len = digits.length();
        for (char c : digits.toCharArray()) {
            if (c == '1' || c == '0') {
                len--;
            }
        }

        List<String> res = new ArrayList<>();

        fo(digits, len, 0, "", res);

        return res;
    }

    private void fo(String digits, int len, int digitsBegin, String curStr, List<String> res) {
        if (curStr.length() == len) {
            res.add(curStr);
            return;
        }

        for (int i = digitsBegin; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            if (digit == '1' || digit == '0') {
                continue;
            }

            List<String> letters = map.get(digit);
            for (String letter : letters) {
                fo(digits, len, i + 1, curStr + letter, res);
            }
        }
    }


}

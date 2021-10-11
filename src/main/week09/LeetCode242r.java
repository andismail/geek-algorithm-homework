package week09;

public class LeetCode242r {

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        char[] charArray = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            charArray[s1.charAt(i) - 'a']++;
            charArray[s2.charAt(i) - 'a']--;
        }
        for (char c : charArray) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}

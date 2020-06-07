package problems._05_longest_palindromic_substring;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-04 20:21
 **/
public class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < left && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < length && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        int maxStart = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[length][length];
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                    }
                }
            }
        }
        return s.substring(maxStart, maxLen + maxStart - 1);
    }
}

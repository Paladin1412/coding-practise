package problems._03_longest_substring_without_repeating_characters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-06-02 20:04
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (indexMap.containsKey(aChar) && indexMap.get(aChar) >= start) {
                start = indexMap.get(aChar) + 1;
            } else {
                maxLen = Math.max(maxLen, i - start + 1);
            }
            indexMap.put(aChar, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "tmmzuxt";
        new Solution().lengthOfLongestSubstring(str);
    }
}

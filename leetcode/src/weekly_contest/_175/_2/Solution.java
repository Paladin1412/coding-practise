package weekly_contest._175._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-09 10:44
 **/
public class Solution {
    public int minSteps(String s, String t) {
        int[] numS = new int[26];
        int[] numT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            numS[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            numT[t.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            numS[i] = numS[i] - numT[i];
            sum += Math.abs(numS[i]);
        }
        return sum / 2;
    }
}

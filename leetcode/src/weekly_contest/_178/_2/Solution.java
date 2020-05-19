package weekly_contest._178._2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-02 11:01
 **/
public class Solution {
    public String rankTeams(String[] votes) {
        int[][] tmp = new int[26][votes[0].length() + 1];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                tmp[c - 'A'][0] = c - 'A' + 1;
                tmp[c - 'A'][i + 1]++;
            }
        }
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = 1;
                while (i < o1.length) {
                    if (o1[i] > o2[i]) {
                        return -1;
                    } else if (o1[i] < o2[i]) {
                        return 1;
                    }
                    i++;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        String res = "";
        for (int[] ints : tmp) {
            if (ints[0] != 0) {
                res += String.valueOf((char) (ints[0] - 1 + 'A'));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
        new Solution().rankTeams(votes);
    }
}
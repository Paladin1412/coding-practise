package weekly_contest._164._4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-11-24 11:24
 **/
public class Solution {
    public int numWays(int steps, int arrLen) {
        long res = 0L;
        Map<String, Long> tmp = new HashMap<>();
        res += numWaysOneToOne(0, 0, steps, arrLen, tmp);
        return (int) res % (int) (Math.pow(10, 9) + 7);
    }

    long numWaysOneToOne(int from, int to, int steps, int arrlen, Map<String, Long> tmp) {
        String s = from + "," + to + "," + steps;
        if (tmp.containsKey(s)) {
            return tmp.get(s);
        }
        if (steps == 0 && from == to) {
            return 1;
        } else if (steps == 0) {
            return 0;
        }
        long res = 0L;
        res += numWaysOneToOne(from, to, steps - 1, arrlen, tmp)% (int) (Math.pow(10, 9) + 7);
        if (to < arrlen - 1) {
            res += numWaysOneToOne(from, to + 1, steps - 1, arrlen, tmp)% (int) (Math.pow(10, 9) + 7);
        }
        if (to > 0) {
            res += numWaysOneToOne(from, to - 1, steps - 1, arrlen, tmp)% (int) (Math.pow(10, 9) + 7);
        }
        tmp.put(s, res);
        return res % (int) (Math.pow(10, 9) + 7);
    }

    public static void main(String[] args) {
        int steps = 93;
        int arrlen = 85;
        System.out.println(new Solution().numWays(steps, arrlen));
    }
}

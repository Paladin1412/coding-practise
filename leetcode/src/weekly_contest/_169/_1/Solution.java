package weekly_contest._169._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-29 10:39
 **/
public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                res[2 * (i - 1)] = i;
                res[2 * (i - 1) + 1] = -i;
            }
        } else {
            res[0] = 0;
            for (int i = 1; i <= n / 2; i++) {
                res[2 * i] = i;
                res[2 * (i - 1) + 1] = -i;
            }
        }
        return res;
    }
}

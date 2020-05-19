package weekly_contest._166._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-08 11:08
 **/
public class Solution {
    public int subtractProductAndSum(int n) {
        int tmp = n;
        int r1 = 1;
        int r2 = 0;
        while (tmp / 10 > 0 || tmp % 10 > 0) {
            r1 *= tmp % 10;
            r2 += tmp % 10;
            tmp = tmp / 10;
        }
        return r1 - r2;
    }
}

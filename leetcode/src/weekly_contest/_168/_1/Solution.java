package weekly_contest._168._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-22 10:31
 **/
public class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int len = 0;
            while (num / 10 != 0) {
                num /= 10;
                len++;
            }
            len++;
            if (len % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}

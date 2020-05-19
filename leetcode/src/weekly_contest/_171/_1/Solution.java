package weekly_contest._171._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-01-12 10:37
 **/
public class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if(has0(i)||has0(n-i)){
                continue;
            }
            res[0] = i;
            res[1] = n - i;
            return res;
        }
        return res;
    }

    public boolean has0(int value){
        while (value / 10 > 0) {
            if (value % 10 == 0) {
                return true;
            }
            value = value / 10;
        }
        return false;
    }
}

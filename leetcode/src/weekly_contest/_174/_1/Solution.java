package weekly_contest._174._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-02 19:09
 **/
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] tmp = new int[mat.length];
        int sum = 0;
        int i = 0;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                sum += anInt;
            }
            tmp[i++] = sum;
            sum = 0;
        }
        i = 0;
        int[] res = new int[k];
        while (k-- > 0) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] < min) {
                    min = tmp[j];
                    index = j;
                }
            }
            tmp[index] = Integer.MAX_VALUE;
            res[i++] = index;
        }
        return res;
    }
}

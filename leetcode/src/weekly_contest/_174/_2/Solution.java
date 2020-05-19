package weekly_contest._174._2;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-02 19:30
 **/
public class Solution {
    public int minSetSize(int[] arr) {
        int len = 0;
        for (int i : arr) {
            if (i > len) {
                len = i;
            }
        }
        int[] tmp = new int[len];
        for (int i : arr) {
            tmp[i - 1]++;
        }
        Arrays.sort(tmp);
        int k = 0;
        int sum = arr.length;
        for (int i = tmp.length - 1; i >= 0; i--) {
            sum = sum - tmp[i];
            k++;
            if (sum <= arr.length / 2) {
                return k;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        new Solution().minSetSize(arr);
    }
}

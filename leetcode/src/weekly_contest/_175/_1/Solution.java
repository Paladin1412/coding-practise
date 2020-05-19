package weekly_contest._175._1;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-09 10:35
 **/
public class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                if (arr[j] == 2 * arr[i] || 2 * arr[j] == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 5, 3};
        new Solution().checkIfExist(arr);
    }
}

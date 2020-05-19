package weekly_contest._169._3;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-29 10:48
 **/
public class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        int num = arr[start];
        arr[start] = -1;
        if (num == 0) {
            return true;
        }
        if (num == -1) {
            return false;
        }
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}

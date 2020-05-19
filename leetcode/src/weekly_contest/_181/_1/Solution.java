package weekly_contest._181._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-22 10:35
 **/
public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            int j = res.length - 1;
            while (j > index[i]) {
                res[j] = res[j - 1];
                j--;
            }
            res[index[i]] = nums[i];
        }
        return res;
    }
}

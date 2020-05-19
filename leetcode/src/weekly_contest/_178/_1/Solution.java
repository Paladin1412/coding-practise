package weekly_contest._178._1;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-02 10:50
 **/
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[j] < nums[i]) {
                    tmp++;
                }
            }
            res[i] = tmp;
        }
        return res;
    }
}

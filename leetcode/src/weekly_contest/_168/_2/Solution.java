package weekly_contest._168._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-22 10:35
 **/
public class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            if (numsMap.containsKey(num)) {
                numsMap.put(num, numsMap.get(num) + 1);
            } else {
                numsMap.put(num, 1);
            }
        }
        int len = nums.length;
        if (len % k != 0) {
            return false;
        } else {
            while (len != 0) {
                len = len - k;
                for (int i = 0; i < k; i++) {
                    if (!numsMap.containsKey(min + i) || numsMap.get(min + i) <= 0) {
                        return false;
                    } else {
                        numsMap.put(min + i, numsMap.get(min + i) - 1);
                    }
                }
                if (numsMap.get(min) == 0) {
                    for (int i = 1; i <= max - min; i++) {
                        if (numsMap.containsKey(min + i) && numsMap.get(min + i) > 0) {
                            min = min + i;
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        int k = 4;
        new Solution().isPossibleDivide(nums, k);
    }
}
